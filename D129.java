public class D129
{
  public static void main(String [] args)
  {
    int Counter = 0;
    int [] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    System.out.println(rank(Counter, a, 2));
  }
  public static int rank(int c, int [] a, int key)
  {
      int lo  = 0;
      int hi = a.length - 1;
      while (lo <= hi)
      {
        int mid = lo + (hi - lo) / 2;
        if(key < a[mid]) 
        {
          hi = mid - 1;
          c++;
        }
        else if(key > a[mid]) 
        {
          lo = mid + 1;
          c++;
        }
        else return ++c;
      }
      return -1;
  }
}