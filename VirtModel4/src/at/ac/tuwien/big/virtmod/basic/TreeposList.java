package at.ac.tuwien.big.virtmod.basic;

import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public interface TreeposList extends ValueList<Treepos> {
	
	public Iterable<? extends TreeposState> getExistingEntries();
	
	public Iterable<? extends TreeposState> getNotExistingEntries();
	
	public Iterable<? extends TreeposState> getAllEntries();
	
	public Iterable<? extends TreeposState> getAllStoredEntries();
	
	public TreeposState getAtEditOrNull(long editId);
	


	public List<? extends TreeposState> getEdits(Treepos pos);


	

}
