package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/7/20 10:56
 */
public class LC17 {
    public static List<String> letterCombinations(String digits) {
        if(digits.length()<=0)return new LinkedList<>();
        char[] chars = digits.toCharArray();
        Queue<String> queue = new LinkedList<>();
        for(char ch:chars){
            switch (ch){
                case '1':break;
                case '2':{
                    String string = queue!=null ? queue.poll():null;
                    if(string==null){
                        queue.offer("a");
                        queue.offer("b");
                        queue.offer("c");
                    }else {
                        while (string!="###"){
                            queue.offer(string+'a');
                            queue.offer(string+'b');
                            queue.offer(string+'c');
                            string = queue.poll();
                        }
                    }

                    queue.offer("###");
                    break;
                }
                case '3':{
                    String string = queue!=null ? queue.poll():null;
                    if(string==null){
                        queue.offer("d");
                        queue.offer("e");
                        queue.offer("f");
                    }else {
                        while (string!="###"){
                            queue.offer(string+'d');
                            queue.offer(string+'e');
                            queue.offer(string+'f');
                            string = queue.poll();
                        }
                    }
                    queue.offer("###");
                    break;
                }
                case'4':{
                    String string = queue!=null ? queue.poll():null;
                    if(string==null){
                        queue.offer("g");
                        queue.offer("h");
                        queue.offer("i");
                    }else {
                        while (string!="###"){
                            queue.offer(string+'g');
                            queue.offer(string+'h');
                            queue.offer(string+'i');
                            string = queue.poll();
                        }
                    }
                    queue.offer("###");
                    break;
                }
                case '5':{
                    String string = queue!=null ? queue.poll():null;
                    if(string==null){
                        queue.offer("j");
                        queue.offer("k");
                        queue.offer("l");
                    }else {
                        while (string!="###"){
                            queue.offer(string+'j');
                            queue.offer(string+'k');
                            queue.offer(string+'l');
                            string = queue.poll();
                        }
                    }
                    queue.offer("###");
                    break;
                }
                case '6':{
                    String string = queue!=null ? queue.poll():null;
                    if(string==null){
                        queue.offer("m");
                        queue.offer("n");
                        queue.offer("o");
                    }else {
                        while (string!="###"){
                            queue.offer(string+'m');
                            queue.offer(string+'n');
                            queue.offer(string+'o');
                            string = queue.poll();
                        }
                    }
                    queue.offer("###");
                    break;
                }
                case '7':{
                    String string = queue!=null ? queue.poll():null;
                    if(string==null){
                        queue.offer("p");
                        queue.offer("q");
                        queue.offer("r");
                        queue.offer("s");
                    }else {
                        while (string!="###"){
                            queue.offer(string+'p');
                            queue.offer(string+'q');
                            queue.offer(string+'r');
                            queue.offer(string+'s');
                            string = queue.poll();
                        }
                    }
                    queue.offer("###");
                    break;
                }
                case '8':{
                    String string = queue!=null ? queue.poll():null;
                    if(string==null){
                        queue.offer("t");
                        queue.offer("u");
                        queue.offer("v");
                    }else {
                        while (string!="###"){
                            queue.offer(string+'t');
                            queue.offer(string+'u');
                            queue.offer(string+'v');
                            string = queue.poll();
                        }
                    }
                    queue.offer("###");
                    break;
                }
                case '9':{
                    String string = queue!=null ? queue.poll():null;
                    if(string==null){
                        queue.offer("w");
                        queue.offer("x");
                        queue.offer("y");
                        queue.offer("z");
                    }else {
                        while (string!="###"){
                            queue.offer(string+'w');
                            queue.offer(string+'x');
                            queue.offer(string+'y');
                            queue.offer(string+'z');
                            string = queue.poll();
                        }
                    }
                    queue.offer("###");
                    break;
                }


            }
        }
        List<String > ans = new ArrayList<>(queue);
        ans.remove(ans.size()-1);
        return ans;
     }
    public static void main(String [] args){
        String s = "233";
        letterCombinations(s);
    }
}
