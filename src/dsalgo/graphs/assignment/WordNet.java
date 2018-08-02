package dsalgo.graphs.assignment;


import dsalgo.graphs.graphAlgos.DepthSearch;
import edu.princeton.cs.algs4.*;

import java.util.Iterator;

/**
 * WordNet is a semantic lexicon for the English language that computational linguists and cognitive
 * scientists use extensively.
 *
 * Synset - WordNet groups words into sets of synonyms called synsets
 *      e.g. { AND circuit, AND gate } is a synset that represent a logical gate that fires only when all of its inputs fire
 *
 * WordNet also describes semantic relationships between synsets. One such relationship is the is-a relationship.
 * , which connects a hyponym (more specific synset) to a hypernym (more general synset).
 *      e.g. The synset { gate, logic gate } is a hypernym of { AND circuit, AND gate } because an AND gate is a kind of logic gate.
 *          w  Hypernym { gate, logic gate}             Superclass
 *          v  Hyponym  { AND circuit, AND gate }       Subclass
 *          for an edge v->w
 */
public class WordNet {
    /*
     *      The WordNet digraph. Your first task is to build the WordNet digraph: each vertex v is an integer that
     * represents a synset, and each directed edge v→w represents that w is a hypernym of v. The WordNet digraph
     * is a rooted DAG: it is acyclic and has one vertex—the root—that is an ancestor of every other vertex. However, it
     * is not necessarily a tree because a synset can have more than one hypernym.
     * A small subgraph of the WordNet digraph appears below.
     */

    private ST<String, Integer> idToWordLookup;
    private ST<Integer, String> wordToIdLookup;
    private Digraph G;

    /**
     * constructor takes the name of the two input files
     */
    public WordNet(String synsets, String hypernyms){
        if (null == synsets || null == hypernyms){
            throw new java.lang.IllegalArgumentException();
        }
        this.idToWordLookup = new ST<>();
        this.wordToIdLookup = new ST<>();

        // Build symbol table - look up for [ noun -- to -> synset id ]
        In in1 = new In(synsets);
        int V = 0;
        while(in1.hasNextLine()){
            String[] record = in1.readLine().split(",");
            int idx = Integer.parseInt(record[0]);
            for(String noun : record[1].split(" ")) {
                idToWordLookup.put(noun, idx);
            }
            wordToIdLookup.put(idx, record[1]);
            V++;
        }

        // Build digraph from hypernym file
        In in2 = new In(hypernyms);
        G = new Digraph(V);
        while (in2.hasNextLine()) {
            String[] record = in2.readLine().split(",");
            for (int x = 1 ; x < record.length ; x++) {
                G.addEdge(Integer.parseInt(record[0]), Integer.parseInt(record[x]));
            }
        }

    }

    // returns all WordNet nouns
    public Iterable<String> nouns(){
        return idToWordLookup.keys();
    }

    // is the word a WordNet noun?
    public boolean isNoun(String word){
        return idToWordLookup.contains(word);
    }

    // distance between nounA and nounB (defined below)
    public int distance(String nounA, String nounB){
        int s = idToWordLookup.get(nounA);
        int t = idToWordLookup.get(nounB);
        BreadthFirstDirectedPaths bfsPath = new BreadthFirstDirectedPaths(G,s);
        return bfsPath.distTo(t);
    }

    // a synset (second field of synsets.txt) that is the common ancestor of nounA and nounB
    // in a shortest ancestral path (defined below)
    public String sap(String nounA, String nounB){
        int s = idToWordLookup.get(nounA);
        int t = idToWordLookup.get(nounB);
        Topological topo = new Topological(G);
        DepthFirstDirectedPaths dfspS = new DepthFirstDirectedPaths(G,s);
        DepthFirstDirectedPaths dfspT = new DepthFirstDirectedPaths(G,t);
        DepthFirstOrder dforder = new DepthFirstOrder(G);

        BreadthFirstDirectedPaths bfpS = new BreadthFirstDirectedPaths(G,s);
        BreadthFirstDirectedPaths bfpT = new BreadthFirstDirectedPaths(G,t);
        int CA = -1;


        System.out.println("Rank of nounA " + s + " is " + topo.rank(s));
        System.out.println("Rank of nounB " + t + " is " + topo.rank(t));
        int higherOne = topo.rank(s) < topo.rank(t) ? topo.rank(s) : topo.rank(t) ;

//        for (int i = 0 ; i <= higherOne; i--) {
//            if ()
//        }
        System.out.println("is DAG ? " + topo.isDAG());
//        for (int rank = 99 ; rank >= 0 ; rank++ )

        for ( int x : dforder.post()) {
            System.out.println("w " + x + " -> " + wordToIdLookup.get(x) );

            if(dfspS.hasPathTo(x)){
                CA = x ;
            } else {
                break;
            }
        }
        System.out.println(CA);
        System.out.println(dfspS.pathTo(CA));
        System.out.println(dfspT.pathTo(CA));
        //  Step 1 Find common ancestor
        //  Step 2 find shortest path to the common ancestor from both the verteces

//        BreadthFirstDirectedPaths bfsPath = new BreadthFirstDirectedPaths(G,s);
//        bfsPath.hasPathTo(t);
//        bfsPath.pathTo(t);
        return "happy";
    }

    // do unit testing of this class
    public static void main(String[] args){
        String SYNSET_FILE = "C:\\Users\\jariwabh\\IdeaProjects\\CodeCompete\\src\\dsalgo\\graphs\\assignment\\wordnet\\synsets100-subgraph.txt";
        String HYPERNYM_FILE = "C:\\Users\\jariwabh\\IdeaProjects\\CodeCompete\\src\\dsalgo\\graphs\\assignment\\wordnet\\hypernyms100-subgraph.txt";
        WordNet wnet = new WordNet(SYNSET_FILE,HYPERNYM_FILE);
        System.out.println("is namaste in wordnet of 100? " + wnet.isNoun("namaste"));
        System.out.println("is jimdandy in wordnet of 100? " + wnet.isNoun("jimdandy"));
        System.out.println(wnet.nouns());
        wnet.sap("jimdandy","horror");

    }
}
