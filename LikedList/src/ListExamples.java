

public class ListExamples {

	public ListElement insertInFront(ListElement head, Object data){
		ListElement newElement = new ListElement(data);
		newElement.next = head;
		head = newElement;
		return head;
	}
	
	public ListElement insertInEnd(ListElement head, Object data){
		ListElement newElement = new ListElement(data);
		newElement.next = null;
		ListElement cur = head;
		if(cur == null){
			return newElement;
		}
		while(cur.next!=null){
			cur = cur.next;
		}
		cur.next=newElement;
		
		return head;
	}
	
	public ListElement insertAfterElement(ListElement head, Object dataToFind, Object dataToInsert){
		
		ListElement cur = head;
		
		if(cur == null)
			return null;
		
		while(cur!=null && cur.data!=dataToFind)
			cur=cur.next;
		
		if(cur!=null){
			ListElement newElement = new ListElement(dataToInsert);
			newElement.next = cur.next;
			cur.next = newElement;
		}
		return head;
	}
	
	public ListElement insertBeforeElement(ListElement head, Object dataToFind, Object dataToInsert){
		
		if(head ==null) return null;
		
		ListElement cur = head.next;
		ListElement prev = head;
		
		while (cur!=null && cur.data!=dataToFind){
			prev = cur;
			cur = cur.next;
		}
		
		if(cur!=null && cur.data == dataToFind){
			ListElement newElement = new ListElement(dataToInsert);
			newElement.next = cur;
			prev.next= newElement;
		}
		
		return head;
	}
	
	public ListElement deleteElementFromFirst(ListElement head){
		if(head == null) return null;
		
		head = head.next;
		
		return head;
	}
	
	public ListElement deleteFromEnd(ListElement head){
		if(head == null|| head.next==null) return null;
		
		
		ListElement cur = head.next;
		ListElement prev = head;
		
		while(cur.next!=null){
			prev = cur;
			cur = cur.next;
		}
		
		prev.next = null;
		return head;
	}
	
	public ListElement deleteElement(ListElement head, Object dataToDelete){
		
		if(head==null) return null;
		
		while(head!=null && head.data.equals(dataToDelete)){
			head=head.next;
		}
		
		ListElement cur = head.next;
		ListElement prev = head;
		
		while(cur!=null){
			if(cur.data.equals(dataToDelete)){
				prev.next = cur.next;
			}
			else 
				prev = cur;
			cur=cur.next;
		}
		
		return head;
	}
	
	public ListElement insertNthElement(ListElement head, Object dataToInsert, int position){
		//Cannot insert in a negative position
		if(position <=0) return head;
		
		//If inserting at first position, just create a new element and point head to it
		if(position==1){
			ListElement newElement = new ListElement(dataToInsert);
			newElement.next = head;
			head = newElement;
		}
		else{ //If inserting at a position greater than 1
			if(head==null) return null; //If head is null, cannot insert, return null
			
			//Keep track of previous element to insert.
			ListElement prev = null;
			ListElement cur = head;
			int i;
			for(i=1; i< position; i++){
				if(cur==null) break; //If the list is not big enough, loop will break
				else{ //Else keep incrementing prev and cur elements. 
					prev = cur;
					cur = cur.next;
				}
			}
			if(i==position){ // Check if the position to insert is found. If found, insert between cur and prev.
				ListElement newElement = new ListElement(dataToInsert);
				newElement.next=cur;
				prev.next=newElement;
			}
		}
		return head;
	}
	
	public ListElement insertAtNthPositionFromEnd(ListElement head, Object dataToInsert, int position){
		
		if(position <=0) return head;
		ListElement cur = head;
		int i;
		for(i = 0; i < position; i++){
			if(cur==null) break;
			cur= cur.next;
		}
		if(i<position-1) return head;
		if(i==position-1) return insertInFront(head, dataToInsert);
		
		ListElement prev = head;
		while(cur!=null){
			prev = prev.next;
			cur = cur.next;
		}
		
		ListElement newElement = new ListElement(dataToInsert);
		newElement.next= prev.next;
		prev.next=newElement;
		
		return head;
	}
	
	public void printList(ListElement head){
		while(head!=null){
			System.out.print(head.data + ":");
			head=head.next;
		}
		System.out.println();
	}
	
	public static void main(String args[]){
		
		ListExamples example = new ListExamples();
		
		System.out.println("First Element: 4");
		ListElement head = new ListElement(4);
		example.printList(head);
		
		System.out.println("Insert 5 at front");
		head = example.insertInFront(head, 5);
		example.printList(head);
		
		System.out.println("Insert 10 at front");
		head = example.insertInFront(head, 10);
		example.printList(head);
		
		System.out.println("Insert 15 at end");
		head = example.insertInEnd(head, 15);
		example.printList(head);
		
		System.out.println("Insert 20 after 15");
		head = example.insertAfterElement(head, 15, 20);
		example.printList(head);
		
		System.out.println("Insert 25 before 4");
		head = example.insertBeforeElement(head, 4, 25);
		example.printList(head);
		
		System.out.println("Insert 5 at end");
		head = example.insertInEnd(head, 5);
		example.printList(head);
		
		System.out.println("Insert 30 at 5th Position");
		head = example.insertNthElement(head, 30, 5);
		example.printList(head);
		
		
		System.out.println("Delete from front");
		head = example.deleteElementFromFirst(head);
		example.printList(head);
		
//		System.out.println("Delete from End");
//		head= example.deleteFromEnd(head);
//		example.printList(head);
//		
		System.out.println("Delete Element 5");
		head = example.deleteElement(head, 5);
		example.printList(head);
		
		System.out.println("Insert 50 at 6th position from end");
		head = example.insertAtNthPositionFromEnd(head, 50, 6);
		example.printList(head);
	}
}
