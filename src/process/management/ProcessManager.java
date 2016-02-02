package process.management;


import process.management.Resource;

import java.util.Map;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ProcessManager {

	private Process runningProcess = null;
	private Map<String, Resource> resourceTable; // Maps Resources by their RID
	private ReadyList readyList;
	
	/**
	 * Constructor
	 */
	public ProcessManager() {
		init();
	}
	
	/**
	 * Restores the system to its initial state.
	 * @return 
	 */
	public void init() {
		System.out.println("Process Init is running");
		runningProcess = Process.initKernel();
		resourceTable = Resource.initializeResourceTable();	
	}
	
	public void Scheduler() {
		
	}
	
	public void printRunningProcess() {
		
	}
	
	public boolean Create(String pid, int priority) {
		
		// create PCB data structure
		Process pcb = null;
		try {
			pcb = Process.createProcess(pid, priority);
		} catch (ProcessCreationException e) {
			return false;
		}
		
		// initialize PCB using parameters
		runningProcess.addChild(pcb);

		// link PCB to creation tree
		pcb.setParent(runningProcess);
		
		// insert(RL, PCB)
		readyList.insert(pcb);
		
		// Scheduler()
		Scheduler();
		
		return true;
	}
	
	public String executeTerminalCommand(String shellInput) {
		String[] args = shellInput.split("\\s");
		String command = args[0];
		// NEED TO DO ERROR CHECKING ON ARGS PARSE.
		switch (command) {
		
		case "init" : init();
				      break;
		case "cr"   : if (Create(args[1], args[2])
						;
					  break;
		case "de"   : break;
		case "req"  : break;
		case "rel"  : break;
		case "to"   : break;
		
		}
		
		return "Executed!!!";
	}

}
