public class Topological
{
  private Iterable<Integer> order;
  public Topological(Digraph G)
  {
    // topological order
    DirectedCycle cyclefinder = new DirectedCycle(G);
    if (!cyclefinder.hasCycle())
    {
      DepthFirstOrder dfs = new DepthFirstOrder(G);
      order = dfs.reversePost();
    }
   }
   public Iterable<Integer> order()
   {  
     return order;  
   }
   
   public boolean isDAG()
   {  
     return order == null;  
   }
   
   public static void main(String[] args)
   {
     String filename = args[0];
     String separator = args[1];
     In I = new In();
     SymbolDigraph sg = new SymbolDigraph(filename, separator);
     Topological top = new Topological(sg.G());
     int[] perm = I.readAllInts();
     boolean topolog = true;
     int i = 0;
     for (int v : top.order())
     {
       if(perm[i] != v)
       {
         StdOut.println("Ekki topological");
         topolog = false;
         break;
       }
       i++;
     }
     if(topolog) StdOut.println("Topological");
   } 
}