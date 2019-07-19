import java.util.*;

public class stack
{
  public static void main(String [] args)
  {
    Stack<String> stack = new Stack<String>();
    boolean bool = true;
    while(!StdIn.isEmpty() && bool)
    {
      char n = StdIn.readChar();
      String cur = "" + n;
      if(cur.equals("(") || cur.equals("[") || cur.equals("{"))
      {
        stack.push(cur);
      }
      else
      {
        if(cur.equals(")"))
        {
          if(!((stack.pop()).equals("(")))
          {
            bool = false;
          }
        }
        else if(cur.equals("]"))
        {
          if(!((stack.pop()).equals("[")))
          {
            bool = false;
          }
        }
        else if(cur.equals("}"))
        {
          if(!((stack.pop()).equals("{")))
          {
            bool = false;
          }
        }
      }
    }
    System.out.println(bool);
  }
}
