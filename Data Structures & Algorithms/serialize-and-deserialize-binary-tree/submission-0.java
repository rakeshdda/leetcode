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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();

        helper(root, sb);

        return sb.toString();
    }
    public void  helper(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("null,");
            return;
        }

        sb.append(root.val).append(",");

        helper(root.left, sb);
        helper(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String [] arr = data.split(",");

        int [] index ={0};

      return  helper1(arr, index);
    }
    public TreeNode helper1(String[] arr, int [] index){
        if(arr[index[0]].equals("null")){

            index[0]++;
            return null;
        }

        // TreeNode root = new TreeNode(Integer.parseInt(arr[index[0]]));
        TreeNode root = new TreeNode(Integer.parseInt(arr[index[0]]));
        index[0]++;

        root.left = helper1(arr, index);
        root.right = helper1(arr, index);

        return root;
    }
}
