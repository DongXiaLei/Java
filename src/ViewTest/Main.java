package ViewTest;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<Integer, Set<Integer>> amp = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(1);
        set.add(1);
        amp.put(1,set);
        amp.get(1).add(2);
        System.out.println("test!");

    }

}

/**

 */

/*
*
*
* */

/*
*
*
*
*
*
* */