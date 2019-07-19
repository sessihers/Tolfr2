public class sumThree
{
  public static void main(String [] args)
  {
    for(int N = 100; N <= 6400; N*=2)
    {
      int [] a = new int[N];
      for(int s = 0; s < N; s++)
      {
        a[s] = (int)(Math.random()*100) - 50;
      }
      int cnt = 0;
      long start = System.currentTimeMillis();
      for (int i = 0; i < N; i++) 
      {
        for (int j = 0; j < N; j++)
        {
          for (int k = 0; k < N; k++) 
          {
            if (i < j && j < k)
            {
              {
                if (a[i] + a[j] + a[k] == 0) 
                {
                  cnt++;
                }
              }
            }
          }
        }
      }
      long timi = System.currentTimeMillis() - start;
      System.out.println(N + ": " + timi);
    }
  }
}