package D15;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zjy
 * @version 1.0
 */

public class I3 {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> res = new ArrayList<>();
        while(!queue.isEmpty()){
            int curLen = queue.size();
            int temp = 0;
            for (int i = 0; i < curLen; i++) {
                TreeNode poll = queue.poll();
                temp = poll.val;
                if(poll.left != null) queue.offer(poll.left);
                if(poll.right != null) queue.offer(poll.right);
            }
            res.add(temp);
        }
        return res;
    }
}
