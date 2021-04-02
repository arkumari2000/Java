import java.util.Scanner;

public class circularLinkedList {
    Node head = null;
    Node tail = null;
    class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
        }
    }
    public void push(int data){
        Node newNode = new Node(data);
        if(head==null){
            head = newNode;
            tail = newNode;
        }else{
            tail.next= newNode;
            tail = newNode;
            tail.next = head;
        }
    }
    public void delete(int data){
        Node current = head;
        Node prev = head;
        do{
            if(current.data == data){
                if(current == head && current==tail){ //if only one node is there in the list
                    head= null;
                    tail=null;
                }else if(current==head){ //if the node to be deleted is first node
                    tail.next = head.next;
                    head = head.next;
                }else if(current==tail){ //if the node to be deleted is the last node
                    prev.next = tail.next;
                    tail = prev;
                }else{ //if the node to be deleted is anywhere between head and tail
                    prev.next = current.next; 
                }
                break;
            }
            prev = current;
            current = current.next;
        }while(current != head);
    }
    public void display(){
        if(head==null){
            System.out.println("Linked list is empty");
        }else{
            Node current = head;
            do{
                System.out.print(current.data+"\t");
                current = current.next;
            }while(current != head);
            System.out.println(" ");
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        circularLinkedList list = new circularLinkedList();
        while(true){
            System.out.println("Please choose option you want to perform on circular linked list: \n 1.insert an element in the list \n 2.delete a particular element \n 3.display the circular linked list \n 6.any other number to terminate");
            int choice = sc.nextInt();
            if(choice==1){
                System.out.println("Enter the element to be inserted in the begining of the linked list:");
                int x = sc.nextInt();
                list.push(x);
            }else if(choice==2){
                System.out.println("Enter the element to be deleted from the linked list:");
                int x = sc.nextInt();
                list.delete(x);
            }else if(choice==3){
                list.display();
            }else{
                break;
            }
        }
    }
} 
