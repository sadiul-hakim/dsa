
class SinglyLinkedList{
	private ListNode head;
	
	private static class ListNode{
		private int data;
		private ListNode next;
		
		public ListNode(int data) {
			this.data=data;
			this.next=null;
		}
	}
	
	public ListNode add(int data) {
		ListNode node=new ListNode(data);
		if(head==null) {
			head=node;
			return head;
		}
		ListNode current=head;
	
		while(current.next != null) {
			current=current.next;
		}
				
		current.next=node;
		
		return head;
	}
	
	public void addFirst(int value) {
		ListNode node=new ListNode(value);
		node.next=head;
		head=node;
	}
	
	public void addLast(int value) {
		ListNode node=new ListNode(value);
		ListNode current=head;
		
		while(current.next != null) {
			current=current.next;
		}
		
		current.next=node;
	}
	
	public void addAtAPosition(int value, int position) {
		ListNode node=new ListNode(value);
		ListNode current=head;
		int count=1;
		
		if(position == 1) {
			
			node.next=head;
			head=node;
		}
		
		while(count < position - 1) {
			current=current.next;
			count++;
		}
		
		node.next=current.next;
		current.next=node;
	}
	
	public void deleteFirst() {
		if(head==null) {
			return;
		}

		ListNode prevHead=head;
		head=head.next;
		prevHead.next=null;
	}
	
	public void deleteLast() {
		if(head==null) {
			return;
		}
		ListNode current=head;
		ListNode prev=null;
		
		while(current.next != null) {
			prev=current;
			current=current.next;
		}
		
		prev.next=null;
	}
	
	public ListNode deleteAtAPosition(int position) {
		if(position == 1) {
			head=head.next;
		}
		ListNode prev=head;
		int count=1;
		
		
		while(count < position -1) {
			prev=prev.next;
			count++;
		}
		
		ListNode current=prev.next;
		ListNode next=current.next;
		
		prev.next=next;
		current.next=null;
		
		return current;
		
	}
	
	public void print() {
		ListNode current=head;
		
		while(current != null) {
			System.out.print(current.data + " => ");
			current=current.next;
		}
		System.out.println(" null ");
	}
	
	public void print(ListNode head) {
		ListNode current=head;
		
		while(current != null) {
			System.out.print(current.data + " => ");
			current=current.next;
		}
		System.out.println(" null ");
	}
	
	public int size() {
		ListNode current=head;
		int count=0;
		
		while(current!=null) {
			current=current.next;
			count++;
		}
		
		return count;
	}
	
	public boolean contains(int value) {
		ListNode current=head;
		
		while(current != null) {
			if(current.data == value) {
				return true;
			}
			current = current.next;
		}
		
		return false;
	}
	
	public ListNode midPosition() {
		ListNode fastPtr=head;
		ListNode slowPtr=head;
				
		while(fastPtr != null && fastPtr.next != null) {
			fastPtr=fastPtr.next.next;
			slowPtr=slowPtr.next;
		}
		
		return slowPtr;
	}
	
	public ListNode findNthNode(int n) {
		ListNode current=head;
		int count=1;
		
		while(count < n) {
			current=current.next;
			count++;
		}
		
		return current;
	}
	
	public ListNode findNthPositionFromLast(int n) {
		if(head==null) {
			return null;
		}
		ListNode fastPtr=head;
		ListNode slowPtr=head;
		int count=1;
		
		if(n <= 0)
			throw new IllegalArgumentException("N is Invalid.");
		
		while(count < n) {
			
			fastPtr=fastPtr.next;
			count++;
		}
		
		while(fastPtr.next != null) {
			fastPtr=fastPtr.next;
			slowPtr=slowPtr.next;
		}
		
		return slowPtr;
	}
	
	public ListNode reverse() {
		if(head==null) {
			return head;
		}
		ListNode prev=null;
		ListNode current=head;
		ListNode next=null;
		
		while(current!=null) {
			next=current.next;
			current.next=prev;
			prev=current;
			current=next;
		}
		
		return prev;
	}
	
	public void removeDuplicates() {
		if(head==null) {
			return;
		}
		ListNode current=head;
		ListNode prev=null;
		
		while(current != null && current.next != null) {
			prev=current;
			current=current.next;
			
			if(prev.data == current.data) {
				prev.next=current.next;
			}
			
		}
	}
	
	public void insertInaSortedList(int data) {
		ListNode node=new ListNode(data);
		
		if(node.data < head.data) {
			node.next=head;
			head=node;
			return;
		}
		
		ListNode current=head;
		ListNode prev=null;
		
		while(current != null && current.data < node.data) {
			prev=current;
			current = current.next;
		}
		
		node.next=current;
		prev.next=node;
		
	}
	
	public void deleteKey(int key) {
		if(head==null) {
			return;
		}
		ListNode current=head;
		ListNode prev=null;
		
		//10 -> 12 -> 14 -> 15 -> null
		
		if(current != null && current.data == key) {
			head=current.next;
			return;
		}
		
		while(current != null && current.data != key) {
			prev=current;
			current=current.next;
		}
		
		if(current==null)
			return;
		
		prev.next=current.next;
		
	}
	
	public boolean containsLoop() {
		ListNode fastPtr=head;
		ListNode slowPtr=head;
		
		while(fastPtr.next != null && fastPtr != null) {
			fastPtr=fastPtr.next.next;
			slowPtr=slowPtr.next;
			
			if(fastPtr == slowPtr)
				return true;
		}
		
		return false;
	}
	
	private ListNode startOfLoop(ListNode slowPtr) {
		ListNode temp=head;
		
		while(temp != slowPtr) {
			slowPtr=slowPtr.next;
			temp=temp.next;
		}
		
		return temp;
	}
	
	public ListNode startingNodeOfLoop() {
		ListNode fastPtr=head;
		ListNode slowPtr=head;
		
		while(fastPtr.next != null && fastPtr != null) {
			fastPtr=fastPtr.next.next;
			slowPtr=slowPtr.next;
			
			if(fastPtr == slowPtr)
				return startOfLoop(slowPtr);
		}
		
		return null;
	}
	
	private void distroyLink(ListNode slowPtr) {
		ListNode temp=head;
		
		while(slowPtr.next == temp.next) {
			slowPtr=slowPtr.next;
			temp=temp.next;
		}
		
		slowPtr.next=null;
	}
	
	public void removeLoop() {
		ListNode fastPtr=head;
		ListNode slowPtr=head;
		
		while(fastPtr.next != null && fastPtr != null) {
			fastPtr=fastPtr.next.next;
			slowPtr=slowPtr.next;
			
			if(fastPtr == slowPtr)
				distroyLink(slowPtr);
		}
	}
	
	public void createLoopInLinkedList() {
		ListNode first=new ListNode(1);
		ListNode second=new ListNode(2);
		ListNode third=new ListNode(3);
		ListNode fourth=new ListNode(4);
		ListNode fifth=new ListNode(5);
		ListNode sixth=new ListNode(6);
		ListNode seventh=new ListNode(7);
		
		first.next=second;
		second.next=third;
		third.next=fourth;
		fourth.next=fifth;
		fifth.next=sixth;
		sixth.next=seventh;
		seventh.next=fourth;
		
		if(head==null) {
			head=first;
		}else {
			head.next=first;
		}
		
	}
	
	public ListNode mergeTwoSortedList(ListNode a,ListNode b) {
		ListNode dummy = new ListNode(0);
		ListNode tail=dummy;
		
		while(a!= null && b!= null) {
			if(a.data < b.data) {
				tail.next=a;
				a=a.next;
			}else {
				tail.next=b;
				b=b.next;
			}
			
			tail=tail.next;
		}
		
		if(a==null) {
			tail.next=b;
		}else {
			tail.next=a;
		}
		
		return dummy.next;
		
	}
	
	public ListNode sum(ListNode a ,ListNode b) {
		ListNode dummy=new ListNode(0);
		ListNode tail=dummy;
		
		int carry=0;
		while(a != null || b != null) {
			int x = (a == null) ? 0 : a.data;
			int y = (b == null) ? 0 : b.data;
			
			int sum=carry+ x + y;
			tail.next=new ListNode(sum % 10);
			
			carry=sum / 10;
			
			tail=tail.next;
			
			if(a != null) a = a.next;
			if(b != null) b = b.next;
		}
		
		if(carry > 0) {
			tail.next=new ListNode(carry);
		}
		
		return dummy.next;
	}
	
	public static void main(String[] args) {
		SinglyLinkedList list=SinglyLinkedList();
		
		
	}
}






