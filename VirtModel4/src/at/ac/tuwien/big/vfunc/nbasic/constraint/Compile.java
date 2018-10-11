/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package at.ac.tuwien.big.vfunc.nbasic.constraint;

/* [java-8] */

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.reflect.Field;
import java.net.URI;
import java.nio.file.Files;
import java.security.SecureClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.tools.FileObject;
import javax.tools.ForwardingJavaFileManager;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileManager.Location;
import javax.tools.JavaFileObject.Kind;
import javax.tools.SimpleJavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.StandardLocation;
import javax.tools.ToolProvider;
import javax.tools.JavaCompiler.CompilationTask;

import org.joor.Reflect;
import org.joor.ReflectException;

import at.ac.tuwien.big.compilerServer.CompileServer;

// ...

/**
 * A utility that simplifies in-memory compilation of new classes.
 *
 * @author Lukas Eder
 */
public class Compile {

	public static class AddClassLoader extends ClassLoader {
		
		private ClassLoader parent;
		
		public AddClassLoader(ClassLoader parent) {
			super(parent);
			this.parent = parent;
		}
		
		private Map<String, Class<?>> knownClasses = new HashMap<>();
		
		public void makeKnown(String cl, Class<?> c) {
			knownClasses.put(cl, c);
		}
		
		public Class<?> computeIfAbsent(String name, byte[] content) {
			return knownClasses.computeIfAbsent(name,nm->{
			try {
				return Reflect.on(this).call("defineClass", nm, content,
						0, content.length).get();
				} catch (Exception e) {
					System.err.println("Could not define class "+nm+": "+e.getMessage());
					return null;
				}
			});
		}
		
		
	}

	static final class CharSequenceJavaFileObject extends SimpleJavaFileObject {
		final CharSequence content;

		public CharSequenceJavaFileObject(String className, CharSequence content) {
			super(new File(className.replace('.', '/') + JavaFileObject.Kind.SOURCE.extension).toURI(),
					JavaFileObject.Kind.SOURCE);
			this.content = content;
		}

		@Override
		public CharSequence getCharContent(boolean ignoreEncodingErrors) {
			return this.content;
		}
	}

	static final class ClassFileManager extends ForwardingJavaFileManager<StandardJavaFileManager> {
		javax.tools.JavaFileObject o;

		ClassFileManager(StandardJavaFileManager standardManager) {
			super(standardManager);
		}

		@Override
		public javax.tools.JavaFileObject getJavaFileForOutput(JavaFileManager.Location location, String className,
				JavaFileObject.Kind kind, FileObject sibling) {
			try {
				return this.o = super.getJavaFileForOutput(location, className, kind, sibling);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
	}

	static final class JavaFileObject extends SimpleJavaFileObject {
		final ByteArrayOutputStream os = new ByteArrayOutputStream();

		JavaFileObject(String name, JavaFileObject.Kind kind) {
			super(new File(name.replace('.', '/') + kind.extension).toURI(), kind);
		}

		byte[] getBytes() {
			return this.os.toByteArray();
		}

		@Override
		public OutputStream openOutputStream() {
			return this.os;
		}
	}
	
	static ClassFileManager fileManager;
	
	private static Location somewhere = StandardLocation.SOURCE_OUTPUT;/*new Location() {
		
		@Override
		public String getName() {
			//Absichtlich nicht src-gen!
			return "gen-src";
		}
		
		@Override
		public boolean isOutputLocation() {
			return true;
		}
	};*/
	
	static {
		new File("gen-src").mkdirs();	
	}

	private static AddClassLoader addLoader = new AddClassLoader(Compile.class.getClassLoader());

	public static Map<String, Class<?>> compile(List<Map.Entry<String, String>> classnamesToContent) {
		return CompileServer.getCompiledClasses(classnamesToContent);
		//return compile(classnamesToContent, null);
	}
			
	
	public static Map<String, Class<?>> compile(List<Map.Entry<String, String>> classnamesToContent, Map<String, List<byte[]>> byteMap) {
		if (byteMap == null) {
			byteMap = new HashMap<String, List<byte[]>>();
		}
		Lookup lookup = MethodHandles.lookup();
		List<javax.tools.JavaFileObject> files = new ArrayList<>();
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		if (fileManager == null) {
			fileManager = new ClassFileManager(compiler.getStandardFileManager(null, null, null));
		}
		Map<String, javax.tools.JavaFileObject> jfomap = new HashMap<>();
		for (Entry<String, String> entr : classnamesToContent) {
			try {
				addLoader.loadClass(entr.getKey());
				System.err.println("Class "+entr.getKey()+" already exists!");
				throw new ClassNotFoundException();
			} catch (ClassNotFoundException ignore) {
				Location loc = null;
				try {
					{
						javax.tools.JavaFileObject javaFileForInput = fileManager
								.getJavaFileForOutput(somewhere, entr.getKey(), Kind.SOURCE, null);
						try (OutputStream os = javaFileForInput.openOutputStream()) {
							os.write(entr.getValue().getBytes());
						}
						files.add(javaFileForInput);
						jfomap.put(entr.getKey(), javaFileForInput);
					}

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		List<String> options = new ArrayList<>();
		File addFile = new File("E:\\export\\virtres\\virtres.jar");
		if (addFile.exists()) {
			try {
				options.addAll(Arrays.asList("-classpath",System.getProperty("java.class.path")+";"+addFile.getCanonicalPath()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		CompilationTask ct = compiler.getTask(null, fileManager, null, options, null, files);

		ct.call();

		for (Entry<String, String> entr : classnamesToContent) {
			//if (ret.containsKey(entr.getKey())) {continue;}
			try {
				Class<?> result = null;
				javax.tools.JavaFileObject javaFileForInput = fileManager
						.getJavaFileForOutput(somewhere, entr.getKey(), Kind.CLASS, null);
				// This works if we have private-access to the interfaces in the
				// class hierarchy
				Field f = Reflect.class.getDeclaredField("CACHED_LOOKUP_CONSTRUCTOR");
				f.setAccessible(true);
				if (f.get(null) != null) {
					ClassLoader cl = addLoader;
					Field fileField = javaFileForInput.getClass().getDeclaredField("file");
					fileField.setAccessible(true);
					File file = (File) fileField.get(javaFileForInput);
					
					byte[] b =Files.readAllBytes(file.toPath());
					List<byte[]> bytesList = new ArrayList<>();
					bytesList.add(b);
					int i = 1;
					for(;;)  {
						File next = new File(file.getCanonicalPath().substring(0,file.getCanonicalPath().length()-".class".length())+"$"+i+".class");
						if (next.exists()) {
							byte[] sb =Files.readAllBytes(next.toPath());
							bytesList.add(sb);
							++i;
						} else {
							break;
						}
					}
					byteMap.put(entr.getKey(), bytesList);
				}
				/*jfomap.get(entr.getKey()).delete();
				javaFileForInput.delete();*/
			} catch (Exception e) {
				throw new ReflectException("Error while compiling " + entr.getKey(), e);
			}
		}
		return fromClassMap(byteMap);
	}
	
	public static Map<String,Class<?>> fromClassMap(Map<String,List<byte[]>> bytesList) {
		ClassLoader cl = addLoader;
		Map<String,Class<?>> ret = new HashMap<>();
		for (Entry<String,List<byte[]>> entr: bytesList.entrySet()) {
			List<byte[]> bl = entr.getValue();
			if (bl.isEmpty()) {continue;}
			for (int i = 1; i < bl.size(); ++i) {
				byte[] sb = bl.get(i);
				addLoader.computeIfAbsent(entr.getKey()+"$"+i, sb);
			}
			byte[] main = bl.get(0);
			try {
				Class<?> result = addLoader.computeIfAbsent(entr.getKey(), main);
				ret.put(entr.getKey(), result);
			} catch (Exception e) {
				System.err.println("Could not define class "+entr.getKey()+": "+e.getMessage());
			}
		}
		return ret;
	}
}
/* [/java-8] */
