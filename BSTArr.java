import java.util.NoSuchElementException;

public class BSTArr<Key extends Comparable<Key>, key> {
    private int[] key; 
    private int[] value;
    private int[] left;
    private int[] right;
    private int MaxSize;
    private int size;
    
    public BSTArr(int max)
    {
      MaxSize = max;
      key = new int[max];
      value = new int[max];
      left = new int[max];
      right = new int[max];
      size = 0;
    }
    
    public int get(int Key) {
        return get(0, Key);
    }

    private int get(int x, int Key) {
        if(Key < key[x])
        {
          if(left[x] == 0)
          {
            return 0;
          }
          else return get(left[x], Key);
        }
        else if(Key > key[x]) 
        {
          if(right[x] == 0)
          {
            return 0;
          }
          else return get(right[x], Key);
        }
        else return value[x];
    }

    public void put(int key, int val) 
    {
      if(size >= MaxSize) return;
      else put(0, key, val);
    }

    private int put(int x, int Key, int val) {
        if(Key < key[x])
        {
          if(left[x] == 0)
          {
            left[x]  = size;
            key[size] = Key;
            value[size] = val;
            size++;
          }
          else left[x]  = put(left[x],  Key, val);
        }
        else if(Key > key[x]) 
        {
          if(right[x] == 0)
          {
            right[x]  = size;
            key[size] = Key;
            value[size] = val;
            size++;
          }
          else right[x] = put(right[x], Key, val);
        }
        else key[x] = Key;
        return x;
    }
    
    public static void main(String[] args)
    {
      int N = Integer.parseInt(args[0]);
      BSTArr bst = new BSTArr(N);
      Stopwatch s1 = new Stopwatch();
      for(int i = 0; i < N; i++)
      {
        int x = (int)(Math.random()*N + 1);
        bst.put(x, i);
      }
      double elap = s1.elapsedTime();
      System.out.println("Innsetning a " + N + "stokum tekur " + elap + "sek");
      Stopwatch s2 = new Stopwatch();
      for(int i = 0; i < N; i++)
      {
        int x = (int)(Math.random()*N + 1);
        bst.get(x);
      }
      elap = s2.elapsedTime();
      System.out.println("Ad finna " + N + "stok tekur " + elap + "sek");
    }
}