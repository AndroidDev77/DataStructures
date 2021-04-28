
/*
Queue
space    - O(n)
enqueue  - O(n)
dequeue  - O(1)
peek     - O(1)
traverse - O(n)
*/
public class Queue {
    LinkedList list;

    public Queue()
    {
        list = new LinkedList();
        
    }

    public void enqueue(int value){

        list.insert(value);
    }

    public int dequeue(){
        int value = list.deleteHead();
        return value;
    }
    
    public int peek(){
        return list.getHeadData();
    }
    public void print(){
        list.print();
    }
}
