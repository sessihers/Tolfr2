import java.util.Arrays;

public class pair
{
  public static void main(String [] args)
  {
    In in = new In();
    int [] a = in.readAllInts();
    Arrays.sort(a);
    for(int i = 0; i < a.length; i++)
    {
      System.out.println(a[i] + " ");
    }
    int count = 0;
    for(int i = 0; i < a.length - 1; i++)
    {
      int j = i + 1;
      int curr = 1;
      while(j < a.length && a[i] == a[j])
      {
        j++;
        curr++;
      }
      i += curr - 1;
      count += (curr*(curr - 1))/2;
    }
    System.out.println(count); 
  }
}