class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
         for(String token : tokens)
         {
            
        if(Character.isDigit(token.charAt(0)) ||
        (token.length() >1 && token.charAt(0)=='-'))
        {
            st.push(Integer.parseInt(token));
        }

        else 
        {
            int val1 = st.pop();
            int val2 = st.pop();

            if(token.equals("+"))st.push(val1 +val2);
           else  if(token.equals("-"))st.push(val2 - val1);
           else if(token.equals("*"))st.push(val2 * val1);
           else if(token.equals("/"))st.push(val2 /val1);
           else if(token.equals("^"))st.push((int)Math.pow(val2 , val1)); 
        }

         }
         return st.pop();

    }
}