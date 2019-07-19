#include <stdio.h>

int main(int argc, char** argv)
{
  //athugum hvort það sé viðfang
  if(argc > 1)
  {
    //leysum inn allar skrárnar og prentum þær út
    for(int i = 1; i < argc; i++)
    {
      char* filename = argv[i];
      // opnar skrá til lesturs
      FILE* file = fopen(filename, "r");
      char line[1024]; // line er char fylki sem við lesum inn í

      // fgets les eina línu í­ einu
      while (fgets(line, sizeof(line), file)) {
        printf("%s", line);
      }
      printf("\n");
      // lokum skránni
      fclose(file);
    }
  }
  else
  {
    char line[1024];
    while(gets(line))
    {
      printf("%s\n", line);
    }
  }
  return 0;
}
