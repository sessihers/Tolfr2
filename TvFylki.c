#include <stdlib.h>
#include <stdio.h>


double** array_init(int n, int m)
{
  double **A = (double**)malloc(n * sizeof(double*));
  for(int i = 0; i < n; i++)
  {
    A[i] = (double*)malloc(m * sizeof(double));
    for(int j = 0; j < m; j++)
    {
      A[i][j] = 0;
    }
  }
  return A;
}
void array_free(double **A, int n, int m)
{
  for(int i = 0; i < n; i++)
  {
    free(A[i]);
    A[i] = 0;
  }
  free(A);
  A = 0;
}

int main()
{
   double** A = array_init(10, 10);
   for(int i = 0; i < 10; i++)
   {
     for(int j = 0; j < 10; j++)
     {
       printf("%f ",A[i][j]);
     }
     printf("\n");
   }
   array_free(A, 10, 10);
}
