package dsalgo.graphs;

public class TestDirectedEdge {

    public  void testEdgeTo(){
        DirectedEdge de = new DirectedEdge(2,3,3.8);
        assert de.to() == 3;
    }
    public void testEdgeFrom(){
        DirectedEdge de = new DirectedEdge(2,3,3.8);
        assert de.from() == 2;
    }

    public void testToString(){
        DirectedEdge de = new DirectedEdge(2,3,3.8);
        System.out.println(de.toString());
        assert de.toString().equals("2 -> 3");
    }

    public static void main(String args[]){
        TestDirectedEdge harness = new TestDirectedEdge();

        harness.testEdgeTo();
        harness.testEdgeFrom();
        harness.testToString();
        System.out.println("Completed successfully");
    }
}
