import java.util.Scanner;

public class singlyLinkedList {
    Node head;
    class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
            next = null;
        }
    }
    public void push(int data){
        Node temp = new Node(data);
        temp.next = head;
        head = temp;

    }
    public void insertAfter(int data, int key){
        Node temp = head;
        Node insert = new Node(data);
        while(temp != null){
            if(temp.data==key){
                insert.next = temp.next;
                temp.next = insert;
                break;
            }
            temp = temp.next;
        }
    }
    public void append(int data){
        Node insert = new Node(data);
        Node temp = head;
        while(temp != null){
            if(temp.next==null){
                temp.next = insert;
                insert.next = null;
            }
            temp = temp.next;
        }
    }
    public void delete(int data){
        Node temp = head.next;
        Node prev = head;
        while(temp != null){
            if(temp.data==data){
                prev.next=temp.next;
                break;
            }
            temp=temp.next;
            prev=prev.next;
        }
    }
    public void display(){
        Node temp = head;
        if(temp==null){
            System.out.println("Linked list is empty");
        }else{
            while(temp!=null){
                System.out.print(temp.data+"\t");
                temp = temp.next;
            }
            System.out.println(" ");
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        singlyLinkedList list = new singlyLinkedList();
        while(true){
            System.out.println("Please choose option you want to perform on linked list: \n 1.insert an element at the beginning of the list list \n 2.insert an element after specified element \n 3.insert an element at the end of list \n 4.delete a particular element \n 5.display the linked list \n 6.any other number to terminate");
            int choice = sc.nextInt();
            if(choice==1){
                System.out.println("Enter the element to be inserted in the begining of the linked list:");
                int x = sc.nextInt();
                list.push(x);
            }else if(choice==2){
                System.out.println("Enter the element to be inserted and the element after which the node to be inserted in linked list:");
                int x = sc.nextInt();
                int y = sc.nextInt();
                list.insertAfter(x, y);
            }else if(choice==3){
                System.out.println("Enter the element to be inserted in the end of the linked list:");
                int x = sc.nextInt();
                list.append(x);
            }else if(choice==4){
                System.out.println("Enter the element to be deleted from the linked list:");
                int x = sc.nextInt();
                list.delete(x);
            }else if(choice==5){
                list.display();
            }else{
                break;
            }
        }

    }
}
