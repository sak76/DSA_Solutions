class Solution {
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> wordStack = new Stack<>();

        StringBuilder res = new StringBuilder();
        int num = 0;

        for(char c : s.toCharArray()) {
            if(Character.isDigit(c)) {
                num = num*10 + (c - '0');
            }
            else if(c == '[') {
                // System.out.println("num = " + num);
                // System.out.println("res = " + res);
                numStack.push(num);
                wordStack.push(res);
                num = 0;
                res = new StringBuilder();
            }
            else if(c == ']') {
                int count = numStack.pop();
                StringBuilder prev = wordStack.pop();
                StringBuilder temp = new StringBuilder();
                while(count > 0) {
                    temp.append(res);
                    count--;
                }

                prev.append(temp);
                res = prev;
            }
            else {
                res.append(c);
            }
        }
        return res.toString();
    }
}