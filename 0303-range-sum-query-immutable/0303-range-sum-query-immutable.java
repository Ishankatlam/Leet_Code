class NumArray {
   public int[] tree;
   public int n;
    public NumArray(int[] nums) {
        n = nums.length;
        tree = new int[4*n];
        build(1,0,n-1, nums);
    }
    public void build(int node , int left, int right, int[] nums)
    {
        if(left == right)
        {
            tree[node] = nums[left];
            return ;
        }
        int mid = left + (right - left)/2;
        build(2 * node , left , mid , nums);
        build(2 * node +1 , mid +1 , right , nums);
        tree[node] = tree[2 * node] + tree[2 * node +1 ];
    }
    
    public int sumRange(int left, int right) {
        return query(1 , 0 , n-1 ,  left , right);
    }

    public int query(int node , int l , int r , int ql , int qr)
    {
        if (r < ql || l > qr) {
            return 0;
        }

        if (ql <= l && r <= qr) {
            return tree[node];
        }

    
        if (l == r) {
            return tree[node];
        }
        int mid =  l + (r-l)/2;

        int leftsum = query(2 *node , l , mid , ql , qr);
        int rightsum = query(2 * node +1  , mid +1 , r , ql , qr);

        return leftsum + rightsum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */