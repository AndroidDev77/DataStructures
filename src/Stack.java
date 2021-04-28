
/*
Stack
space    - O(n)
push     - O(1)
pop      - O(1)
traverse - O(n)
*/
public class Stack {
    LinkedList list;

    public Stack(){
        list = new LinkedList();

    }
    public void print(){
        list.print();
    }
    public void push(int value){
        list.insertFirst(value);
    }

    public int pop(){
        return list.deleteHead();
    }

}
