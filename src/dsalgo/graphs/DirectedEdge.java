package dsalgo.graphs;

public class DirectedEdge {

    private int v,w;
    private double weight;
    public DirectedEdge(int v, int w, double weight){
        this.v = v;
        this.w = w;
        this.weight = weight;
    }
    public int from(){
        return v;
    }
    public int to(){
        return w;
    }
    @Override
    public String toString(){
        return v + " -> " + w;
    }
}
