import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class geezer
{
  public static void main(String[] args)
  {
    Kattio sc = new Kattio(System.in, System.out);
    int A = sc.getInt();
    int H = sc.getInt();
    int n = sc.getInt();
    int m = sc.getInt();
    ewdNew ewd = new ewdNew(n + 1);
    for(int i = 0; i < m; i++)
    {
      int e = sc.getInt();
      int b = sc.getInt();
      int a = sc.getInt();
      int h = sc.getInt();
      int w = 0;
      if(h%A == 0)
      {
        w = (h/A - 1)*a;
      }
      else
      {
        w = (h/A)*a;
      }
      DirectedEdge temp1 = new DirectedEdge(e, b, w);
      DirectedEdge temp2 = new DirectedEdge(b, e, w);
      ewd.addEdge(temp1);
      ewd.addEdge(temp2);
    }
    DijkstraNew dsp = new DijkstraNew(ewd, 1);
    if(dsp.distTo(n) < H)
    {
      System.out.println((int)(H - dsp.distTo(n)));
    }
    else
    {
      System.out.println("Oh no");
    }
  }
}