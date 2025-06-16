

//BFS Approach
//Tc- O(N) n is number of nodes
/* SC - O(N)
Space complexity: O(D) to keep the queues, where D is a tree diameter. Let's use the last level to estimate the queue size. This level could contain up to
N/2 tree nodes in the case of complete binary tree.
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Binary_Tree_Right_Side_View_LC_199 {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> level = new LinkedList<>();
        List<Integer> output = new ArrayList<>();

        if(root == null)
            return output;
        level.offer(root);

        while(!level.isEmpty()){

            int size = level.size();
            for(int i = 0; i< size ;i++){
                TreeNode node = level.poll();
                if(i == size-1){
                    output.add(node.val);
                }

                if(node.left != null)
                    level.offer(node.left);
                if(node.right != null)
                    level.offer(node.right);
            }
        }

        return output;
    }
}

//Crucial to visit right child first in DFS and add it to list then when you visit left side with same level we already have result in the list hence we skip left side completely
/* DFS (recursive) and copied from official solution */


class Solution {
    List<Integer> rightside = new ArrayList();

    public void helper(TreeNode node, int level) {
        if (level == rightside.size())
            rightside.add(node.val);

        if (node.right != null)
            helper(node.right, level + 1);
        if (node.left != null)
            helper(node.left, level + 1);
    }

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return rightside;

        helper(root, 0);
        return rightside;
    }
}