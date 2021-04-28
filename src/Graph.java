import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Objects;

public class Graph {

    public class Node{

        int data;
        public Node(int value){
            data = value;
        }

        @Override
        public boolean equals(Object o) {
  
            // If the object is compared with itself then return true  
            if (o == this) {
                return true;
            }

            if (!(o instanceof Node)) {
                return false;
            }
              
            Node c = (Node) o;
              
            return data == c.data;
        }

        @Override
        public int hashCode(){

            return Objects.hash(data);
        }
    }
    HashMap<Node, ArrayList<Node>> nodes;
    // 0 - 1, 4, 5
    // 1 - 3, 4
    // 2 - 1
    // 3 - 2, 4
    // 4 -
    // 5 -
    public Graph(){
        nodes = new HashMap<Node, ArrayList<Node>>();
    }



    private void visit(Node node){
        System.out.println(node.data);
    }


    public void addNode(int value){
        nodes.putIfAbsent(new Node(value), new ArrayList<>());
    }

    public void removeNode(int value){

        Node node = new Node(value);

        nodes.values().stream().forEach(e -> e.remove(node));
        nodes.remove(node);
    }

    public void addEdge(int value1, int value2){

        Node node1 = new Node(value1);
        Node node2 = new Node(value2);
         
        nodes.get(node1).add(node2);
        //nodes.get(node2).add(node1);
    }

    public void removeEdge(int value1, int value2){
        Node node1 = new Node(value1);
        Node node2 = new Node(value2);

        nodes.get(node1).remove(node2);
        //nodes.get(node2).remove(node1)
    }

    public void DFS(int value){
        LinkedHashSet<Node> visited = new LinkedHashSet<>();
        DFS(new Node(value), visited);

    }

    public void DFS(Node node, LinkedHashSet<Node> visited){

        //Recursive
        if(node == null)
            return;
        
        visit(node);
        visited.add(node);

        for(Node n : nodes.get(node)){
            if(!visited.contains(n)){
                DFS(n, visited);
            }
        }
        
    }

    public void BFS(int value){
        LinkedHashSet<Node> visited = new LinkedHashSet<>();
        java.util.Queue<Node> queue = new LinkedList<>();

        Node root = new Node(value);

        visit(root);
        visited.add(root);
        queue.add(root);
        
        while(!queue.isEmpty()){
            Node node = queue.poll();
            for(Node n : nodes.get(node)){
                if(!visited.contains(n)){
                    visit(n);
                    visited.add(n);
                    queue.add(n);
                }
            }
        }

        

    }
}
