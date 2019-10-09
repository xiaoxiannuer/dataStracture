package binarySort;

public class BinarySortTree {
    Node root;

    /**
     * 向二叉排序树中添加节点
     * @param node
     */
    public void add(Node node){
        if(root==null){
            root=node;
        }else {
            root.add(node);
        }
    }

    /**
     * 中序遍历二叉排序树
     */
    public void midShow(){
        if (root!=null){
            root.midShow(root);
        }
    }
    /**
     * 节点的查找
     */
    public Node search(int data){
        if (root==null){
            return null;
        }else {
            return root.search(data);
        }
    }
}
