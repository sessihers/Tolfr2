public class daemi5
{
  public boolean find(Node n, String s)
  {
    if((n.item).equals(s)){ return true; }
    while(n.next != null)
    {
      n = n.next;
      if((n.item).equals(s))
      {
        return true;
      }
    }
    return false;
  }

  public void remove(Node n, String s)
  {
    while(n.next != null)
    {
      if(n.next.item.equals(s))
      {
        n.next = null;
        n = n.next.next;
      }
      n = n.next;
    }
  }
  public static void main(String [] args)
  {
    //Gerum ráð fyrir að við höfum skilgreint lista með
    //fyrsta stak sem first
    Node n = first;
    while(n.next.next != null)
    {
      n = n.next;
    }
    n.next = null;
  }
}
