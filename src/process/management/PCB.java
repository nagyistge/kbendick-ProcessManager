
package process.management;


import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class PCB implements Process {
	
	
//	protected static class AllocatedResource {
//		public Resource resource;
//		public int quantity;
//		public AllocatedResource(Resource resource, int quantity) {
//			this.resource = resource;
//			this.quantity = quantity;
//		}
//	}
//	
//	protected static class Status {
//		public Process.Type type = null;
//		public Status() {
//			this.type = Process.Type.READY;
//		}
//		
//		public void setToReady() { type = Process.Type.READY; }
//		public void setToRunning() { type = Process.Type.RUNNING; }
//		public void setToWaiting() { type = Process.Type.WAITING; }
//	}
	
//	private static class CreationTree {
//		public Process parent;
//		public List<Process> children;
//		public CreationTree() {
//			parent = null;
//			children = new ArrayList<Process>();
//		}
//	}
	
	
	// Member Data
	private String pid;
	private int priority;
	private Status status;
	private Map<String, Integer> otherResourcesTable; // Maps an RID to the amount of that Resource this Process currently has.
	private CreationTree creationTree;
	
	/**
	 * Constructor for PCB
	 * 
	 * @param pid process id
	 * @param priority priority level
	 */
	public PCB(String pid, int priority) {
		this.pid = pid;
		this.priority = priority;
		this.creationTree = new CreationTree();
		this.otherResourcesTable = new HashMap<>();
		this.status = new Status();
	}
	
	
	public Integer getCountForResource(String rid) {
		return otherResourcesTable.getOrDefault(rid, 0);
	}
	
	public Process getParent() { 
		return this.creationTree.parent;
	}
	
	public void setParent(Process parent) {
		this.creationTree.parent = parent;
	}
	
	public List<Process> getChildren() {
		return this.creationTree.children;
	}
	
	public void addChild(Process child) {
		this.creationTree.addChild(child);
	}
	
	/* (non-Javadoc)
	 * @see process.management.Process#getPriority()
	 */
	@Override
	public int getPriority() {
		return priority;
	}
	
	
	
	
	
}
