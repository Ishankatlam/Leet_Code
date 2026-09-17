class NumArray {
      public int[] tree;
      public int n ;
    public NumArray(int[] nums) {
        n = nums.length;
        tree= new int[4 *n];
        build(1 ,0 , n-1, nums);
    }
    public void build(int node , int left , int right , int[] nums)
    {
        if(left == right)
        {
            tree[node] = nums[left];
            return ;
        }
        int mid = left + (right - left )/2;
        build(2 * node , left , mid , nums);
        build(2 * node +1 ,mid + 1 ,right, nums );

        tree[node] = tree[2 * node] + tree[2 * node +1];
    }
    
    public void update(int index, int val) {
        change(1, 0 ,n-1 , index, val );
    }

    public void change(int node , int left , int right , int index , int val)
    {
        if(left == right)
        {
            tree[node] = val;
            return;
        }
         int mid = left + (right - left )/2;
           
            if(left <= index && index <= mid)
            {
               change(2 * node , left , mid , index , val);
            }
            else 
            {
                change(2 * node + 1,mid + 1, right , index , val);
            }

            tree[node] = tree[2 * node] + tree[2 * node + 1];

    }
    
    public int sumRange(int left, int right) {
        return query(1 , 0 , n-1 , left , right);
    }

    public int query(int node , int left , int right , int ql , int qr)
    {
        if(right < ql || left > qr)return 0;
        if(ql <= left && right <= qr)return tree[node] ;
        if(left == right)return tree[node];

        int mid = left + (right - left)/2;
        
       int leftsum = query(2 * node , left , mid , ql , qr);
       int rightsum = query(2 * node +1 , mid +1 , right , ql , qr);
       
       return leftsum + rightsum;

    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */