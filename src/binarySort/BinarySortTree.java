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
    /**
     * 删除节点
     */
    public void delete(int data){
        if (root==null){
            return;
        }else {
            //找到这个节点
            Node target=search(data);
            //如果没有这个节点
            if (target==null){
                return;
            }
            //找到他的父节点
            Node parent=searchParent(data);
            //要删除的节点是叶子节点
            if (target.left==null&&target.right==null){
                //要删除的是父节点的左子节点
                if(parent.left.data==data){
                    parent.left=null;
                }else {
                    parent.right=null;
                }
                //删除有两颗子树的节点
            }else if (target.left!=null&&target.right!=null){
                //删除右子树中值最小的节点，并获取该节点的值
                int min=deleteMin(target.right);
                target.data=min;
               //删除有一颗子树的节点
            }else {
                //有左子节点
                if (target.left!=null){
                    if(parent.left.data==data){
                        parent.left=target.left;
                    }else {
                        parent.right=target.left;
                    }
                }
              //有右子节点
                if (target.right!=null){
                    if(parent.left.data==data){
                        parent.left=target.right;
                    }else {
                        parent.right=target.right;
                    }
                }
            }
        }
    }

    private int deleteMin(Node node) {
        Node target=node;
        while (target.left!=null){
            target=target.left;
        }
        delete(target.data);
        return target.data;
    }

    /**
     * 搜索父节点
     * @param data
     * @return
     */
    private Node searchParent(int data) {
        if(root==null){
            return null;
        }else {
            return root.searchParent(data);
        }
    }
}
