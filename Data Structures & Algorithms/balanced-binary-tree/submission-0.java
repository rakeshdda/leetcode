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
    public boolean isBalanced(TreeNode root) {
        if(root== null){
            return true;
        }

        int leftSubTreeHeight =height(root.left);
        int rightSubTreeHeight =height(root.right);

        int diff =Math.abs(leftSubTreeHeight - rightSubTreeHeight);

        return diff <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
    public int height(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);

        return 1+ Math.max(left, right);
    }
}
