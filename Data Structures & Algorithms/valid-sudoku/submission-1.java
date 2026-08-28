class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer,Set<Integer>> row = new HashMap<>();
        HashMap<Integer,Set<Integer>> col = new HashMap<>();
        HashMap<Integer,HashMap<Integer,Set<Integer>>> sub = new HashMap<>();
        for(int i = 0 ; i < 9 ; i ++) {
                row.put(i, new HashSet<>());
                sub.put((i/3), new HashMap<>());
        }
        for(int j = 0 ; j < 9 ; j++) {
            col.put(j, new HashSet<>());
        }
        for(int i = 0 ; i < 9 ; i ++) {
            for(int j = 0 ; j < 9 ; j++) {
                sub.get(i/3).put((j/3), new HashSet<>());
            }
        }
        for(int i = 0 ; i < 9 ; i ++) {
            for(int j = 0 ; j < 9 ; j++) {
                if(board[i][j] == '.') continue;
                int val = board[i][j] - '0';
                if(row.get(i).contains(val)) return false;
                row.get(i).add(val);
                if(col.get(j).contains(val)) return false;
                col.get(j).add(val);
                if(sub.get(i/3).get(j/3).contains(val)) return false;
                sub.get(i/3).get(j/3).add(val);
            }
        }
        return true;
    }
}
