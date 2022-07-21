package D16;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zjy
 * @version 1.0
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，
 * 进而可以将转换后的数据存储在一个文件或者内存中，
 * 同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 *
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 /
 * 反序列化算法执行逻辑，只需要保证一个二叉树可以被序列化为一个字符串
 * 并且将这个字符串反序列化为原始的树结构。
 *
 */

public class I2 {
}

/**
 * 通过这一题我们发现，以往的bfs都是逐层遍历，在一个while循环中需要嵌套一个for循环体，
 * 而这个题目则没有。
 * 可以发现这两者本质之间是没有不同的，最终的结果都是一样，但是由于嵌套了for循环，使得深度降低，
 * 时间复杂度和空间复杂度都有所降低。
 * 对于bfs，for循环代表宽度，while循环代表深度。
 * 因此如果不需要计算深度相关信息的话，比如得到层数之类的，完全可以不使用for循环
 */
class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return new String();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder buffer = new StringBuilder();
        queue.offer(root);
        while(!queue.isEmpty()){
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if(node != null){
                    buffer.append(node.val);
                    queue.offer(node.left);
                    queue.offer(node.right);
                }else{
                    buffer.append("null");
                }
                buffer.append(",");
            }
        }
        buffer.deleteCharAt(buffer.length()-1);
        return buffer.toString();
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")){
            return null;
        }
        String[] split = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(!"null".equals(split[i])){
                node.left = new TreeNode(Integer.parseInt(split[i]));
                queue.offer(node.left);
            }
            i++;
            if(!"null".equals(split[i])){
                node.right = new TreeNode(Integer.parseInt(split[i]));
                queue.offer(node.right);
            }
            i++;
        }
        return root;
    }
}
