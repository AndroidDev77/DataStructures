import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.LinkedList;

public class WeightedGraph {

    
    public class Node implements Comparable<Node>{

        String name;
        Integer distance;
        LinkedList<Node> shortestPath;
        HashMap<Node, Integer> adjNodes;
        public Node(String name){
            this.name = name;
            this.distance = Integer.MAX_VALUE;
            this.adjNodes = new HashMap<>();
            this.shortestPath = new LinkedList<>();
        }

        public void printShortestPath(){
            
            shortestPath.forEach(System.out::println);
            System.out.println(name);
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        public int getDistance() {
            return distance;
        }

        public void setShortestPath(LinkedList<Node> shortestPath) {
            this.shortestPath = shortestPath;
        }

        public LinkedList<Node> getShortestPath() {
            return shortestPath;
        }

        public HashMap<Node, Integer> getAdjNodes() {
            return adjNodes;
        }
        public void setAdjNodes(HashMap<Node, Integer> adjNodes) {
            this.adjNodes = adjNodes;
        }

        public void addDestination(Node dest, int distance){
            adjNodes.put(dest, distance);
        }

        @Override
        public String toString() {
            return this.name;
        }
    
        @Override
        public int compareTo(WeightedGraph.Node o) {
            if(this.distance < o.distance)
                return -1;
            else if(this.distance > o.distance)
                return 1;
            return 0;
        }
    }
    Set<Node> nodes;

    public WeightedGraph(){
        nodes = new HashSet<Node>();
    }

    public void addNode(Node node){
        nodes.add(node);
    }

    public Set<Node> getNodes(){
        return nodes;
    }

    public void SetNodes(Set<Node> nodes){
        this.nodes = nodes;
    }
}
