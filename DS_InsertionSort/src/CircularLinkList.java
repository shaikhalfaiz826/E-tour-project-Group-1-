package Circular;

import java.util.Scanner;



class Node
{
	 int data;
	 Node next;
	public Node(int data)
	{
		super();
		this.data = data;
		this.next=null;
	}
	public Node next() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}



public class CircularLinkList {
	
	

	
	private Node root,last;
	
	void createLinkedList() {
		root=null;
		last=null;
	}
	
	
	
	public void insertLeft(int e)
	{
		Node n=new Node(e);
		if(root==null)
		{
			root=last=n;
		    last.next=root;
		}
		else
		{
		n.next=root;
		root=n;
		last.next=root;
		}
		
	}
	
	public void insertRight(int e)
	{
		Node n=new Node(e);
		if(root==null)
		{
			root=last=n;
		    last.next=root;
		}
		else
		{
			last.next=n;
		last=n;
		last.next=root;
		}
		
	}
	
	public void deleteLeft()
	{
		Node t=null;
		if(root==null)
			System.out.println("Empty");
		else if(root==last)
		   {
			   root=last=root.next=null;
			   System.out.println("Data removed : ");
		   }
		   else
		{
			t=root;
		root=root.next;
		last.next=root;
		System.out.println("Data removed : "+t.data);
		}
	}
	
	public void deleteRight() 
	{
		
	
		if(root==null)
			System.out.println("Empty");
	   else if(root==last)
	   {
		   root=last=root.next=null;
		   System.out.println("Data removed : "+root.data);
	   }
	   else
		{
		   Node prev=null;
		Node trav=root;
		while(trav!=last)
		{
		prev=trav;
		System.out.println("1");
		trav=trav.next;
       }
		prev.next=root;
		last=prev;
		last.next=root;
		System.out.println("Data removed : "+trav.data);
		}
	}
	
	public void printList() {
	
		if(root==null)
		{
			System.out.println("Empty list");
		
		}
		else
		{
			System.out.print("LIST: ");
		Node trav = root;
		do {
			System.out.print(trav.data + ", ");
			trav = trav.next;	
		}while(trav!=root);
	   System.out.println();
		}
	}


	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		CircularLinkList list = new CircularLinkList();
		int choice, val, pos;
		do {
			System.out.print("\n1. display\n2. Insert Left\n3. Insert Right\n4. delete Left\n5.delete right\nenter choice: \n");
					
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				list.printList();
				break;
			case 2:
				System.out.print("enter value: ");
				val = sc.nextInt();
				list.insertLeft(val);
				break;
			case 3:
				System.out.print("enter value: ");
				val = sc.nextInt();
				list.insertRight(val);
				break;
			case 4:
				
				list.deleteLeft();
				break;
			case 5:
				list.deleteRight();
				break;
			
			
			}
		}while(choice != 0);

	}

}
