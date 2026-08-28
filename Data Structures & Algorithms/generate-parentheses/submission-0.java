class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        generateParenthesis(n, 0, 0, result, sb);
        return result;
    }

    private void generateParenthesis(int n, int open, int close, List<String> result, StringBuilder sb) {
        // Base case: we've used all n pairs
        if (open == n && close == n) {
            result.add(sb.toString());
            return;
        }
        
        // Add opening parenthesis if we haven't used all n
        if (open < n) {
            sb.append('(');
            generateParenthesis(n, open + 1, close, result, sb);
            sb.deleteCharAt(sb.length() - 1); // backtrack
        }
        
        // Add closing parenthesis if it won't make string invalid
        if (close < open) {
            sb.append(')');
            generateParenthesis(n, open, close + 1, result, sb);
            sb.deleteCharAt(sb.length() - 1); // backtrack
        }
    }
}