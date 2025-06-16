import java.util.LinkedList;
import java.util.Queue;

/*
 Time complexity - O(N)
 Space complexity - O(N)
 */
public class CousinsInBinaryTree_LC_993 {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> parentQueue = new LinkedList<>();
        queue.offer(root);
        parentQueue.offer(null);

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean isXexist = false;
            boolean isYexist = false;
            TreeNode xParent = null;
            TreeNode yParent = null;

            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                TreeNode curParent = parentQueue.poll();

                if(cur.val == x) {
                    isXexist = true;
                    xParent = curParent;

                }
                if(cur.val == y) {
                    isYexist = true;
                    yParent = curParent;
                }
                if(cur.left != null) {
                    queue.add(cur.left);
                    parentQueue.add(cur);
                }
                if(cur.right != null) {
                    queue.add(cur.right);
                    parentQueue.add(cur);
                }
            }
            if(isXexist && isYexist){
                return xParent != yParent;
            }
            if(isXexist || isYexist){
                return false;
            }

        } return false;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}