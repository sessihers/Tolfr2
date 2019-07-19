public class GraphProperties
{
  private Graph G;
  
  public GraphProperties(Graph G)
  {
    this.G = new Graph(G);
  }
  
  public int eccentricity(int V)
  {
    BreadthFirstPaths BFP = new BreadthFirstPaths(G, V);
    int max = -1;
    for(int i = 0; i < G.V(); i++)
    {
      if(BFP.hasPathTo(i))
      {
        if(BFP.distTo(i) > max)
        {
          max = BFP.distTo(i);
        }
      }
    }
    return max;
  }
  
  public int diameter()
  {
    int max = 0;
    for(int i = 0; i < G.V(); i++)
    {
      if(eccentricity(i) > max)
      {
        max = eccentricity(i);
      }
    }
    return max;
  }
  
  public int radius()
  {
    int min = G.V() + 1;
    for(int i = 0; i < G.V(); i++)
    {
      if(eccentricity(i) == -1) {}
      else if(eccentricity(i) < min)
      {
        min = eccentricity(i);
      }
    }
    return min;
  }
  
  public int center()
  {
    int min = G.V() + 1;
    int center = 0;
    for(int i = 0; i < G.V(); i++)
    {
      if(eccentricity(i) == -1) {}
      else if(eccentricity(i) < min)
      {
        min = eccentricity(i);
        center = i;
      }
    }
    return center;
  }
  
  public int girth()
  {
    BreadthFirstPaths[] BFP = new BreadthFirstPaths[G.V()];
    for(int i = 0; i < G.V(); i++)
    {
      BFP[i] = new BreadthFirstPaths(G, i);
    }
    int min = G.V() + 1;
    for(int i = 0; i < G.V(); i++)
    {
      for(int j : G.adj(i))
      {
        for(int k : G.adj(i))
        {
          if(k != j)
          {
            if(BFP[j].distTo(k) + 2 < min) min = BFP[j].distTo(k) + 2;
          }
        }
      }
    }
    return min;
  }
  
  public static void main(String[] args){
    In I = new In();
    Graph G = new Graph(I);
    GraphProperties GP = new GraphProperties(G);
    int s = GP.girth();
    System.out.println(s);
  }
}