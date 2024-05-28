
package test1;

public class EntryNode {
	public EntryNode() {
		
	}
	
	Object[] entryInfo = new Object[2];
	EntryNode next = null;
	EntryNode prev = null;
	
	
	public EntryNode(String name, int number) {
		entryInfo[0] = name;
		entryInfo[1] = number;
		
	}
	
	public void addEntry(String newName, int newNumber){
		if(next != null) {
			next.addEntry(newName, newNumber);
		}
		else {
			next = new EntryNode(newName, newNumber);
			next.prev = this;
		}
	}
	
	public void printList(int entry) {
		System.out.println((entry+1) + "."+ " Name: "+entryInfo[0] );
		System.out.println("   Phone number: "+entryInfo[1] );
		System.out.println("");
		if(next != null) {
			next.printList(entry + 1);
		}

	}
	
	public void rmEntry(String name) {
		if(entryInfo[0].equals(name)) {
			if (prev != null && next != null) {
				prev.next = next;
				next.prev = prev;
			}
			else if (prev != null) {
				prev.next = null;
			}
			else if (next != null) {
				next.prev = null;
			}
			return;
		}
		
		if(next != null) {
			next.rmEntry(name);
			return;
		}
		System.out.println();
		System.out.println("<Entry Not Found>");
		System.out.println();
	}
}
