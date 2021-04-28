import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class DijkstraSimple {
    
    public class Node implements Comparable{
        String name;
        int cost;
        //Nodes - EdgeWeight
        HashMap<Node, Integer> adjNodes;
        LinkedList<Node> shortestPath;

        public Node(String name) {
            this.name = name;
            cost = Integer.MAX_VALUE;
            adjNodes = new HashMap<>();
            shortestPath = new LinkedList<>();

        }
        public void addEdge(Node node, int weight){
            adjNodes.put(node, weight);
        }

        public void setCost(int cost){
            this.cost = cost;
        }

        public int getCost(){
            return cost;
        }
        @Override
        public int compareTo(Object o) {
            // TODO Auto-generated method stub
            Node c = (Node)o;

            if(this.cost < c.cost)
                return -1;
            else if( this.cost > c.cost)
                return 1;
            else
                return 0;
        }
    }

    HashSet<Node> nodes;

    public DijkstraSimple(){
        nodes = new HashSet<>();

    }

    public Node addNode(String name){
        Node node = new Node(name);
        nodes.add(node);
        return node;
    }

    
    public void FSP(Node source){

        PriorityQueue<Node> unsettled = new PriorityQueue<>();
        HashSet<Node> settled = new HashSet<>();
        
        source.setCost(0);
        unsettled.add(source);

        while(!unsettled.isEmpty()){

            Node node = unsettled.poll();
            for(Map.Entry<Node, Integer> entry : node.adjNodes.entrySet()){
                Node adjNode = entry.getKey();
                Integer weight = entry.getValue();

                if(!settled.contains(adjNode)){
                    int newCost = node.getCost() + weight;
                    if(newCost < adjNode.getCost()){
                        adjNode.setCost(newCost);
                        LinkedList<Node> sp = new LinkedList<>(node.shortestPath);
                        sp.add(node);
                        adjNode.shortestPath = sp;

                    }
                    unsettled.add(adjNode);
                }
            }
            settled.add(node);
        }


    }

    public static void main(String[] args) {
        DijkstraSimple ds = new DijkstraSimple();
        
        Node nodea = ds.addNode("A");
        Node nodeb = ds.addNode("B");
        Node nodec = ds.addNode("C");
        Node noded = ds.addNode("D");
        Node nodee = ds.addNode("E");
        Node nodef = ds.addNode("F");

        nodea.addEdge(nodeb, 10);
        nodea.addEdge(nodec, 15);

        nodeb.addEdge(noded, 12);
        nodeb.addEdge(nodef, 15);
        
        nodec.addEdge(nodee, 10);

        noded.addEdge(nodee, 2);
        noded.addEdge(nodef, 1);

        nodef.addEdge(nodee, 5);

        ds.FSP(nodea);

        System.out.println(nodef.getCost());
        

        
        
    }

}
