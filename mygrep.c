#include <stdio.h>

int main(int argc, char**argv)
{
  char* pattern = argv[1];
  int l = 0, c = 0;
  while(pattern[l] != '\0')
  {
    l++;
  }
  char line[1024];
  FILE* file = fopen("Holmes.txt", "r");
  int fj = 0;
  while (fgets(line, sizeof(line), file))
  {
    c = 0;
    while(line[c] != '\0')
    {
      for(int i = 0; i < l; i++)
      {
        if(line[c + i] != pattern[i])
        {
          i = l;
        }
        else if(i == l - 1)
        {
          printf("%s", line);
          fj++;
        }
      }
      c++;
    }
  }
  printf("\nFjöldi lína sem innihald Holmes eru %d\n", fj);
}
