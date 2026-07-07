class Solution {
    public long sumAndMultiply(int n) {
        long x = 0;
        long place = 1;
        long sum =0;

        while(n>0)
        {
            int d = n%10;

            if(d!=0)
            {
                x = d*place + x;
                place *= 10;
                sum+=d;
            }
            n/=10;
        }
        return sum * x;
    }
}