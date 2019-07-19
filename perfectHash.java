public class perfectHash
{
  public static void main(String[] args)
  {
    ST<Character, Integer> st = new ST<Character, Integer>();
    st.put('S', 19); st.put('E', 5); st.put('A', 1); st.put('R', 18); 
    st.put('C', 3); st.put('H', 8); st.put('X', 24); st.put('M', 13);
    st.put('P', 16); st.put('L', 12);
    
    
    int m = 10;
    int[] funct = new int[st.size()];
    boolean iterate = true;
    while(iterate)
    {
      for(int i = 1; i < m; i++)
      {
        int j = 0; boolean bol = true;
        for(Character staf: st.keys())
        {
          funct[j] = (i*st.get(staf))%m; 
          for(int t = 0; t < j && bol; t++)
          {
            if(funct[t] == funct[j])  bol = false;
          }
          if(!bol) break;
          j++;
        }
        if(bol)
        {
          System.out.println("m: " + m + " a: " + i);
          iterate = false;
          i = m;
        }
      }
      m++;
    }
  }
}