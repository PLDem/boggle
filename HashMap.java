import java.util.*;

/**This is a hash table implemented with separate chaining
 */

public class HashMap {

	public HashMap() {
	
	}

	public class Node {
		
		public String value;
		Node next = null;

		public Node(String value) {
			this.value = value;
		}

	}

	/** Array used for hash table 
	 */
	public Node[] table = new Node[40000];

	/** Returns an array of all words currently stored in this hash table
	 */
	public Queue<String> traverse(){
		
		LinkedList<String> ll = new LinkedList<String>();
		Node curr;
		
		for(int i = 0; i < table.length; i++){
			curr = table[i];
			
			while(curr != null){
				ll.add(curr.value);
				curr = curr.next;
			}
		}
		
		return ll;
		
		
	}
	
	/**Searches for the provided string based on its hash value
	 *
	 * @param word
	 * @return true if word is found
	 */
	public boolean find(String word) {

		int mod = Math.abs(word.hashCode()) % table.length;
		
		Node curr = table[mod];
		
		while(curr != null){
			if(curr.value.equals(word))
				return true;
			curr = curr.next;
		}
			
		return false;
		
	}

	/**This method inserts words into the hash table by hashing the word and adding it to the proper
	 * linked list in the array
	 * 
	 * @param word is the String to be inserted
	 */
	public void insert(String word){
	
		if(!find(word)){
			
			Node newHash = new Node(word);
			
			int mod = Math.abs(word.hashCode()) % table.length;
			
			if(table[mod] != null)
				newHash.next = table[mod];
			table[mod] = newHash;
			
		}
	}
}
