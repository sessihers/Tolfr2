#include <stdio.h>

void fib(double x,double y)
{
  int fi;
  int f_1 = 1;
  int f_2 = 1;
  if(x < 1 && y > 1)
  {
    printf("%d \n", f_1);
    printf("%d \n", f_2);
  }
  fi = f_1 + f_2;
  while(fi < y)
  {
    if(fi > x)
    {
      printf("%d\n", fi);
    }
    f_1 = f_2;
    f_2 = fi;
    fi = f_1 + f_2;
  }
}

int main()
{
  fib(0, 100);
}
