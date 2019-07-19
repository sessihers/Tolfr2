import java.util.*;

public class LinkedList
{
  private Node first = null;

  private class Node
  {
    String item;
    Node next; 
  }
  
  public boolean isEmpty()
  { 
    return first == null;
  }
  
  public void push(String item)
  {
    Node oldfirst = first;
    first = new Node();
    first.item = item;
    first.next = oldfirst;
  }
  
  public String pop()
  {
    String item = first.item;
    first = first.next;
    return item;
  }
    
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
