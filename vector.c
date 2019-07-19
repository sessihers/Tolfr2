#include <stdlib.h>
#include <stdio.h>
#include "vector.h"

vector* vector_init() {
  vector *v = (vector*) malloc(sizeof(vector));
  v->a = 0;
  v->size = 0;
  v->cap = 0;
  return v;
}

void vector_free(vector* v) {
  if (v->cap > 0) {
    free(v->a);
    v->a = 0;
    v->size = 0;
    v->cap = 0;
  }
}

int vector_at(const vector* v, unsigned int i) {
  return v->a[i];
}

unsigned int vector_size(const vector *v) {
  return v->size;
}

void vector_append(vector* v, int x) {
  if (v->size == v->cap) {
    unsigned int newcap = 2*v->cap;
    if (newcap==0) {
      newcap = 4;
    }
    int *tmp = (int*) malloc(newcap*sizeof(int));
    for (unsigned int i = 0; i < v->size; i++) {
      tmp[i] = v->a[i];
    }
    free(v->a);
    v->a = tmp;
    v->cap = newcap;
  }
  v->a[v->size] = x;
  v->size++;
}

void vector_set(vector* v, unsigned int i, int x) {
  if(i > 0 && i < (v->size)){
    v->a[i] = x;
  }
}

int vector_remove(vector* v, unsigned int i) {
  int show = v->a[i];
  v->size--;
  for(int j = i; j < v->size; j++) {
    v->a[j] = v->a[j+1];
  }
  return show;
}

vector* vector_copy(vector* v) {
  vector *v2 = vector_init();
  for(int i = 0; i < v->size; i++)
  {
    vector_append(v2, v->a[i]);
  }
  return v2;
}

int vector_find(vector* v, int x) {
  for(int i = 0; i < v->size; i++) {
    if(v->a[i] == x) {
      return i;
    }
  }
  return -1;
}

int main()
{
  vector *v = vector_init();
  for(int i = 0; i < 10; i++)
  {
    vector_append(v, i);
  }
  vector_set(v, 3, 8);
  printf("%d\n",v->a[3]);
  vector *v2 = vector_copy(v);
  printf("%d\n", v2->a[3]);
  printf("%d %d\n", vector_find(v, 8), vector_find(v, 101));
}
