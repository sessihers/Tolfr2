import java.util.*;

public class DN
{
  private DoubleNode first = null;
  private DoubleNode last = null;

  private class DoubleNode
  {
    String item;
    DoubleNode next;
    DoubleNode befo;
  }
    
  public void pushFront(String item)
  {
    DoubleNode oldfirst = first;
    first = new DoubleNode();
    first.item = item;
    first.next = oldfirst;
    first.befo = null;
    oldfirst.befo = first;
  }
  
  public void pushBack(String item)
  {
    DoubleNode oldlast = last;
    last = new DoubleNode();
    last.item = item;
    last.next = null;
    last.befo = oldlast;
    oldlast.next = last;
  }
  
  public void removeFirst()
  {
    first = first.next;
    first.befo = null;
  }
  
  public void removeLast()
  {
    last = last.befo;
    last.next = null;
  }
  
  public void insertBefo(DoubleNode n)
  {
    DoubleNode in = new DoubleNode();
    DoubleNode prev = new DoubleNode();
    prev.next = in;
    in.next = n;
    n.befo = in;
    in.befo = prev;
  }
  
  public void insertAfter(DoubleNode n)
  {
    DoubleNode in = new DoubleNode();
    DoubleNode next = n.next;
    next.befo = in;
    in.befo = n;
    n.next = in;
    in.next = next;
  }
    
  public void remove(DoubleNode n)
  {
        if (first == null)
        {
            return;
        }
        DoubleNode temp = first; 
        if (n == first) 
        { 
            first = temp.next; 
            return; 
        } 
        DoubleNode prev = n.befo;
        DoubleNode next = prev.next.next; 
        prev.next = next; 
        next.befo = prev;
  }
  public static void main(String [] args)
  {
  }
}
