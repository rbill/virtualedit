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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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

// ...

/**
 * A utility that simplifies in-memory compilation of new classes.
 *
 * @author Lukas Eder
 */
class Compile {

	public static class AddClassLoader extends ClassLoader {
		
		private ClassLoader parent;
		
		public AddClassLoader(ClassLoader parent) {
			super(parent);
			this.parent = parent;
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

	private static ClassLoader addLoader = new AddClassLoader(Compile.class.getClassLoader());

	static Map<String, Class<?>> compile(List<Map.Entry<String, String>> classnamesToContent) {
		Lookup lookup = MethodHandles.lookup();
		Map<String, Class<?>> ret = new HashMap<>();
		List<javax.tools.JavaFileObject> files = new ArrayList<>();
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		if (fileManager == null) {
			fileManager = new ClassFileManager(compiler.getStandardFileManager(null, null, null));
		}
		Map<String, javax.tools.JavaFileObject> jfomap = new HashMap<>();
		for (Entry<String, String> entr : classnamesToContent) {
			try {
				ret.put(entr.getKey(), addLoader.loadClass(entr.getKey()));
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

		CompilationTask ct = compiler.getTask(null, fileManager, null, null, null, files);

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
					int i = 1;
					for(;;)  {
						File next = new File(file.getCanonicalPath().substring(0,file.getCanonicalPath().length()-".class".length())+"$"+i+".class");
						if (next.exists()) {
							byte[] sb =Files.readAllBytes(next.toPath());
							Reflect.on(cl).call("defineClass", entr.getKey()+"$"+i, sb,
									0, sb.length).get();
							++i;
						} else {
							break;
						}
					}
					result = Reflect.on(cl).call("defineClass", entr.getKey(), b,
					0, b.length).get();
					ret.put(entr.getKey(), result);
				}
				/*jfomap.get(entr.getKey()).delete();
				javaFileForInput.delete();*/
			} catch (Exception e) {
				throw new ReflectException("Error while compiling " + entr.getKey(), e);
			}
		}
		return ret;
	}
}
/* [/java-8] */
