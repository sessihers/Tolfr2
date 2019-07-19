import java.util.Scanner;

public class D4122
{
  public static void main(String[] args) 
  {
    String filename  = args[0];
    String delimiter = args[1];
    Scanner sc = new Scanner(System.in);
    SymbolGraph sg = new SymbolGraph(filename, delimiter);
    Graph graph = sg.graph();
    String Bacon = "Bacon, Kevin";
    int B = sg.index(Bacon);
    String nafn = sc.nextLine();
    if (sg.contains(nafn)) 
    {
      int s = sg.index(nafn);
      BreadthFirstPaths Bac = new BreadthFirstPaths(graph, B);
      System.out.println(Bac.distTo(s)/2);
    }
    else 
    {
      System.out.println("Nafn ekki í skrá");
    }
    String mynd = sc.nextLine();
    int s = sg.index(mynd);
    for(int i : graph.adj(s))
    {
      BreadthFirstPaths Bac = new BreadthFirstPaths(graph, B);
      System.out.println(sg.nameOf(i) + " " + Bac.distTo(i)/2);
    }
    
  }
}