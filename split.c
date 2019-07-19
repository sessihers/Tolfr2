#include <stdio.h>
#include <stdlib.h>

char** split(const char* s, int *n)
{
  int i = 0, t = 0, c = 0, l = 0;
  while(s[i] != '\0')
  {
    if(s[i] == ' ' || s[i] == '\t')
    {
      l++;
    }
    i++;
  }
  *n = l+1;
  char **a = (char**) malloc(l+1);
  i = 0;
  while(s[i] != '\0')
  {
    if(s[i] == ' ' || s[i] == '\t')
    {
      char* b = (char*) malloc(i-t+1);
      for(int j = 0; j < (i-t); j++)
      {
        b[j] = s[t + j];
      }
      b[i-t] = '\0';
      a[c] = b;
      c++;
      t = i + 1;
    }
    i++;
  }
  char* b = (char*) malloc(i-t+1);
  for(int j = 0; j < (i-t); j++)
  {
    b[j] = s[t + j];
  }
  b[i-t] = '\0';
  a[c] = b;
  return a;
}

int main()
{
  char *s = "Sesar Hersisson og Breki Pálsson";
  int n;
  char** split_s = split(s, &n);
  for(int i = 0; i < n; i++)
  {
    printf("%s ", split_s[i]);
  }
  printf("\n");
  for(int i = 0; i < n; i++)
  {
    free(split_s[i]);
    split_s[i] = 0;
  }
  free(split_s);
  split_s = 0;

}
