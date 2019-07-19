#include <stdio.h>

struct fylki{
  float med;
  float staerst;
  float minnst;
};

struct fylki my_stats(float a[], int l)
{
  struct fylki k;
  float max = a[0];
  float min = a[0];
  float sum = 0;
  for(int i = 0; i < l; i++)
  {
    sum += a[i];
    if(a[i] > max)
    {
      max = a[i];
    }
    if(a[i] < min)
    {
      min = a[i];
    }
  }
  k.med = sum/l;
  k.staerst = max;
  k.minnst = min;
  return k;

}
int main()
{
  float a[] = {1.2, 2, 3.4, 6, 7, 8.7};
  float b[] = {4.5, 6.8, 4, 2, 8.8, 9.4, 5.4};
  printf("Meðalatal fyrra fylkisins er %f. Stærsta gildið er %f og minnsta gildið er %f.\n",my_stats(a, 6).med, my_stats(a, 6).staerst, my_stats(a, 6).minnst);
  printf("Meðalatal seinna fylkisins er %f. Stærsta gildið er %f og minnsta gildið er %f.\n",my_stats(b, 7).med, my_stats(b, 7).staerst, my_stats(b, 7).minnst);

}
