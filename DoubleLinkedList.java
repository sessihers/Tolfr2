/*public class DoubleLinkedList<Item> {
  private DoubleNode head = null;
  private DoubleNode tail = null;
  
  private class DoubleNode {
    int item;
    DoubleNode prev,next;

    public static DoubleNode insertFront(DoubleNode head, DoubleNode node) 
    {
       head.prev = node;
       node.next = head;
       node.prev = null;
       return node;
    }
    public static DoubleNode insertBack(DoubleNode tail, DoubleNode node)
    {
      tail.next = node;
      node.prev = tail;
      node.next = null;
      return node;
    }
    public static DoubleNode removeFront(DoubleNode head)
    {
      return head.next; 
    }
    public static DoubleNode removeBack(DoubleNode tail)
    {
      return tail.prev;
    }
  }

  public void insertFront(int item) 
  {
    DoubleNode node = new DoubleNode();
    node.item = item;
    head = insertFront(head, node);
  }
  
  public void insertBack(int item)
  {
    DoubleNode node = new DoubleNode();
    node.item = item;
    tail = insertBack(tail, node);
  }
  
  public void removeFront()
  {
    DoubleNode node = new DoubleNode();
    node = head.next;
    head = removeFront(head);
  }
  public void removeBack()
  {
    tail = removeBack(tail);
  }
}*/