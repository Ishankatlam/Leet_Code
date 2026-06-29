class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int count =0;
        for(String substring : patterns)
        {
          boolean isSubString = word.contains(substring);
          if(isSubString )
          {
            count ++;
          }
        }
        return count;
    }
}