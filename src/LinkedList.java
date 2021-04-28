public class LinkedList {
    public class Node{
        int data;
        Node next;

        public Node(int nodeData){
            data = nodeData;
            next = null;
        }
    }
    protected Node head = null;
    protected Node tail = null;
    
    public LinkedList(){

    }
    
    public void print(){

        Node thead = head;
        while(thead != null){
            System.out.println(thead.data);
            thead = thead.next;
        }
    }

    public void insert(int data){
        if(head == null){
            head = new Node(data);
            return;
        }

        Node newNode = new Node(data);

        Node last = head;
        while(last.next != null){
            last = last.next;
        }
        last.next = newNode;

    }

    public void insertAfter(int data, int afterValue){

        if(head == null)
            return;
        
        Node newNode = new Node(data);

        Node last = head;
        while(last.next != null){

            if(last.data == afterValue)
            {
                newNode.next = last.next;
                last.next = newNode;
                return;
            }
            last = last.next;
        }
        System.out.println(afterValue + " Not found");

    }

    public int findNodeAt(int pos){
        
        if(head == null)
            return -1;
        
        int count = 0;
        Node last = head;
        while(last.next != null){
            if(count == pos){
                return last.data;
            }
            count++;
            last = last.next;
        }
        return -1;
    }

    public void deleteNode(int value){
        
        if(head == null)
            return;
        
        Node last = head;
        while(last.next != null){
            if(last.next.data == value){
                last.next = last.next.next;
                return;

            }
            last = last.next;
        }
    }
    public void deleteLast(){
        
        if(head == null)
            return;
        
        Node last = head;
        Node prev = null;
        while(last.next != null){
            prev = last;
            last = last.next;
        }
        prev.next = null;
    }
    public void insertFirst(int value)
    {
        Node newHead = new Node(value);
        newHead.next = head;
        head = newHead;
    }

    public int deleteHead(){
        int ret = -1;
        if(head == null)
            return ret;
        ret = head.data;
        head = head.next;
        return ret;
    }

    public int getHeadData(){
        if(head == null)
            return -1;
        
        return head.data;
    }
}
