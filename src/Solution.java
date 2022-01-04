import java.util.HashMap;
import java.util.Map;

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};

class Solution {
    Map<Integer, Node> map = new HashMap<>();
    int index = 0;

    public Node treeToDoublyList(Node root) {
        if (root == null){
            return null;
        }
        dfs(root);
        if (index == 1){
            root.right = root;
            root.left = root;
            return root;
        }
        int size = map.size();
        map.get(0).left = map.get(size-1);
        map.get(0).right = map.get(1);
        map.get(size-1).left = map.get(size-2);
        map.get(size-1).right = map.get(0);
        for (int i = 1; i < size - 1; i++){
            map.get(i).left = map.get(i-1);
            map.get(i).right = map.get(i+1);
        }
        return map.get(0);
    }

    private void dfs(Node root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        map.put(index++, root);
        dfs(root.right);
    }
}