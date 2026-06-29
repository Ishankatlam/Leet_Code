/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
         
         List<List<Integer>> result = new ArrayList<>();

         Map<Integer , List<Integer>> map = new HashMap<>();

         addtoMap(root , 0 , map);

         for(int i = map.size()-1;i>=0;i--)
         {
            result.add(new ArrayList<>(map.get(i)));
         }
         return result  ;

    }

    public void addtoMap(TreeNode root , int level , Map<Integer  , List<Integer>> map)
    {
        if(root == null)
        {
            return;
        }

        map.putIfAbsent(level  , new ArrayList<>());

        map.get(level).add(root.val);

        addtoMap(root.left , level +1 , map);

        addtoMap(root.right  , level +1 , map);
    }
}