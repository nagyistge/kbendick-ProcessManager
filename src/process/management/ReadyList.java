/*
 * To do: refactor constructor and the getProcessByPriority
 */

package process.management;

import java.util.List;
import java.util.ArrayList;
import process.management.PCB;

public class ReadyList {

	List<List<Process>> readyList;
	
	public ReadyList() {
		readyList = new ArrayList<>();
		readyList.add(0, new ArrayList<Process>());
		readyList.add(1, new ArrayList<Process>());
		readyList.add(2, new ArrayList<Process>());
	}
	
	
	public Process getProcessByPriority() {
		
		if (!readyList.get(2).isEmpty()) {
			return readyList.get(2).remove(0);
		} else if (!readyList.get(1).isEmpty()) {
			return readyList.get(1).remove(0);
		} else if (!readyList.get(0).isEmpty()) {
			return readyList.get(0).remove(0);
		} else {
			return null;
		}
	}
	
	/**
	 * Insert the given {@link Process} into the ready list
	 * according to its priority.
	 * 
	 * @param process process to be inserted
	 */
	public void insert(Process process) {
		readyList.get(process.getPriority()).add(process);
	}
	
	/**
	 * Remove the given {@link Process} from the ready list.
	 * @param pcb Process to be removed
	 */
	public void remove(Process pcb) {
		readyList.get(pcb.getPriority()).remove(pcb);
	}
	
	
}
