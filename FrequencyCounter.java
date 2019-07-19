
  public class FrequencyCounter
  {
     public static void main(String[] args)
     {
        int N = Integer.parseInt(args[0]);
        int[] a = new int[N];
        int heild = 0;
        for(int j = 0; j < 100; j++)
        {
          for(int i = 0; i < N; i++)
          {
            a[i] = (int)(Math.random()*1000) + 1;
          } 
          ST<Integer, Integer> st = new ST<Integer, Integer>();
          for(int i = 0; i < N; i++)
          {
            int curr = a[i];
            if (!st.contains(curr)) st.put(curr, 1);
            else                    st.put(curr, st.get(curr) + 1);
          }
          heild += st.size();
        }
        double medaltal = (double)(heild)/100.0;
        StdOut.println("Medaltal einstakra gilda: " + medaltal);
     }
}