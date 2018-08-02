package dsalgo.graphs.graphdDS;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

public class Digraph {
    private int V;
    private int E;
    private Bag[] adj;
    public Digraph(int V){    // Create a V vertex graph with no edges
        this.V = V;
        this.E = 0;
        adj = new Bag[V];
        for(int i=0;i<V;i++){
            adj[i] = new Bag<Integer>();
        }
    }
    public Digraph(In in) {  // Create a V vertex graph with E edges
        this(in.readInt());     // read number of vertices
        this.E = in.readInt();  // Read number of edges
        for (int i = 0; i<E ; i++){
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v,w);
        }
    }
    public int V(){   // return number of edges
        return this.V;
    }
    public int E(){   // return number of edges
        return this.E;
    }
    public Iterable<Integer> adj(int v){
        return adj[v];
    }
    public void addEdge(int v,int w){
        adj[v].add(w);

    }
    public static void main(String args[]){
        Digraph G = new Digraph(new In(args[0]));
        for ( int v = 0; v < G.V(); v++ ) {
            for (int w : G.adj(v)) {
                System.out.println(v + "->" + w);
            }
        }
        System.out.println("System has " + G.E() + " edges");
    }
}
