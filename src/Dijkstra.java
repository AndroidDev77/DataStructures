
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Map.Entry;
import java.util.LinkedList;

public class Dijkstra {
    
    public static WeightedGraph calculateShortestPathFromSource(WeightedGraph graph, WeightedGraph.Node source){

        source.setDistance(0);

        PriorityQueue<WeightedGraph.Node> unsettledNodes = new PriorityQueue<>();
        Set<WeightedGraph.Node> settledNodes = new HashSet<>();

        unsettledNodes.add(source);

        while(!unsettledNodes.isEmpty()){

            WeightedGraph.Node currNode = unsettledNodes.poll();

            for(Entry<WeightedGraph.Node, Integer> adjPair : currNode.getAdjNodes().entrySet()){
                WeightedGraph.Node adjNode = adjPair.getKey();
                Integer edgeWeight = adjPair.getValue();

                if(!settledNodes.contains(adjNode)){
                    CalculateMinDist(adjNode, edgeWeight, currNode);
                    unsettledNodes.add(adjNode);
                }
            }
            settledNodes.add(currNode);
        }
        return graph;
    }
    
    public static void CalculateMinDist(WeightedGraph.Node destNode, Integer edgeWeight, WeightedGraph.Node sourceNode){

        Integer sourceDist = sourceNode.getDistance();
        Integer currDist = sourceDist + edgeWeight;
        if(currDist < destNode.getDistance()){
            destNode.setDistance(currDist);
            //LinkedList<WeightedGraph.Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
            //shortestPath.add(sourceNode);
            //destNode.setShortestPath(shortestPath);
        }
    }

}
