import java.util.Arrays;

public class App {
    public class Test{
        int c = 3;

        public void printValue(){
            System.out.println(c);
        }
    }
    public static void main(String[] args) throws Exception {

        int test = 8;
        if(test == 1){
            LinkedList list = new LinkedList();
            
            list.insert(5);
            list.insert(4);
            list.insert(3);
            list.insert(2);
            list.insert(1);

            list.insertAfter(9, 5);
            int pos = 9;
            System.out.println("At Pos: " + pos +" : "+ list.findNodeAt(pos));
            list.print();

            list.insertFirst(10);
            System.out.println();
            list.print();
            System.out.println();
            int headvalue = list.deleteHead();
            System.out.println("Removed Head:  " + headvalue);
            list.print();
        }
        else if(test == 2){
            Queue queue = new Queue();

            queue.enqueue(5);
            queue.enqueue(4);
            queue.enqueue(3);
            queue.enqueue(2);
            queue.enqueue(1);
            
            queue.print();
            System.out.println();
            int dequedValue = queue.dequeue();
            System.out.println("Removed: " + dequedValue);
            queue.print();

            queue.enqueue(9);

            System.out.println();

            queue.print();
            System.out.println();
            dequedValue = queue.dequeue();
            System.out.println("Removed: " + dequedValue);
            queue.print();
        }
        else if(test == 3){
            Stack stack = new Stack();

            stack.push(1);
            stack.push(2);
            stack.push(3);
            stack.push(4);
            stack.push(5);

            stack.print();
            System.out.println();

            int popedValue = stack.pop();
            System.out.println("Removed: " + popedValue);

            stack.print();
            stack.push(9);
            System.out.println();
            stack.print();
        }
        else if(test == 4){
            BinarySearchTree tree = new BinarySearchTree();
            tree.insert(4);
            tree.insert(5);
            tree.insert(7);
            tree.insert(2);
            tree.insert(8);

            BinarySearchTree.traverseInorder(tree.root);

            int findValue = 8;
            boolean findAns = tree.search(findValue);

            System.out.println("Found "+ findValue + " ?: " + findAns) ;
        }
        else if(test == 5){
            // 0 - 1, 4, 5
            // 1 - 3, 4
            // 2 - 1
            // 3 - 2, 4
            // 4 -
            // 5 -
            Graph graph = new Graph();
            graph.addNode(0);
            graph.addNode(1);
            graph.addNode(2);
            graph.addNode(3);
            graph.addNode(4);
            graph.addNode(5);

            graph.addEdge(0, 1);
            graph.addEdge(0, 4);
            graph.addEdge(0, 5);

            graph.addEdge(1, 3);
            graph.addEdge(1, 4);

            graph.addEdge(2, 1);

            graph.addEdge(3, 2);
            graph.addEdge(3, 4);

            System.out.println("DFS");
            graph.DFS(0);

            System.out.println("BFS");
            graph.BFS(0);


        }
        else if(test == 6){
            int arr[] = {4, 1, 3, 5, 2}; 
            Sort.MergeSort.sort(arr, 0, arr.length - 1);
            System.out.println(Arrays.toString(arr));
        }
        else if(test == 7){
            WeightedGraph wgraph = new WeightedGraph();

            WeightedGraph.Node nodeA = wgraph.new Node("A");
            WeightedGraph.Node nodeB = wgraph.new Node("B");
            WeightedGraph.Node nodeC = wgraph.new Node("C");
            WeightedGraph.Node nodeD = wgraph.new Node("D"); 
            WeightedGraph.Node nodeE = wgraph.new Node("E");
            WeightedGraph.Node nodeF = wgraph.new Node("F");

            nodeA.addDestination(nodeB, 10);
            nodeA.addDestination(nodeC, 15);

            nodeB.addDestination(nodeD, 12);
            nodeB.addDestination(nodeF, 15);

            nodeC.addDestination(nodeE, 10);

            nodeD.addDestination(nodeE, 2);
            nodeD.addDestination(nodeF, 1);

            nodeF.addDestination(nodeE, 5);

            //WeightedGraph graph = new WeightedGraph();

            wgraph.addNode(nodeA);
            wgraph.addNode(nodeB);
            wgraph.addNode(nodeC);
            wgraph.addNode(nodeD);
            wgraph.addNode(nodeE);
            wgraph.addNode(nodeF);

            wgraph = Dijkstra.calculateShortestPathFromSource(wgraph, nodeA);
            nodeF.printShortestPath();
            System.out.println("Cost: " + nodeF.getDistance());
        }
        else if(test == 8){
            //LCS Longest common substring
            String A = "topharry";
            String B = "toqharr";
            int[][] dp = new int[A.length() + 1][B.length() + 1];
            for (int i = 1; i < dp.length; i++) {
                for (int j = 1; j < dp[0].length; j++) {
                    /*checking characters at index - 1 as 0th character
                     *  of given String is at 1st index in DP matrix */
                    System.out.println(A.charAt(i-1) + " =? " + B.charAt(j -1));
                     if (A.charAt(i-1) == B.charAt(j-1)) {
                        
                        /*optimal substructure as explained in the article*/
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                        System.out.println("dp[i][j] = " + dp[i][j]);
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                        System.out.println("dp[i][j] = " + dp[i][j]);
                    }
                }
            }

            System.out.print(dp[A.length()][B.length()]);
        }
        //Test t = new App().new Test();
        //t.printValue();

    }
}
