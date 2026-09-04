class Queue{
    int head;
    int tail;
    int[] Queuearray;

    public Queue(int n){
        this.head = 0;
        this.tail = 0;
        this.Queuearray = new int[n];
    }

    public boolean isEmpty(){
        return this.head == this.tail;
    }

    public boolean isFull(){
        return this.tail == this.Queuearray.length-1&&this.head == 0;
    }
    public void enqueue(int x){
        if(!isFull()){
            this.Queuearray[this.tail] = x;
            this.tail++;
        }
    }
    public int dequeue(){
            int num = this.Queuearray[this.head];
            this.Queuearray[this.head] = 0;
            this.head++;
            return num;
        
        
    }
}

class SinglyList {
    Node head;
    int length;

    public SinglyList() {
        this.head = null;
        this.length = 0;
    }

    public void traverse(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.x + " ");
            current = current.next;
        }
        System.out.println();
    }

    public Node search(Node head, int value) {
        Node current = head;
        while (current != null && current.x != value) {
            current = current.next;
        }
        return current;
    }

    public void insert(int value) {
        Node tempNode = new Node(value, null, null);
        if (this.head != null) {
            tempNode.next = this.head;
            this.head = tempNode;
        }
        this.length++;
    }

    public void delete(Node node) {
        if (this.head == null) {
            return;
        }
        if (node == this.head) {
            this.head = node.next;
            node = null;
            this.length--;
            return;
        }
        Node current = this.head;
        while (current.next != node && current.next != null) {
            current = current.next;
        }
        if (current.next == node) {
            current.next = node.next;
            node = null;
            this.length--;
        }
    }
}


// Microsoft.Sqlcmd
// Microsoft.SQLServerManagementStudio
// Microsoft.SQLServer.2022.Developer

class Stack{
    int top;
    SinglyList list;

    public Stack(int n){
        this.top = 0;
        this.list = new SinglyList();
    }

    public boolean isEmpty(){
        return this.top == 0;
    }

    public boolean isFull(){
        return this.top == this.list.length;
    }
    public void push(int x){
        if(!isFull()){
            this.list.insert(x);
            this.top++;
        }
    }
    public int pop(){
            this.top--;
            int num = this.list.search(this.list.head, this.top).x;
            this.list.delete(this.list.search(this.list.head, this.top));
            return num;
        
        
    }
}
class LinkedList{
    Node head;
    
    public LinkedList(){
        this.head = null;
    }
    public void traverse(Node head){
        Node current = head;
        while(current != null){
            System.out.print(current.x+" ");
            current = current.next;
        }
        System.out.println();
    }
    public Node search(Node head, int value){
        Node current = head;
        while(current != null&&current.x != value){
            current = current.next;
        }
        return current;
    }
    public void insert(int value){
        Node tempNode = new Node(value, null, null);
        if(this.head != null){
            this.head.pred = tempNode;
            tempNode.next = this.head;
            this.head = tempNode;
        }
    }
    public void delete (Node node){
        if(this.head == null){
            return;
        }
        if(node.pred != null){
            node.pred.next = node.next;
        }
        else{
            this.head = node.next;
        }
        if(node.next != null){
            node.next.pred = node.pred;
        }
        node = null;
    }
    public void deleteByValue(LinkedList list, int value){
        Node node = search(list.head, value);
        if(node != null){
            delete(node);
        }
    }
    
}

class Node{
    int x;
    Node pred;
    Node next;
    
    public Node(int x){
        this.x = x;
        this.pred = null;
        this.next = null;
}
    public Node(int x, Node pred, Node next){
        this.x = x;
        this.pred = pred;
        this.next = next;
    }
    
}

public class LinkedListDemo {
public static void main(String[] args) {
    LinkedList list = new LinkedList();
    list.insert(1);
    list.insert(2);
    list.insert(3);
    list.insert(4);
    list.insert(5);
    list.traverse(list.head);
    list.deleteByValue(list, 3);
    list.traverse(list.head);
}
}