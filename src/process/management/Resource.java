// TO DO
/*
 * Remove this interface. It is unnecessary and too tightly coupled to the RCB.
 */

package process.management;

import process.management.RCB;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public interface Resource {
	
	// The number of distinct, allocatable resources that
	// the system has.
	public static final int NUMBER_OF_SYSTEM_RESOURCES = 4;
	
	public enum Status {
		FREE, ALLOCATED
	}
	
	public boolean request(int requestCount);
	
	public boolean release(int releaseCount);
	
	/**
	 * Initializes all of the system's allocatable Resources
	 * and puts them into a table so that they can be
	 * located by their RID.
	 * 
	 * @return Mapping from RID to allocatable {@link RCB} for all
	 *         system-wide allocatable Resources.
	 */
	public static Map<String, Resource> initializeResourceTable() {
		Map<String, Resource> resourceTable = new HashMap<>();
		for (int i = 1; i <= NUMBER_OF_SYSTEM_RESOURCES; i++) {
			String RID = "R" + String.valueOf(i);
			resourceTable.put(RID, new RCB(RID, i));
		}
		return resourceTable;
	}
}