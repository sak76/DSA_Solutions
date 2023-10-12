class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        generateParenthesisPairs(0,0,0,ans,sb, n);
        return ans;
    }

    private void generateParenthesisPairs(int openingBraces, int closingBraces, int index, List<String> ans, StringBuilder sb, int n) {
        if(index == 2*n) {
            ans.add(sb.toString());
            return;
        }

        if(openingBraces == closingBraces) {
            sb.append('(');
            generateParenthesisPairs(openingBraces+1,closingBraces,index+1,ans,sb,n);
            sb.setLength(sb.length() - 1);
        }
        else if(openingBraces > closingBraces) {
            if(openingBraces < n) {
                sb.append('(');
                generateParenthesisPairs(openingBraces+1,closingBraces,index+1,ans,sb,n);
                sb.setLength(sb.length() - 1);

                sb.append(')');
                generateParenthesisPairs(openingBraces,closingBraces+1,index+1,ans,sb,n);
                sb.setLength(sb.length() - 1);
            }
            else {
                sb.append(')');
                generateParenthesisPairs(openingBraces,closingBraces+1,index+1,ans,sb,n);
                sb.setLength(sb.length() - 1);
            } 
        }
        else {
            return;
        } 
    }
}