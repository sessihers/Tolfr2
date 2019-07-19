import java.util.Arrays;

public class TopFreq implements Comparable<TopFreq>
{
  public String word;
  public int count;
  
  public TopFreq(String w, int c)
  {
    word = w;
    count = c;
  }
  
  public int compareTo(TopFreq temp)
  {
    if(this.count > temp.count) return 1;
    if(this.count < temp.count) return -1;
    else return 0;
  }
  
  public static void main(String [] args)
  {
    int k = Integer.parseInt(args[0]);
    int N = Integer.parseInt(args[1]);
    Stopwatch s = new Stopwatch();
    In in = new In();
    String[] a = in.readAllStrings();
    MaxPQ<TopFreq> pq = new MaxPQ<TopFreq>();
    Arrays.sort(a);
    int counter = 1;
    for(int i = 1; i < a.length; i++)
    {
      if(a[i].equals(a[i-1])) counter++; 
      else
      {
        if(a[i-1].length() < 6) {}
        else
        {
          TopFreq temp = new TopFreq(a[i-1], counter);
          pq.insert(temp);
        }
        counter = 1;
      }
    }
    for(int i = 0; i < N; i++)
    {
      TopFreq temp = pq.delMax();
      System.out.println(temp.word + " " + temp.count);
    }
    double elap = s.elapsedTime();
    System.out.println(elap + "sek");
  }
}