#include <stdio.h>
#include <stdlib.h>


typedef struct matrix {
  double* a;
  int n;
  int m;
} matrix;

matrix margfFylki(matrix A, matrix B)
{
  double * AB = (double*) malloc(sizeof(double)*(A.n)*(B.m));
  //counter
  int c = 0;
  double stak = 0;
  for(int i = 0; i < A.n; i++)
  {
    for(int j = 0; j < B.m; j++)
    {
      for(int t = 0; t < B.n; t++)
      {
        stak += A.a[i*A.m + t] * B.a[t*B.m + j];
      }
      AB[c] = stak;
      stak = 0;
      c++;
    }
  }
  matrix C;
  C.a = AB;
  C.n = A.n;
  C.m = B.m;
  return C;
}

int main()
{
  int n, m;
  scanf("%d %d", &n, &m);
  double* fylkiA = (double*) malloc(sizeof(double)*n*m);
  for(int i = 0; i < n*m; i++)
  {
    double x;
    scanf(" %lf",&x);
    fylkiA[i] = x;
  }
  matrix A;
  A.a = fylkiA;
  A.n = n;
  A.m = m;
  scanf("%d %d", &n, &m);
  double* fylkiB = (double*) malloc(sizeof(double)*n*m);
  for(int i = 0; i < n*m; i++)
  {
    double x;
    scanf(" %lf",&x);
    fylkiB[i] = x;
  }
  matrix B;
  B.a = fylkiB;
  B.n = n;
  B.m = m;
  matrix C;
  C.a = margfFylki(A, B).a;
  C.n = margfFylki(A, B).n;
  C.m = margfFylki(A, B).m;
  //counter
  int c = 0;
  for(int i = 0; i < C.n; i++)
  {
    for(int j = 0; j < C.m; j++)
    {
      printf("%.1lf ",C.a[c]);
      c++;
    }
    printf("\n");
    free(A.a);
    free(B.a);
    free(C.a);
  }
}
