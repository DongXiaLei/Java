package LeetCode;

public class LC130 {
    public static void main(String[] args){
        char[][] board={{'X','O','X','X'},{'O','X','O','X'},{'X','O','X','O'},{'O','X','O','X'},{'X','O','X','O'},{'O','X','O','X'}};
        solve(board);
    }
    static boolean [][]visited;
    static int row,col;

    public static void solve(char[][] board) {

        row = board.length;

        if (row==0){
            return;
        }
        col = board[0].length;

        visited = new boolean[row][col];


        for (int i =0;i<row;i++){
            if (board[i][0]=='O')  dfs(i,0,board);
            if (board[i][col-1]=='O') dfs(i,col-1,board);
        }

        for (int i=0;i<col;i++){
            if (board[0][i]=='O') dfs(0,i,board);
            if (board[row-1][i]=='O') dfs(row-1,i,board);
        }


        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                if (!visited[i][j]){
                    board[i][j] = 'X';
                }
            }
        }
    }

    public static void dfs(int x,int y,char[][]board){

        visited[x][y] = true;

        int dx[] = {-1,0,1,0}; int dy[] = {0,1,0,-1};

        for (int i=0;i<4;i++){
            int a = x + dx[i];
            int b = y + dy[i];
            if (a>=0&&a<row&&b>=0&&b<col&&!visited[a][b]&&board[a][b]=='O'){
                dfs(a,b,board);
            }
        }
    }
}
/*
* public static void solve(char[][] board) {
        int rows = board.length;
        if (rows==0) return;
        int cols = board[0].length;
        parent = new int[10000+1];

        for (int i=0;i<parent.length;i++){
            parent[i] = i;
        }

        int dx[] = {-1,0,1,0}, dy[]={0,1,0,-1};

        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                if ((i==0 || i==rows-1 || j==0 || j==cols-1) && board[i][j]=='O'){
                    union(i*rows+j,rows*cols);
                }else if (board[i][j]=='O'){
                    for (int k =0;k<4;k++){
                        int x = i + dx[k];
                        int y = j + dy[k];
                        if (board[x][y]=='O'){
                            union(i*rows+j,x*rows+y);
                        }
                    }


                }
            }
        }

        for (int i=0;i<rows;i++){
            for (int j =0;j<cols;j++){
                if (!(find(i*rows+j) == find(rows*cols))) board[i][j] = 'X';
            }
        }
        return;
    }
    public static boolean union(int k1,int k2){
        int m1 = find(k1) ;
        int m2 = find(k2) ;
        if(m1 == m2 )return false;
        else {
            parent[m1] = m2;
            return true;
        }
    }
    public static int find(int k){
        int i =k;
        while (i!=parent[i])
            i = parent[i];
        return i;
    }
    static int[] parent ;
* */

