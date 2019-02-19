package impl;

public class LinkedList {
	
	private Node head;
	
	static class Node{
		private int data;
		Node next;
		
		public Node(int d)
		{
			this.data = d;
		}
	}
	
	private void add(int data) {
		if(head == null) {
			this.head= new Node(data);
			return;
		}
		Node add = new Node(data);
		add.next = head;
		head = add;
	}
	private void print(Node input) {
		if(input == null) return;
		System.out.print(input.data + "-->"); 
		print(input.next);
	}
	
	private Node search(Node n ,int searchItem) {
		if (n ==null) return null;
		if (n.data == searchItem) return n;
		return search(n.next,searchItem);
		
	}
	
	private void delete(Node n, int deleteData) {
		Node searchNode = search(n,deleteData);
		if(searchNode !=null) {
			if(n.data == deleteData) {
				head= head.next;
				return;
			}
			
			Node currentNode = head; 
			while(currentNode.next!=null && currentNode.next != searchNode) currentNode = currentNode.next;
			currentNode.next = searchNode.next;
		}
	}
		
	public static void main(String args[]) {
		
		LinkedList l = new LinkedList();
		l.add(5);
		l.add(3);
		l.add(8);
		l.add(9);
		l.add(2);
		l.add(6);
		l.print(l.head);
		Node n = l.search(l.head, 8);
		if(n!=null) {
			System.out.println();
			System.out.println("Found it " + n.data);
		}
		l.print(n);
		System.out.println();
		System.out.println();
		System.out.println();
		
		l.delete(l.head, 5);
		l.print(l.head);
		
	}
	
}
