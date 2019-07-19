public class ewdNew {
    private static final String NEWLINE = System.getProperty("line.separator");

    private final int V;                // number of vertices in this digraph
    private int E;                      // number of edges in this digraph
    private BagNew<DirectedEdge>[] adj;    // adj[v] = adjacency list for vertex v

    
  
    public ewdNew(int V) {
        if (V < 0) throw new IllegalArgumentException("Number of vertices in a Digraph must be nonnegative");
        this.V = V;
        this.E = 0;
        adj = (BagNew<DirectedEdge>[]) new BagNew[V];
        for (int v = 0; v < V; v++)
            adj[v] = new BagNew<DirectedEdge>();
    }
 
    public int V() {
        return V;
    }

    public int E() {
        return E;
    }


    public void addEdge(DirectedEdge e) {
        int v = e.from();
        int w = e.to();
        adj[v].add(e);
        E++;
    }

    public Iterable<DirectedEdge> adj(int v) {
        return adj[v];
    }

 

    public Iterable<DirectedEdge> edges() {
        BagNew<DirectedEdge> list = new BagNew<DirectedEdge>();
        for (int v = 0; v < V; v++) {
            for (DirectedEdge e : adj(v)) {
                list.add(e);
            }
        }
        return list;
    } 




}