// maybe make it so I throw here for request / release??

package process.management;

import java.util.ArrayList;
import java.util.List;

/**
 * Resource Control Block which holds all of the information
 * for a {@link Resource}.
 * 
 * @author kbendick
 */
public class RCB implements Resource {
	
	private String rid;
	private int systemTotal;
	private int allocatedCount;
	private Status status;
	private List<Process> waitingList;
	
	/**
	 * Constructor
	 * @param rid Unique System Given Resource ID
	 * @param systemTotal Count of this available system-wide
	 */
	public RCB(String rid, int systemTotal) {
		this.rid = rid;
		this.systemTotal = systemTotal;
		this.allocatedCount = 0;
		this.status = Resource.Status.FREE;
		this.waitingList = new ArrayList<>();
	}
	
	
	@Override
	public boolean request(int numRequested) {
		allocatedCount = allocatedCount + numRequested;
		if (allocatedCount == systemTotal) {
			status = Resource.Status.ALLOCATED;
		}
		return true;
	}

	@Override
	public boolean release(int releaseCount) {	
		allocatedCount = allocatedCount - releaseCount;
		if (systemTotal > allocatedCount) {
			status = Resource.Status.FREE;
		}
		return true;
	}
	
	// Accessors
	public String getRID() { 
		return rid; 
	}
	
	public Status getStatus() {
		return status;
	}
	
	public int getAllocated() {
		return allocatedCount;
	}
	
	public int getAvailable() {
		return systemTotal - allocatedCount;
	}
	
	public int getSystemTotal() {
		return systemTotal;
	}
	
	public List<Process> getWaitingList() {
		return waitingList;
	}
	
}
