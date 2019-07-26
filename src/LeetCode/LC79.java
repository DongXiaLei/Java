package LeetCode;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/7/26 15:59
 */
public class LC79 {
    public static boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        char[] words = word.toCharArray();
        if(words.length==0)return true;
        int i ,j;
        boolean flag = false;
        for(i=0;i<row;i++){
            for(j=0;j<col;j++){
                if(board[i][j] == words[0]){
                    int [][]boardFlag = new int[row][col]; // 是否走过
                    flag =  flag || isMatch(board,i,j,words,0,boardFlag);
                }
            }
        }
        return flag;
    }
    private static boolean isMatch(char[][] board,int i,int j,char[] words,int index, int [][] boardFlag){
        int row = board.length;
        int col = board[0].length;
        if(index == words.length)return true;
        if(i>=0 && i<row &&j>=0 && j<col && board[i][j]==words[index] && boardFlag[i][j]!=1){
              boardFlag[i][j] = 1;
              boolean flag = isMatch(board,i-1,j,words,index+1,boardFlag) ||
                      isMatch(board,i+1,j,words,index+1,boardFlag)||
                      isMatch(board,i,j-1,words,index+1,boardFlag)||
                      isMatch(board,i,j+1,words,index+1,boardFlag);
              if(flag == false){
                  boardFlag[i][j] = 0;
              }
            return flag;
        }else {
            return false;
        }

    }
    public static void main(String[] args){
        char[][] chars = {{'A','B','C','E'},
                          {'S','F','E','S'},
                          {'A','D','E','E'}};
        String word = "ABCESEEEFS";
        System.out.println(exist(chars,word));

    }
}
