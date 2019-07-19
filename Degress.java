public class Degrees
{
  private Digraph G;
  
  public Degrees(Digraph G)
  {
    this.G = new Digraph(G);
  }
  
  public int indegree(int v)
  {
    return G.indegree(v);
  }
  
  public int outdegree(int v)
  {
    return G.outdegree(v);
  }
  
  public Iterable<Integer> sources()
  {
    Bag s = new Bag();
    for(int i = 0; i < G.V(); i++)
    {
      if(indegree(i) == 0) return s.add(i);
    }
    return s;
  }
  
  public Iterable<Integer> sinks()
  {
  }
  
  public boolean isMap()
  {
  }
  
  public static void main(String[] args){
    In I = new In();
    Graph G = new Graph(I);
    GraphProperties GP = new GraphProperties(G);
    int s = GP.girth();
    System.out.println(s);
  }
}