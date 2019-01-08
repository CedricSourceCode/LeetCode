class Solution {
    int row, col, len;
    public boolean exist(char[][] board, String word) {
        if (board == null) return false;
        if (board.length == 0) {
            if (word.length() == 0) return true;
            else return false;
        }
        row = board.length;
        col = board[0].length;
        len = word.length();
        if (row * col < len) return false;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (check(board, visited, word, i, j, 0)) return true;
            }
        }
        return false;
    }
    private boolean check(char[][] board, boolean[][] visited, String word, int i, int j, int index) {
        if (i < 0 || j < 0 || i >= row || j >= col || visited[i][j] || board[i][j] != word.charAt(index)) return false;
        else {
            if (index == len - 1) return true;
            visited[i][j] = true;
            if (check(board, visited, word, i+1, j, index+1) || check(board, visited, word, i-1, j, index+1) || check(board, visited, word, i, j+1, index+1) || check(board, visited, word, i, j-1, index+1)) return true;
            visited[i][j] = false;
            return false;
        }
    }
}