public class CubeSum implements Comparable<CubeSum>
{
  public int i;
  public int j;
  public int sum;
  
  
  public CubeSum(int ii, int jj)
  {
    i = ii;
    j = jj;
    sum = i*i*i + j*j*j;
  }
  
  public int compareTo(CubeSum cube)
  {
    if(this.sum > cube.sum) return 1;
    if(this.sum < cube.sum) return -1;
    else return 0;
  }
  
  public String toString()
  {
    return i + "^3 + " + j + "^3";
  }
  
  public static void main(String[] args)
  {
    int N = Integer.parseInt(args[0]);
    MinPQ<CubeSum> pq = new MinPQ<CubeSum>(N);
    for(int i = 0; i < N + 1; i++)
    {
      CubeSum temp = new CubeSum(i, i);
      pq.insert(temp);
    }
    CubeSum prev = pq.delMin();
    if(prev.j < N) { pq.insert(new CubeSum(prev.i, prev.j + 1)); }
    while(!pq.isEmpty())
    {
      CubeSum temp = pq.delMin();
      if(temp.j < N) { pq.insert(new CubeSum(temp.i, temp.j + 1)); }
      if(temp.sum == prev.sum) { System.out.println(temp + " = " + prev); }
      prev = temp;
    }
  }
}