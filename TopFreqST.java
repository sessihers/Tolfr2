public class TopFreqST implements Comparable<TopFreqST>
{
  public String word;
  public int count;
  
  public TopFreqST(String w, int c)
  {
    word = w;
    count = c;
  }
  
  public int compareTo(TopFreqST temp)
  {
    if(this.count > temp.count) return 1;
    if(this.count < temp.count) return -1;
    else return 0;
  }
  public static void main(String[] args)
  {
    int k = Integer.parseInt(args[0]);
    int N = Integer.parseInt(args[1]);
    Stopwatch s = new Stopwatch();
    In in = new In();
    ST<String, Integer> st = new ST<String, Integer>();
    MaxPQ<TopFreqST> pq = new MaxPQ<TopFreqST>();
    while(!in.isEmpty())
    {
      String temp = in.readString();
      if(temp.length() < 6) {}
      else if(st.contains(temp))
      {
        int count = st.get(temp);
        count++;
        st.put(temp, count);
      }
      else
      {
        st.put(temp, 1);
      }
    }
    for(String curr : st.keys())
    {
      TopFreqST temp = new TopFreqST(curr, st.get(curr));
      pq.insert(temp);
    }
    for(int i = 0; i < N; i++)
    {
      TopFreqST temp = pq.delMax();
      System.out.println(temp.word + " " + temp.count);
    }
    double elap = s.elapsedTime();
    System.out.println(elap);
  }
}