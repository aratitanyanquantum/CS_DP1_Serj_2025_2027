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


}