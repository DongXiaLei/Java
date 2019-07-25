package Offer66;

public class Problem5 {
    public static void main(String[] args){
        System.out.println("Problem 5 ");
        String str = " We are the  champion ";
        String s = str.replace(" ","%20");
        System.out.println(s); //返回一个新的  String类型的
        System.out.println(str);
        StringBuffer strr = new StringBuffer(" We are the  champion ");
        rePlace1(strr);
        rePlace2(str);
        int[] arr1 = {1,2,3,4,5,6,7};
        int[] arr2 = {1,2,3,3,5,6,76};
        merge2SortArrays(arr1,arr2);
    }
    public static void rePlace1(StringBuffer str){
        int index = str.indexOf(" "); //" "字符串 ' '字符
        while(index!=-1){  // -1 为空
            str.replace(index,index+1,"%20");//StringBuffer 在本来中替换
            index = str.indexOf(" ",index);
        }
        System.out.println(str);
    }
    public static void rePlace2(String str){
        int index  = str.indexOf(" ");
        int count =0;
        while(index != -1){
            count++;
            index = str.indexOf(" ",index+1);
        }
        StringBuffer s = new StringBuffer(str.length()+count*2);
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' '){
                s.append("%20");
            }
            else s.append(str.charAt(i));
        }
        System.out.println(s+" "+s.length());
    }
    public static void merge2SortArrays(int[] arr1,int[] arr2){
        Integer[] ans = new Integer[arr1.length+arr2.length]; //不新建数组也可以 要原数组比较大可以存下两个数组
        if(ans.length==0)
            return;
        int i=arr1.length-1,j=arr2.length-1;
        while(i>=0&&j>=0){
            if(arr1[i]<=arr2[j]) {
                ans[i+j+1] = arr2[j];
                j--;
            }
            else {
                ans[i+j+1] = arr1[i];
                i--;
            }
        }
        if(i<0){
            while(j>=0){
                ans[j] = arr2[j];
                j--;
            }
        }
        else {
            while(i>=0){
                ans[i] = arr1[i];
                i--;
            }
        }
        System.out.println(ans);
    }

}
