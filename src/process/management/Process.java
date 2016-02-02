// TO DO
/*
 * Remove this interface. It is unnecessary and too tightly coupled to the PCB.
 * Consider changing nested classes to "protected"
 */


package process.management;

import process.management.PCB;
import process.management.ProcessCreationException;
import java.util.ArrayList;
import java.util.List;

public interface Process {

	public static ArrayList<String> allCurrentProcesses = new ArrayList<>();
	
	static class AllocatedResource {
		public Resource resource;
		public int quantity;
		public AllocatedResource(Resource resource, int quantity) {
			this.resource = resource;
			this.quantity = quantity;
		}
	}
	
	static class Status {
		public Process.Type type = null;
		public Status() {
			this.type = Process.Type.READY;
		}
		
		public void setToReady() { type = Process.Type.READY; }
		public void setToRunning() { type = Process.Type.RUNNING; }
		public void setToWaiting() { type = Process.Type.WAITING; }
	}
	
	static class CreationTree {
		public Process parent;
		public List<Process> children;
		public CreationTree() {
			parent = null;
			children = new ArrayList<Process>();
		}
		public void addChild(Process p) {
			children.add(p);
		}
	}
	
	public static Process initKernel() {
		return new PCB("init", 0);
	}
	
	public static Process createProcess(String pid, int priority) throws ProcessCreationException {	
		if (priority == 0 || allCurrentProcesses.contains(pid)) {
			throw new ProcessCreationException();
		} else {
			allCurrentProcesses.add(pid);
			return new PCB(pid, priority);
		}
	}
	
	public enum Type {
		RUNNING, READY, WAITING
	}
	
	
	public void setParent(Process parent);
	public void addChild(Process child);
	public int getPriority();
}