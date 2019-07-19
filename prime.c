#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int isPrime(int n)
{
  for(int i = 2; i <= sqrt(n); i++)
  {
    if(n%i == 0)
    {
      return i;
    }
  }
  return n;
}
int main(int argc, char*argv[])
{
  int N = atoi(argv[1]);
  if(isPrime(N) == N)
  {
    printf("%d is a prime number\n", N);
  }
  else
  {
    printf("%d is composite, %d is the smallest prime factor\n", N, isPrime(N));
  }
}
