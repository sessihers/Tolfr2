public class BinaryLowestIndex
{
  public static int rank(int [] a, int key)
  {
    int lo  = 0;
    int hi = a.length - 1;
    int mid = 0;
    while (lo <= hi)
    {
      mid = lo + (hi - lo) / 2;
      if(mid == 0 || a[mid] > a[mid - 1])
      {
        return mid;
      }
      else if(key <= a[mid]) 
      {
        hi = mid - 1;
      }
      else if(key > a[mid]) 
      {
        lo = mid + 1;
      }
    }
    if(a[mid] == key)
    {
      return mid;
    }
    else
    {
      return -1;
    }
  }
  public static void main(String [] args)
  {
    int [] a = {1,1,1,1,1,1,1,1,1,1,1,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4};
    System.out.println(rank(a, 2));
  }
}