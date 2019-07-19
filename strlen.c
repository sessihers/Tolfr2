#include <stdio.h>

int my_strlen(char s[])
{
  int i = 0;
  int counter = 0;
  while(s[i] != '\0')
  {
    counter++;
    i++;
  }
  return counter;
}

int main(int argc, char* argv[])
{
  printf("%d\n", my_strlen("Sesar"));
  return 0;
}
