import java.util.Scanner;

class Node {
    int data;
    Node next;
    
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    private Node head;
    
    public LinkedList() {
        this.head = null;
    }
    
    // Function to create a linked list from scratch
    public void createLinkedList() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements to create a linked list: ");
        int n = scanner.nextInt();
        
        for (int i = 0; i < n; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            int data = scanner.nextInt();
            insertAtEnd(data);
        }
        
        System.out.println("Linked list created successfully.");
    }
    
    // Function to insert a node at the end of the linked list
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        
        System.out.println("Node with data " + data + " inserted at the end.");
    }
    
    // Function to insert a node at a specified position in the linked list
    public void insertAtPosition(int data, int position) {
        if (position < 1 || position > getSize() + 1) {
            System.out.println("Invalid position. Insertion failed.");
            return;
        }
        
        Node newNode = new Node(data);
        
        if (position == 1) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            for (int i = 1; i < position - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        
        System.out.println("Node with data " + data + " inserted at position " + position + ".");
    }
    
    // Function to delete a node at a specified position in the linked list
    public void deleteAtPosition(int position) {
        if (position < 1 || position > getSize()) {
            System.out.println("Invalid position. Deletion failed.");
            return;
        }
        
        if (position == 1) {
            head = head.next;
        } else {
            Node current = head;
            for (int i = 1; i < position - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        
        System.out.println("Node at position " + position + " deleted.");
    }
    
    // Function to traverse and print the linked list
    public void traverse() {
        if (head == null) {
            System.out.println("Linked list is empty.");
            return;
        }
        
        Node current = head;
        System.out.print("Linked list: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    
    // Function to get the size of the linked list
    public int getSize() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
}

public class LinkedLists {

    public static void main(String[] args) {
        
            LinkedList linkedList = new LinkedList();
            Scanner scanner = new Scanner(System.in);
            int choice;
            
            do {
                System.out.println("1. Create a linked list from scratch");
                System.out.println("2. Insert a node at the end");
                System.out.println("3. Insert a node at a position");
                System.out.println("4. Delete a node at a position");
                System.out.println("5. Traverse the linked list");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                
                switch (choice) {
                    case 1:
                        linkedList.createLinkedList();
                        break;
                    case 2:
                        System.out.print("Enter the data to insert at the end: ");
                        int data = scanner.nextInt();
                        linkedList.insertAtEnd(data);
                        break;
                    case 3:
                        System.out.print("Enter the data to insert: ");
                        data = scanner.nextInt();
                        System.out.print("Enter the position to insert: ");
                        int position = scanner.nextInt();
                        linkedList.insertAtPosition(data, position);
                        break;
                    case 4:
                        System.out.print("Enter the position to delete: ");
                        position = scanner.nextInt();
                        linkedList.deleteAtPosition(position);
                        break;
                    case 5:
                        linkedList.traverse();
                        break;
                    case 6:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
                
                System.out.println();
            } while (choice != 6);
        } 
    }

