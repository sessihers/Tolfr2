public class FC
  {
     public static void main(String[] args)
     {
        Stopwatch s = new Stopwatch();
        int minlen = Integer.parseInt(args[0]);
        RedBlackBST<String, Integer> RB = new RedBlackBST<String, Integer>();
        while (!StdIn.isEmpty())
        {  // Build symbol table and count frequencies.
           String word = StdIn.readString();
           if (word.length() < minlen) continue;  // Ignore short keys.
           if (!RB.contains(word)) RB.put(word, 1);
           else                    RB.put(word, RB.get(word) + 1);
}
        // Find a key with the highest frequency count.
        String max = "";
        RB.put(max, 0);
        for (String word : RB.keys())
           if (RB.get(word) > RB.get(max))
              max = word;
        System.out.println(max + " " + RB.get(max));
        double elap = s.elapsedTime();
        System.out.println(elap);
     }
}
