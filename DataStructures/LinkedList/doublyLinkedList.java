import java.util.Scanner;

public class doublyLinkedList{
    Node head;
    class Node{
        int data;
        Node next;
        Node prev;
        Node(int d){
            data = d;
        }
    }
    public void push(int d){
        Node newNode = new Node(d);
        if(head==null){
            newNode.next=null;
            newNode.prev=null;
            head=newNode;
            return;
        }
        newNode.next=head;
        newNode.prev=null;
        head.prev=newNode;
        head=newNode;
    }
    public void insertAfter(int d, int key){
        Node newNode = new Node(d);
        Node temp = head;
        while(temp!=null){
            if(temp.data==key && temp.next==null){
                temp.next=newNode;
                newNode.prev=temp;
                newNode.next=null;
                return;
            }else if(temp.data==key){
                newNode.next=temp.next;
                newNode.prev=temp;
                temp.next.prev=newNode;
                temp.next=newNode;
                return;
            }
            temp = temp.next;
        }
    }
    public void insertBefore(int d,int key){
        Node newNode = new Node(d);
        Node temp = head;
        while(temp!=null){
            if(temp.data==key && temp.prev==null){
                newNode.next=head;
                newNode.prev=null;
                head.prev=newNode;
                head=newNode;
                return;
            }else if(temp.data==key){
                newNode.prev=temp.prev;
                newNode.next=temp;
                temp.prev.next = newNode;
                temp.prev = newNode;
                return;
            }
            temp = temp.next;
        }
    }
    public void append(int d){
        Node newNode = new Node(d);
        Node temp= head;
        while(temp!=null){
            if(temp.next==null){
                temp.next=newNode;
                newNode.prev=temp;
                newNode.next=null;
            }
            temp = temp.next;
        }
    }
    public void delete(int d){
        Node temp = head;
        if(temp.next==null){
            head=null;
            return;
        }
        while(temp!=null){
            if(temp.data==d && temp==head){
                head.next.prev=null;
                head = head.next;
                return;
            }else if(temp.data==d && temp.next==null){
                temp.next=null;
                return;
            }else if(temp.data==d){
                temp.prev.next=temp.next;
                temp.next.prev=temp.prev;
                return;
            }
            temp = temp.next;
        }
    }
    public void display(){
        if(head==null){
            System.out.println("The doubly linked list is empty");
            return;
        }
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+"\t");
            temp = temp.next;
        }
        System.out.println("");
    }
    public static void main(String[] args){
        doublyLinkedList list = new doublyLinkedList();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Enter the option you want to perform on the list:\n 1.insert a node at front \n 2.insert a node after specified node \n 3.insert a node before specified node \n 4.insert a node in the last \n 5.delete a node in the list \n 6.display \n 7.Any other number to stop");
            int choice = sc.nextInt();
            if(choice==1){
                System.out.println("Enter the element you want to insert:");
                int x = sc.nextInt();
                list.push(x);
            }else if(choice==2){
                System.out.println("Enter the element you want to insert and the element after which the node to be inserted:");
                int x = sc.nextInt();
                int y = sc.nextInt();
                list.insertAfter(x, y);
            }else if(choice==3){
                System.out.println("Enter the element you want to insert and the element before which the node to be inserted:");
                int x = sc.nextInt();
                int y = sc.nextInt();
                list.insertBefore(x, y);
            }else if(choice==4){
                System.out.println("Enter the element you want to insert:");
                int x = sc.nextInt();
                list.append(x);
            }else if(choice==5){
                System.out.println("Enter the element you want to deleted:");
                int x = sc.nextInt();
                list.delete(x);
            }else if(choice==6){
                list.display();
            }else{
                break;
            }
        }
    }
}