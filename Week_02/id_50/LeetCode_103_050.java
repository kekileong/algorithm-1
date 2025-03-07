package algorithm.Week_02.id_50;

import algorithm.Week_01.id_50.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by yu on 2019/6/29.
 * . 103. 二叉树的锯齿形层次遍历
 */
public class LeetCode_103_050 {
    public List<List<Integer>> levelOrder2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> resList = new LinkedList<List<Integer>>();
        if (root == null) {
            return resList;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> subList = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                if (queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                }
                if (queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }
                subList.add(queue.poll().val);
            }
            resList.add(subList);
        }
        return resList;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        bfs(list, root, 0);
        return list;
    }

    private void bfs(List<List<Integer>> list, TreeNode node, int level) {
        if (node == null) {
            return;
        }
        if (level == list.size()) {
            list.add(new LinkedList<Integer>());
        }
        if (level % 2 == 0) {
            list.get(level).add(node.val);
        } else {
            list.get(level).add(0, node.val);
        }
        bfs(list, node.left, level + 1);
        bfs(list, node.right, level + 1);
    }
}
