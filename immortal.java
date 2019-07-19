public class immortal
{
  
  public static void modarr(long[][] a)
  {
    long mod = 1000000000;
    a[0][0] %= mod;
    a[0][1] %= mod;
    a[1][0] %= mod;
    a[1][1] %= mod;
  }
  
  public static void eq(long[][] a, long[][] b)
  {
    a[0][0] = b[0][0];
    a[0][1] = b[0][1];
    a[1][0] = b[1][0];
    a[1][1] = b[1][1];
  }
  
  public static void margf(long[][] a)
  {
    long mod = 1000000000;
    long[][] b = new long[2][2];
    modarr(a);
    b[0][0] = ((a[0][0]*a[0][0])%mod + (a[0][1]*a[1][0])%mod)%mod;
    b[0][1] = ((a[0][0]*a[0][1])%mod + (a[0][1]*a[1][1])%mod)%mod;
    b[1][0] = ((a[1][0]*a[0][0])%mod + (a[1][1]*a[1][0])%mod)%mod;
    b[1][1] = ((a[1][0]*a[0][1])%mod + (a[1][1]*a[1][1])%mod)%mod;
    eq(a, b);
  }
  
  public static long arrpow(long[][] a, long pow, long n)
  {
    long mod = 1000000000;
    ll res = 1;
    while(pow > 0)
    {
      if(pow % 2 == 1)
      {
        res = (res*b) % mod;
      }
      b = (b * b) % mod;
      pow = pow / 2;
  }
  return res;
  }
  
  public static void main(String[] args)
  {
    long[][] a = new long[2][2];
    a[0][0] = 1;
    a[0][1] = 1;
    a[1][0] = 1;
    a[1][1] = 0;
    System.out.println(arrpow(a, 1, 10));
  }
}