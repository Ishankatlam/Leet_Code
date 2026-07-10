class Solution {
    public int maxDistance(String moves) {
        int r =0;
        int c =0;
        int dash_count =0;
        for(int i=0;i<moves.length();i++)
            {
                char ch = moves.charAt(i);

                if(ch == 'U')c++;
                else if(ch=='D')c--;
                else if(ch == 'L')r--;
                else if(ch == 'R')r++;
                else if(ch == '_')dash_count++;
            }
        return Math.abs(r) + Math.abs(c) + dash_count;
    }
}