public class ErdosRenyi
{
  public static int count(int N)
  {
    WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);
    int counter = 0;
    while(uf.count() > 1)
    {
      counter++;
      int p = (int)(Math.random()*N);
      int q = (int)(Math.random()*N);
      if(!uf.connected(p,q))
      {
        uf.union(p,q);
      }
    }
    return counter;
  }
  
  public static void main(String[] args)
  {
    int N = Integer.parseInt(args[0]);
    int sum = 0;
    for(int i = 0; i < 1000; i++)
    {
      sum += count(N);
    }
    double counter = (double)(sum)/1000.0;
    double hype = 0.5*N*Math.log(N); 
    System.out.println("Average number of pairs generated: " + counter + " and 1/2NlnN = " + hype + ".");
  }
}