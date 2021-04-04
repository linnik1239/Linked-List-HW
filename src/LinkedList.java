
import java.io.*;



public class LinkedList {
	
	Node first, last;

	class Node {
		int data;
		Node next;
	}
	
	public LinkedList() {
		
	}
	
	public LinkedList(LinkedList list) {
		
	}
	
	
	
    public LinkedList(LinkedList list1,LinkedList list2, int constructCommand) {
    	// constructCommand values:
    	//  0 for Ex4
    	//  1 for Ex6
    	//  2 for Ex8
    	
    	if(constructCommand==2) {
    		sortTwoSortedLists(list1,list2);
    	}
    	else if(constructCommand ==1) {
    		mergeForConstuctor(list1,list2);
    	}
    	else
    	{
    		concatenateIntoThird(list1,list2);
//    		if(list1.first == null && list2.first == null) {
//        		return;
//        	}
//        	
//        	if(list1.first == null)  {
//        		Node temp = list2.first;
//        		first = new Node();
//        		first.data = temp.data;
//        		first.next = null;  // this operation is not required. because next by default holds null
//        		last = first;
//        		  		
//        		temp=temp.next;
//        		while(temp!=null) {
//        			Node temp2 = new Node();
//        			
//        			temp2.data = temp.data;
//        			temp2.next = null;
//
//        			last.next = temp2;
//        			last = temp2;
//        			temp=temp.next;
//
//        		}
//        		   		    		
//        	}
//        	else
//        	{
//        		Node temp = list1.first;
//        		first = new Node();
//        		first.data = temp.data;
//        		first.next = null;  // this operation is not required. because next by default holds null
//        		last = first;
//        		  		
//        		temp=temp.next;
//        		while(temp!=null) {
//        			Node temp2 = new Node();
//        			
//        			temp2.data = temp.data;
//        			temp2.next = null;
//
//        			last.next = temp2;
//        			last = temp2;
//        			temp=temp.next;
//
//        		}
//        		//if(list2.first!=null)
//        		if(list2.first!=null) {
//        			
//        			
//        			Node tempR = list2.first;
//        			
//        			
//            		
//            		while(tempR!=null) {
//            			Node temp2 = new Node();
//            			
//            			temp2.data = tempR.data;
//            			temp2.next = null;
//            			
//            			
//            			if(tempR == list2.first) {
//            				last.next = tempR;
//                			last = temp2;
//            			}
//            			else {
//            				last.next = temp2;
//                			last = temp2;
//            			}
//
//            
//            			tempR=tempR.next;
//
//            		}
//        			
//        		}
//        		
//        		
//        	}
    	
    	}
    	
		
	}
	
	
	public void createList(int[] arr) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		int arrLen = arr.length;

		first = new Node();
		first.data = arr[0];
		first.next = null;  // this operation is not required. because next by default holds null
		last = first;

		for(int i=1;i<arrLen;++i) {
			Node temp = new Node();
			
			temp.data = arr[i];
			temp.next = null;

			last.next = temp;
			last = temp;

		}

		System.out.println("List is created successfully.");
	}
	
	public void printList() {
		Node temp = first;
		
		while(temp != null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.println();
	}

	public void deleteNode(int position) {
		if(position <=0){
			System.out.println("Invalid position");
			return;
		}

		if(position == 1) {
			Node temp = first;
			first = first.next;
			temp = null;
			System.out.println("Node deleted successfully.");
			return;
		}

		int ctr = 1;
		Node t = first;

		while((ctr<position-1) && t != null) {
			t = t.next;
			ctr++;
		}

		if(t == null) {
			System.out.println("Invalid position");
			return;
		}

		Node temp = t.next;
		t.next = temp.next;

		temp = null;

		System.out.println("Node deleted successfully");
	}

	public void insertNode(int position, int data) {
		
		if(position<=0) {
			System.out.println("Invalid position.");
			return;
		}

		if(position == 1) {
			Node temp = new Node();
			temp.data = data;
			temp.next = first;
			first = temp;
			System.out.println("Node inserted successfully.");
			return;
		}

		/*Reach to the (position-1) th Node*/
		int ctr = 1;
		Node t = first;
		while((ctr < position-1) && t !=null)  {
			t = t.next;
			ctr++;
		}

		/*This means that list does not have enough number of nodes to insert node at given position*/
		if(t == null) {
			System.out.println("Invalid position.");
			return;
		}

		/*If control of execution reaches here, this means that we have valid position.*/
		Node temp = new Node();
		temp.data = data;
		temp.next = t.next;
		t.next = temp;
		System.out.println("Node inserted successfully.");

	} 


	// HW, Ex1
	public void findElementInList(int element) {
		
		Node temp = first;
		int position = 1;
		while(temp!=null && temp.data!=element) {
			++position;
			temp = temp.next;
		}
		if(temp==null) {
			
			System.out.println("The element "+element+" doesn't exist in the list.");
		}
		else
		{
			System.out.println("The element "+element+" was found at the position of "+position);
		}
		
	}
	
	// Ex2
	
	public static void selectionSort(int[] ar) {

		for(int i=0; i < ar.length-1; i++) {  // select index


			for(int j=i+1; j < ar.length; j++) {

				if(ar[j]<ar[i]) {
					int temp = ar[i];
					ar[i] = ar[j];
					ar[j] = temp;
				}
			}
		}
	}

	
	
	public void sortLikedListElements() {
		int elementCounter = 0;
		Node temp = first;
		while(temp!=null) {
			++elementCounter;
			temp = temp.next;
		}
		int[] elementsArray = new int[elementCounter];
		temp = first;
		elementCounter = 0;
		while(temp!=null) {
			elementsArray[elementCounter] = temp.data;
			++elementCounter;
			temp = temp.next;
		}
		selectionSort(elementsArray);
		
		temp = first;
		elementCounter = 0;
		while(temp!=null) {
			temp.data = elementsArray[elementCounter];
			++elementCounter;
			temp = temp.next;
		}
		
	}
	
	
	// Ex3
	public void printInReversedOrder() {
		if(first==null) {
			return;
		}
		
		Node newNode=null;
		Node temp = first;
		
		while(temp != null) {
			
			if(temp==first) {
				newNode = new Node();
				newNode.data = temp.data;
				newNode.next = null;				
			}
			else
			{
				Node temp2 = new Node();
				temp2.data = temp.data;
				temp2.next = newNode;
				newNode = temp2;				
			}
			
			temp=temp.next;
			
		}
		
		System.out.println("The list in the reversed order:");
		while(newNode!=null) {
			System.out.print(newNode.data+" ");
			newNode = newNode.next;
		}
		
		System.out.println();
		
	}
	
	
	public void concatenateIntoThird(LinkedList list1,LinkedList list2) {
		if(list1.first == null && list2.first == null) {
		return;
	}
	
	if(list1.first == null)  {
		Node temp = list2.first;
		first = new Node();
		first.data = temp.data;
		first.next = null;  // this operation is not required. because next by default holds null
		last = first;
		  		
		temp=temp.next;
		while(temp!=null) {
			Node temp2 = new Node();
			
			temp2.data = temp.data;
			temp2.next = null;

			last.next = temp2;
			last = temp2;
			temp=temp.next;

		}
		   		    		
	}
	else
	{
		Node temp = list1.first;
		first = new Node();
		first.data = temp.data;
		first.next = null;  // this operation is not required. because next by default holds null
		last = first;
		  		
		temp=temp.next;
		while(temp!=null) {
			Node temp2 = new Node();
			
			temp2.data = temp.data;
			temp2.next = null;

			last.next = temp2;
			last = temp2;
			temp=temp.next;

		}
		//if(list2.first!=null)
		if(list2.first!=null) {
			
			
			Node tempR = list2.first;
			
			
    		
    		while(tempR!=null) {
    			Node temp2 = new Node();
    			
    			temp2.data = tempR.data;
    			temp2.next = null;
    			
    			
    			if(tempR == list2.first) {
    				last.next = tempR;
        			last = temp2;
    			}
    			else {
    				last.next = temp2;
        			last = temp2;
    			}

    
    			tempR=tempR.next;

    		}
			
		}
		
		
	}

	}
	
	
	
	//Ex5 
	public void concatenateList(LinkedList list) {
		System.out.println("Concatinating two lists without creating thirtd list.");
		this.last.next = list.first;
		this.last = list.last;
	}
	
	//Ex6
	public void mergeForConstuctor(LinkedList list1,LinkedList list2) {
		Node tempL1 = list1.first;
		Node tempL2 = list2.first;
				
		if(tempL1!=null) {
    		this.first = new Node();
    		this.first.data = tempL1.data;
    		first.next = null;  // this operation is not required. because next by default holds null
    		this.last = this.first;		
    		tempL1=tempL1.next;
		}
		else{
			if(tempL2!=null) {
				this.first = new Node();
	    		this.first.data = tempL2.data;
	    		first.next = null;  // this operation is not required. because next by default holds null
	    		this.last = this.first;		
	    		tempL2=tempL2.next;			
			}
			else
			{
				return;
			}
		}
		
		Node temp = this.first;
		while(tempL1!=null || tempL2!=null) {
			if(tempL2!=null) {
				Node tempC = new Node();
				tempC.data = tempL2.data;
				tempC.next = null;
				temp.next = tempC;
				temp = tempC;
				tempL2 = tempL2.next;				
			}
			
			
			if(tempL1!=null) {
				Node tempC = new Node();
				tempC.data = tempL1.data;
				tempC.next = null;
				temp.next = tempC;
				temp = tempC;
				tempL1 = tempL1.next;				
			}
			
		}
		
				
	}
	
	// Ex7
	public void mergeTwoListWithoutCreatingOne(LinkedList list) {
		Node tempL1 = this.first;
		Node tempL2 = list.first;
		Node theTemp=null;
		
		if(this.first!=null) {
			theTemp = tempL1;
			tempL1=tempL1.next;
		}
		else
		{
			if(list!=null) {
				theTemp = tempL2;
				tempL2=tempL2.next;
			}
			
		}
				
		while(tempL1!=null || tempL2 !=null) {									
			if(tempL2!=null) {
				Node tempC = tempL2;
				tempL2 = tempL2.next;
				theTemp.next = tempC;
				theTemp = theTemp.next;
			}			
			if(tempL1!=null) {
				Node tempC = tempL1;
				tempL1 = tempL1.next;
				theTemp.next = tempC;
				theTemp = theTemp.next;				
			}
			
		}
		
		
	}
	
	
	//Ex8
	public void sortTwoSortedLists(LinkedList list1,LinkedList list2) {
		Node tempL1 = list1.first;
		Node tempL2 = list2.first;
				
		Node temp=null;
		
		while(tempL1!=null && tempL2!=null) {
			if(tempL1.data < tempL2.data) {
				Node tempC = new Node();
				tempC.data = tempL1.data;
				tempC.next = null;				
				if(temp==null) {
					this.first = tempC;
					temp=tempC;
				}
				else {
					temp.next = tempC;
					temp = tempC;

				}	
				tempL1 = tempL1.next;
			}
			else
			{
				Node tempC = new Node();
				tempC.data = tempL2.data;
				tempC.next = null;
				
				if(temp==null) {
					this.first = tempC;
					temp=tempC;
				}
				else {
					temp.next = tempC;
					temp = tempC;

				}	
				tempL2 = tempL2.next;				
			}
			
		}
		
		while(tempL1!=null) {
			Node tempC = new Node();
			tempC.data = tempL1.data;
			tempC.next = null;				
			if(temp==null) {
				this.first = tempC;
				temp=tempC;
			}
			else {
				temp.next = tempC;
				temp = tempC;

			}	
			tempL1 = tempL1.next;
		}
		
		
		while(tempL2!=null) {
			Node tempC = new Node();
			tempC.data = tempL2.data;
			tempC.next = null;				
			if(temp==null) {
				this.first = tempC;
				temp=tempC;
			}
			else {
				temp.next = tempC;
				temp = tempC;

			}	
			tempL2 = tempL2.next;
		}
		
		
				
	}
	
	
	
	public void sortWithoutCreatingNewList(LinkedList list) {
		Node tempL1 = this.first;
		Node tempL2 = list.first;
		Node theTemp=null;
				
		while(tempL1!=null && tempL2 !=null) {									
			if(tempL1.data < tempL2.data) {
				Node tempC = tempL1;
				tempL1 = tempL1.next;
				
				if(theTemp == null) {
					theTemp = tempC;
				}
				else
				{
					theTemp.next = tempC;
					theTemp = tempC;
				}
			}			
			else
			{
				Node tempC = tempL2;
				tempL2 = tempL2.next;
				
				if(theTemp == null) {
					
					theTemp = tempC;
					theTemp.next = this.first;
					this.first = theTemp;
					
				}
				else
				{
					theTemp.next = tempC;
					theTemp = tempC;
				}				
			}
			
			
			
		}
		
		
		while(tempL1!=null) {
			Node tempC = tempL1;
			tempL1 = tempL1.next;
			theTemp.next = tempC;
			theTemp = tempC;									
		}
					
		while(tempL2!=null) {
			Node tempC = tempL2;
			tempL2 = tempL2.next;
			theTemp.next = tempC;
			theTemp = tempC;
		
		}
		
		
	}
	
    // Ex10
	public void searchAndDeleteElement(int element) {
		if(first == null) {
			return;
		}
		if(first.data==element) {
			first = first.next;
		}
		else
		{
			Node temp = first;
			while(temp.next != null && temp.next.data!=element) {
				temp=temp.next;				
			} 
			if(temp.next != null) {
				temp.next = temp.next.next;
			}
			else
			{
				System.out.println("The element, "+element+" was not found in the list.");
			}
		}
		
		
		
		
	}
	
	
	// Ex11
	public void smalestAndGratestElement() {
		if(first == null) {
			System.out.println("The list is empty.");
			return;
		}
		int smallest=first.data;
		int gratest=first.data;
		Node temp = first.next;
		while(temp!=null) {
			if(temp.data>gratest) {
				gratest = temp.data;
			}
			if(temp.data< smallest) {
				smallest = temp.data;
			}
			
			temp = temp.next;
			
		}
		
		System.out.println("The smallest value of the list is: "+smallest);
		System.out.println("The gratest value of the list is: "+gratest);
		
		
	}
	
	// Ex12
	public void reverseOrderLinkedList() {
		
		if(this.first==null) {
			return;
		}
		
		Node currentFirst = this.first;
		Node temp = this.first;
		
		Node currentLast = this.first;
		
		
		
		this.first = this.first.next;
		
		temp.next = null;
		
		while(this.first!=null) {
			//System.out.println(this.first.data);
			Node currentTemp = this.first;
			this.first = this.first.next;
			currentTemp.next = currentFirst;
			currentFirst = currentTemp;
			

		}
		
		
		
		
		this.first = currentFirst;
		this.last = currentLast;
		this.last.next = null;
		
	}
	
	
	 
	public static void main(String[] args) throws Exception {
		int[] arrForList1 = {55,33,66,11,22,87,54,23,77,34,943,342};
		LinkedList list = new LinkedList();
		
		list.createList(arrForList1);
		list.printList();
		 
		// Ex1
		System.out.println("============Ex1=============");
		
		System.out.print("Current list1: ");
		list.printList();
		
		list.findElementInList(342);
		
		
		// Ex2
		System.out.println("============Ex2=============");
		System.out.print("Current list1: ");
		list.printList();
		list.sortLikedListElements();
		System.out.print("Sorted list1: ");
		list.printList();
		
		
		// Ex3
		System.out.println("============Ex3=============");
		
		System.out.print("Current list1: ");
		list.printList();
		list.printInReversedOrder();
		
		// Ex4
		System.out.println("============Ex4=============");
		int[] arrForList2 = {74,37,14,97,695,34,132,39,96,53,525,0,53,43,84,107};
		LinkedList list2 = new LinkedList();
		
		list2.createList(arrForList2);
		
		
		System.out.print("Current list1: ");
		list.printList();
		System.out.print("Current list2: ");
		list2.printList();
		
		LinkedList list3 = new LinkedList(list,list2,0);
		System.out.print("Concateneted list: ");
		list3.printList();
		
		
		// Ex5
		System.out.println("============Ex5=============");
		
		
		
		
		
        LinkedList listB1 = new LinkedList();
		
		listB1.createList(arrForList1);
		
		
        LinkedList listB2 = new LinkedList();
		
		listB2.createList(arrForList2);
		
		System.out.print("Current list1: ");
		listB1.printList();
		System.out.print("Current list2: ");
		listB2.printList();
		
		
		listB1.concatenateList(listB2);
		listB1.printList();
		
		
		// Ex6
		System.out.println("============Ex6=============");
		
		System.out.print("Current list1: ");
		list.printList();
		System.out.print("Current list2: ");
		list2.printList();
		
		LinkedList list4 = new LinkedList(list,list2,1);
		list4.printList();
		
		System.out.println("============Ex7=============");
		
		
        LinkedList listA1 = new LinkedList();
		
		listA1.createList(arrForList1);
		
		
        LinkedList listA2 = new LinkedList();
		
		listA2.createList(arrForList2);
		
		
		
		
		System.out.print("Current list1: ");
		listA1.printList();
		System.out.print("Current list2: ");
		listA2.printList();
		
		listA1.mergeTwoListWithoutCreatingOne(listA2);
		System.out.print("Merged: ");
		listA1.printList();
		
		System.out.println("============Ex8=============");
		
		list2.sortLikedListElements();
		System.out.print("Current list1: ");
		list.printList();
		System.out.print("Current list2: ");
		list2.printList();
		
		
		LinkedList list5 = new LinkedList(list,list2,2);
		
		System.out.print("Sorted two lists: ");
		list5.printList();
		
		
		System.out.println("============Ex9=============");
		System.out.print("Current list1: ");
		list.printList();
		System.out.print("Current list2: ");
		list2.printList();
		list.sortWithoutCreatingNewList(list2);
		System.out.print("Sorted two lists: ");
		list.printList();
		
		
		System.out.println("============Ex10=============");
		System.out.print("Current list: ");
		list3.printList();
		int elementForDelete = 66;
		list3.searchAndDeleteElement(elementForDelete);
		System.out.print("Without "+elementForDelete+"  : ");
		list3.printList();
		
		System.out.println("============Ex11=============");
		System.out.print("Current list: ");
		list3.printList();
		list3.smalestAndGratestElement();
		
		System.out.println("============Ex12=============");
		System.out.print("Current list: ");
		list3.printList();
		list3.reverseOrderLinkedList();
		System.out.print("Revered list: ");
		list3.printList();
		
		
		

	}

}
