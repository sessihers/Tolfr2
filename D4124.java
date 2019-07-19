import java.util.Scanner;

public class D4124
{
  public static void main(String[] args) 
  {
    String filename  = args[0];
    String delimiter = args[1];
    Scanner sc = new Scanner(System.in);
    SymbolGraph sg = new SymbolGraph(filename, delimiter);
    Graph graph = sg.graph();
    CC cc = new CC(graph);
    int m = cc.count();
    System.out.println("Number of connected components: " + m);
    Queue<Integer>[] components = (Queue<Integer>[]) new Queue[m];
    for (int i = 0; i < m; i++) 
    {
      components[i] = new Queue<Integer>();
    }
    for (int v = 0; v < graph.V(); v++) 
    {
      components[cc.id(v)].enqueue(v);
    }
    int count = 0;
    int max = 0;
    int maxIndex = 0;
    for (int i = 0; i < m; i++) 
    {
      if(components[i].size() < 10) count++;
      if(components[i].size() > max)
      { 
        max = components[i].size();
        maxIndex = i;
      }
    }
    System.out.println("Size of biggest component: " + max);
    System.out.println("Number of components with size less than 10: " + count);
  }
}