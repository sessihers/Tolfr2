import java.util.*;
public class Parentheses{
  public static void main(String[] args){
    
    Stack<String> stack = new Stack<String>();
    boolean iLagi = true;
    int opnir = 0;
    int lokadir = 0;
    
    while(!StdIn.isEmpty()|| iLagi==true){
     String s = StdIn.readString();
     System.out.println(s);
     System.out.println(iLagi);
     
     if(s.equals("(") || s.equals("{") || s.equals("[")){
       System.out.println("hallo");
      stack.push(s);
      opnir++;
     }
     else if(s.equals(")")){
       lokadir++;
       String e = stack.peek();
       if(e.equals("{") || e.equals("[")) {iLagi= false;}
       else
         stack.pop();
     }
     else if(s.equals("}")){
       lokadir++;
       String e = stack.peek();
       if(e.equals("(") || e.equals("[")) {iLagi= false;}
       else
         stack.pop();
     }
     else if(s.equals("]")){
       lokadir++;
       String e = stack.peek();
       if(e.equals("{") || e.equals("(")) {iLagi= false;}
       else
         stack.pop();
     } 
    }
    
    if(opnir != lokadir) iLagi = false;
    System.out.println(iLagi);
 }
}