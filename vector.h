typedef struct vector {
  int *a;
  unsigned int size;
  unsigned int cap;
} vector;

vector* vector_init();
void vector_free(vector* v);
void vector_append(vector* v, int x);
int vector_at(const vector* v, unsigned int i);
unsigned int vector_size(const vector *v);
