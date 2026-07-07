class Solution {
    public long sumAndMultiply(int n) {
        String str = Integer.toString(n);

        StringBuilder sb = new StringBuilder();

        int num =0;
        for(char c : str.toCharArray())
        {
           if(c != '0')
           {
            sb.append(c);
             int y = Character.getNumericValue(c);
             num += y;
           }
        }
        if(sb.length() == 0) return 0;
        String s = sb.toString();
        int z = Integer.parseInt(s);

        return (long)z * num;
        
    }
}