package LeetCode;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/8/19 16:52
 */
public class LC461 {
    public static void main(String[] args){
        System.out.println(hammingDistance(100,49));
    }
    public static int hammingDistance(int x, int y) {
        //1^0 = 1 ,0^1 =1 ,0^0 = 0 ,1^1 = 0
        return Integer.bitCount(x^y);
    }

}
