package Offer66;

public class Problem48 {
    public static void main(String[] args) {
        System.out.println("Problem 48");
        System.out.println();
        maxSubString5Duplication("dongxeiodlei");
    }
    public static int maxSubString5Duplication(String string){
        if(string.length()==0)return -1;
        int curLength = 0;
        int maxLength = 0;
        int [] pos = new int[26] ;
        for(int i=0;i<26;i++){
            pos[i] = -1;
        }
        for(int i=0;i<string.length();i++){
            int preIndex = pos[string.charAt(i) - 'a'];
            if(preIndex< 0 || i - preIndex >curLength){
                curLength++;
            }else {
                if(curLength>maxLength)
                    maxLength = curLength;
                curLength = i - preIndex ;
            }
            pos[string.charAt(i)-'a'] = i ;
        }
        if(curLength>maxLength)
            maxLength = curLength ;
        return maxLength;
    }
}
