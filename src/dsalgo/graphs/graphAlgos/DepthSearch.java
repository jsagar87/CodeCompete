package dsalgo.graphs.graphAlgos;

import dsalgo.graphs.graphdDS.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;

public class DepthSearch {

    private boolean markedVertex[];
    private int edgeTo[];

    public DepthSearch(Graph G, int s){
        this.markedVertex = new boolean[G.V()];
        this.edgeTo = new int[G.V()];
        for ( int i = 0; i < G.V(); i++ ) {
            this.markedVertex[i] = false;
        }
        DFS(G,s);
    }
    private void DFS(Graph G,int v){
        Stack<Integer> path = new Stack<>();
        if (!markedVertex[v]){
            markedVertex[v] = true;
            for (int w : G.adj(v)) {
                DFS(G,w);
                edgeTo[w] = v;
            }
        }
    }
    private boolean isConnected(int t){  // in constant time figure out if vertex is connected or not
        return markedVertex[t];
    }

    public static void main(String[] args) {
        // Build graph
        Graph G = new Graph(new In(args[0]));
        for ( int v = 0; v < G.V(); v++ ) {
            for (int w : G.adj(v)) {
                System.out.println(v + "-" + w);
            }
        }
        System.out.println("System has " + G.E() + " edges");
        // Construct DFS for 0
        DepthSearch dSearch = new DepthSearch(G,10);
        for (int v =0 ; v < G.E() ; v++ ) {
            System.out.println("is 0 and "+ v + " connected " + dSearch.isConnected(v));
        }
    }
}
