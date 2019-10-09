package binarySort;

public class Node {
    int data;
    Node left;
    Node right;
    public Node(int data){
        this.data=data;
    }

    public void add(Node node) {
        if (node==null){
            return;
        }
        //判断传入的节点的值比当前子树的根节点的值大还是小
        //添加的节点比当前节点的值更小
        if (node.data<this.data){
            if (this.left==null){
                this.left=node;
            }else {
                this.left.add(node);
            }
        }else {
            //添加的节点比当前节点的值更大
            if (this.right==null){
                this.right=node;
            }else {
                this.right.add(node);
            }
        }
    }

    public void midShow(Node node) {
        if (node==null){
            return;
        }
        midShow(node.left);
        System.out.println(node.data);
        midShow(node.right);
    }

    public Node search(int data) {
        if (this.data==data){
            return this;
        }else if (this.data>data){
            if (left==null){
                return null;
            }
                return left.search(data);


        }else {
            if (right==null){
                return null;
            }
                return right.search(data);

        }
    }
}
