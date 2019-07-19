#include <stdio.h>

int my_strlen(char a[])
{
  int i = 0;
  while(a[i] != '\0')
  {
    i++;
  }
  return i;
}

int main()
{
  char s[] = "sixty nine";
  printf("%d\n", my_strlen(s));
}
