

public class CuckooST<Key, Value> {
  private static final int INIT_CAPACITY = 16;

  private int n;           // number of key-value pairs in the symbol table
  private int m;           // size of the tables
  private Key[][] keys;      // the keys
  private Value[][] vals;    // the values


  // taken from MurmurHash3 http://sites.google.com/site/murmurhash/
  // and http://facebook.github.io/jcommon/util/jacoco/com.facebook.util.digest/MurmurHash.java.html

  private long rotateLeft64(long x, int r) {
    return (x << r) | (x >>> (64 - r));
  }

  private long fmix(long k) {
    k ^= k >>> 33;
    k *= 0xff51afd7ed558ccdL;
    k ^= k >>> 33;
    k *= 0xc4ceb9fe1a85ec53L;
    k ^= k >>> 33;
    return k;
  }

  public long murmurhash(long data, long seed) {
    long c1 = 0x87c37b91114253d5L;
    long c2 = 0x4cf5ad432745937fL;

    long h1 = seed, h2 = seed;

    long k1 = data;
    k1 *= c1;
    k1 = rotateLeft64(k1, 31);
    k1 *= c2;
    h1 ^= k1;

    h1 ^= 8;
    h2 ^= 8;

    h1 += h2;
    h2 += h1;

    return (fmix(h1) + fmix(h2));
  }

  public CuckooST() {
    this(INIT_CAPACITY);
  }

  public CuckooST(int capacity) {
    m = capacity;
    n = 0;
    keys = (Key[][]) new Object[2][];
    keys[0] = (Key[]) new Object[m];
    keys[1] = (Key[]) new Object[m];

    vals = (Value[][]) new Object[2][];
    vals[0] = (Value[]) new Object[m];
    vals[1] = (Value[]) new Object[m];
  }

  public int size() {
    return n;
  }

  public boolean isEmpty() {
    return size() == 0;
  }

  public boolean contains(Key key) {
    if (key == null) throw new IllegalArgumentException("argument to contains() is null");
    return get(key) != null;
  }


  private void resize(int capacity) {
    CuckooST<Key, Value> temp = new CuckooST<Key, Value>(capacity);
    for (int i = 0; i < m; i++) {
      if (keys[0][i] != null) {
        temp.put(keys[0][i], vals[0][i]);
      }
      if (keys[1][i] != null) {
        temp.put(keys[1][i], vals[1][i]);
      }
    }
    keys = temp.keys;
    vals = temp.vals;
    m    = temp.m;
  }

  public void put(Key key, Value val) {
    if (key == null) throw new IllegalArgumentException("first argument to put() is null");

    if (val == null) {
      delete(key);
      return;
    }

    if (n > (0.8*m)) {
      resize(2*m);
    }
    
    boolean iterate = true;
    //Ef true skiptum við út stökum í fyrra fylkinu, annars seinna
    boolean last = true;
    //Ef við rekumst aftur á key og viljum skipta honum út erum við í hringrás 
    //og þurfum að resize-a
    Key[] checked = (Key[]) new Object[m];
    int pos = 0;
    while(iterate)
    {
      long h = murmurhash(key.hashCode(), 42);
      int h1 = ((int)(h & 0x7fffffff)) % m;
      int h2 = ((int)((h >> 32) & 0x7fffffff)) % m;
      if(keys[0][h1] == null)
      { 
        keys[0][h1] = key;
        vals[0][h1] = val;
        n++;
        iterate = false;
      }
      else if(keys[1][h2] == null)
      {
        keys[1][h2] = key;
        vals[1][h2] = val;
        n++;
        iterate = false;
      }
      else
      {
        boolean loop = false;
        if(last)
        {
          Key tempKey = keys[0][h1];
          Value tempVal = vals[0][h1];
          for(int i = 0; i < pos; i++)
          {
            if(tempKey == checked[i])
            {
              resize(2*m);
              i = pos;
              loop = true;
            }
          }
          if(!loop)
          {
            keys[0][h1] = key;
            vals[0][h1] = val;
            checked[pos] = key;
            pos++;
            key = tempKey;
            val = tempVal;
            last = !last;
          }
        }
        else
        {
          Key tempKey = keys[1][h2];
          Value tempVal = vals[1][h2];
          for(int i = 0; i < pos; i++)
          {
            if(tempKey == checked[i])
            {
              resize(2*m);
              i = pos;
              loop = true;
            }
          }
          if(!loop)
          {
            keys[1][h2] = key;
            vals[1][h2] = val;
            checked[pos] = key;
            key = tempKey;
            val = tempVal;
            last = !last;
          }
        }
      }
    }
  }


  public Value get(Key key) {
    if (key == null) throw new IllegalArgumentException("argument to get() is null");
    long h = murmurhash(key.hashCode(), 42);
    int h1 = ((int)(h & 0x7fffffff)) % m;
    int h2 = ((int)((h >> 32) & 0x7fffffff)) % m;
    
    if(keys[0][h1] == key) return vals[0][h1];
    if(keys[1][h2] == key) return vals[1][h2];
    else return null;

    
  }

  public void delete(Key key) {
    if (key == null) throw new IllegalArgumentException("argument to delete() is null");
    long h = murmurhash(key.hashCode(), 42);
    int h1 = ((int)(h & 0x7fffffff)) % m;
    int h2 = ((int)((h >> 32) & 0x7fffffff)) % m;

    if(keys[0][h1] == key)
    {
      keys[0][h1] = null;
      vals[0][h1] = null;
      n--;
      return;
    }
    if(keys[1][h2] == key) 
    {
      keys[1][h2] = null;
      vals[1][h2] = null;
      n--;
      return;
    }
    return;
  }

  public Iterable<Key> keys() {
    Queue<Key> queue = new Queue<Key>();
    for (int i = 0; i < m; i++) {
      if (keys[0][i] != null) queue.enqueue(keys[0][i]);
      if (keys[1][i] != null) queue.enqueue(keys[1][i]);
    }
    return queue;
  }


  public static void main(String[] args) {
    CuckooST<Integer, Integer> st = new CuckooST<Integer, Integer>();
    for (int i = 0; i < 100; i++) {
      st.put(i, i*i);
    }

    // print keys
    for (Integer i : st.keys()) {
      StdOut.println(i + " " + st.get(i));
    }
    for (int i = 0; i < 100; i++) {
      if (!st.contains(i)) {
        System.out.println("Error: Key not found " + i );
      }
      Integer j = st.get(i);
      if (!j.equals(i*i)) {
        System.out.println("Error: Key found = " + i + ", wrong value " + j );
      }

    }
  }
}