public class SourceSinkSP
{
  private EdgeWeightedDigraph G;
  
  public SourceSinkSP(EdgeWeightedDigraph G)
  {
    this.G = new EdgeWeightedDigraph(G);
  }
  
  //Gefur lengd milli s og t
  public double distBetween(int s, int t)
  {
    DijkstraSP dsp = new DijkstraSP(G, s);
    return dsp.distTo(t);
  }
  
  //Gefur leiðina milli s og t
  public Iterable<DirectedEdge> pathBetween(int s, int t)
  {
    DijkstraSP dsp = new DijkstraSP(G, s);
    Stack<DirectedEdge> path = new Stack<DirectedEdge>();
    for(DirectedEdge i : dsp.pathTo(t))
    {
      path.push(i);
    }
    return path;
  }
}