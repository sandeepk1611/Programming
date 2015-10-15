
public class StackLinkedList {

	ListElement head;
	ListElement top;
	
	public boolean pushToStack(Object dataToPush){
		ListElement newElement = new ListElement(dataToPush);
		
		if(this.head==null){
			this.head = newElement;
		}
		else{
			this.top.next = newElement;
		}
		this.top = newElement;
		return true;
	}
	
	public ListElement popFromStack(){
		
		if(isEmpty()) return null;
		
		ListElement itemToReturn = top;
		
		if(head == top){
			head = null;
		}
		else{
			ListElement cur = head;

			while(cur.next!=top){
				cur=cur.next;
			}
			top = cur;
			top.next=null;
		}
		
		
		
		return itemToReturn;
	}
	
	public boolean isEmpty(){
		if(head==null) return true;
		return false;
	}
	
	public void printStack(){
		if(head==null) System.out.println("Stack Empty");
		else{
			ListElement cur = this.head;
			System.out.println("Stack is :");
			while(cur!=null){
				System.out.println(cur.data);
				cur=cur.next;
			}
		}
		
	}
	
	public static void main(String args[]){
		
		StackLinkedList s1 = new StackLinkedList();
		System.out.println("Added 10");
		s1.pushToStack(10);
		s1.printStack();
		
		System.out.println("Added 20");
		s1.pushToStack(20);
		s1.printStack();
		
		System.out.println("Added 30");
		s1.pushToStack(30);
		s1.printStack();
		
		System.out.println("Added 40");
		s1.pushToStack(40);
		s1.printStack();
		
		System.out.println("Popping from stack");
		while(!s1.isEmpty()){
			ListElement poppedItem = s1.popFromStack();
			System.out.println("Popped Item : " + poppedItem.data);
			s1.printStack();
		}
		
	}
}
