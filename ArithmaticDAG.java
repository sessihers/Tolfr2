public class ArithmaticDAG
{
  private SymbolDigraph SG;
  private Digraph G;
  
  public ArithmaticDAG(SymbolDigraph SG)
  {
    this.SG = SG;
    Digraph G = SG.digraph();
    DirectedCycle dc = new DirectedCycle(G);
    if (dc.hasCycle()) throw new IllegalArgumentException("Digraph must be a DAG");
  }
  
  public double value()
  {
    double[] vals = new double[G.V()];
    for (int i = 0; i < G.V(); i++) 
    {
      String str = SG.nameOf(i);
      if(G.outdegree(i) == 0)
      {
        double val = Double.parseDouble(str);
        vals[i] = val;
      }
      else
      {
        switch(str)
        {
          case "+" :
          {
            vals[i] = 0;
            for(int v : G.adj(i))
            {
              vals[i] += vals[v];
            }
            break;
          }
          case "*" :
          {
            vals[i] = 1;
            for(int v : G.adj(i))
            {
              vals[i] *= vals[v]; 
            }
            break;
          }
          case "-" :
          {
            double[] temp = new double[2];
            int counter = 0;
            for(int v : G.adj(i))
            {
              temp[counter] = vals[v];
              counter++;
            }
            vals[i] = temp[0] - temp[1];
            break;
          }
          case "/" :
          {
            double[] temp = new double[2];
            int counter = 0;
            for(int v : G.adj(i))
            {
              temp[counter] = vals[v];
              counter++;
            }
            vals[i] = temp[0] / temp[1];
            break;
          }
        }
      }
    }
    return vals[0];
  }
}