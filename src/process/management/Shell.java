/*
 * TO DO: Change back output to show shell_prompt, and the more human readable text output
 */

package process.management;

import java.util.Scanner;

public class Shell {

	public static final String SHELL_PROMPT = "Shell> ";
	
	public static void run() {
		
		Scanner in = null;
		try {
			
			in = new Scanner(System.in);
			ProcessManager pm = new ProcessManager();
			while (true) {
				System.out.print(SHELL_PROMPT);
				if (in.hasNextLine()) {
					System.out.print(SHELL_PROMPT);
					pm.executeTerminalCommand(in.nextLine());
				}
			}
		} finally {
			if (in != null) {
				in.close();
			}
		}
	}
	
	public static void main(String[] args) {
		Shell.run();
	}

}
