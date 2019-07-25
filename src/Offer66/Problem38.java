package Offer66;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem38 {
    public static void main(String[] args){
        System.out.println("Problem 38");
        Scanner scan = new Scanner(System.in);
        String string = scan.nextLine();
        Permutation(string);
        PermutationSet(string);
        PermutationSetM(string,3);
    }
    // Permutation 一个字符串的全排列
    public static void Permutation(String string){
        char [] chars = string.toCharArray();
        if(chars.length== 0)
            return;
        Permutation(chars,0);
    }
    private static void Permutation(char[] chars,int index){
        if(index== chars.length){
            for(char ele :chars){
                System.out.print(ele+" ");
            }
            System.out.println();
        }
        for(int i = index ;i<chars.length;i++){
            char tmp = chars[i];
            chars[i] = chars[index];
            chars[index] = tmp;

            Permutation(chars,index+1);

            tmp = chars[i];
            chars[i] = chars[index];
            chars[index] = tmp;
        }
    }

    // PermutationSet  一个字符串的全组合 abc = a b c ab bc ac abc
    public static void PermutationSet(String string){
        if(string.length()==0 )return;
        List<String> result = new ArrayList<String>();
        for (int i = 1; i <= string.length(); i++) {
            PermutationSet(string, i, result);
        }
    }
    private static void PermutationSet(String string,int m, List<String> result){
        // 如果m==0，则递归结束。输出当前结果
        if (m == 0) {
            for(String ele :result){
                System.out.print(ele);
            }
            System.out.println();
            return;
        }

        if (string.length() != 0) {
            // 选择当前元素
            result.add(string.charAt(0) + "");
            PermutationSet(string.substring(1, string.length()), m - 1, result);
            result.remove(result.size() - 1);
            // 不选当前元素
            PermutationSet(string.substring(1, string.length()), m, result);
        }
    }

    // PermutationSetM  一个字符串 长度为m的全组合
    public static void PermutationSetM(String string , int m){
        if(string.length()==0 || string.length()<m)return;
        List<String> result = new ArrayList<>();
        PermutationSet(string,m,result);
    }
}

