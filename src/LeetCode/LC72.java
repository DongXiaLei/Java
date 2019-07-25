package LeetCode;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/7/23 21:32
 */
public class LC72 {
    /*
    * 动态规划
    * D(i,j) 表示第一个字符串第i位置字符匹配第二个字符串第j位置
    * 考虑最后一个字符相等
    * 相等：D[i][j]=1+min(D[i−1][j],D[i][j−1],D[i−1][j−1]−1)
    * 不相等 ：D[i][j]=1+min(D[i−1][j],D[i][j−1],D[i−1][j−1])
    * */
    public static int minDistance(String word1, String word2) {
        int m =word1.length();
        int n = word2.length();
        int [][] dis = new int[m+1][n+1];
        for(int i = 0;i<n+1;i++){
            dis[0][i] = i;
        }
        for(int i = 0;i<m+1;i++){
            dis[i][0] = i;
        }
        for(int i =1;i<m+1;i++){
            for(int j =1;j<n+1;j++){
                int minV = -1;
                if(word1.charAt(i-1)== word2.charAt(j-1)){
                    minV = dis[i-1][j]>dis[i][j-1] ? dis[i][j-1] : dis[i-1][j];
                    minV = minV > (dis[i-1][j-1]-1) ? (dis[i-1][j-1]-1) : minV ;
                    dis[i][j] = minV +1;
                }else {
                    minV = dis[i-1][j]>dis[i][j-1] ? dis[i][j-1] : dis[i-1][j];
                    minV = minV > dis[i-1][j-1] ? dis[i-1][j-1] : minV ;
                    dis[i][j] = minV +1;
                }
            }
        }
        return dis[m][n];
    }
    public static void main(String[] args){
        String s1 = "intention";
        String s2 = "execution";
        minDistance(s1,s2);
    }
}
