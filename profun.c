#include <stdlib.h>
#include <stdio.h>

int main()
{
   int x = 0;
   int* ip = &x;
   *ip += 1;
   printf("%u\n", ip);
   float* fp = (float*) ip;
   printf("%u\n", fp);
   *fp = 1.0;
   printf("%d\n",x);
}
