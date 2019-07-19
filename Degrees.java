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
    Bag<Integer> s = new Bag<Integer>();
    for(int i = 0; i < G.V(); i++)
    {
      if(indegree(i) == 0) s.add(i);
    }
    return s;
  }
  
  public Iterable<Integer> sinks()
  {
    Bag<Integer> s = new Bag<Integer>();
    for(int i = 0; i < G.V(); i++)
    {
      if(outdegree(i) == 0) s.add(i);
    }
    return s;
  }
  
  public boolean isMap()
  {
    for(int i = 0; i < G.V(); i++)
    {
      if(outdegree(i) != 1) return false;
    }
    return true;
  }
  
  public static void main(String[] args){
    In I = new In();
    Digraph G = new Digraph(I);
    Degrees Dgs = new Degrees(G);
    for(int i : Dgs.sources())
    {
      System.out.println(i);
    }
    for(int i : Dgs.sinks())
    {
      System.out.println(i);
    }
  }
}