package threadedBinaryTree;

public class ThreadedBinaryTree {
    ThreadedNode root;
    //用于临时存储前驱节点
    ThreadedNode pre=null;
    public void setRoot(ThreadedNode root){
        this.root=root;
    }
    //遍历线索二叉树
    public void threadIterate(){
        ThreadedNode node=root;
        while (node!=null){
            while (node.leftType==0){
                node=node.leftNode;
            }
            System.out.println(node.data);
            while (node.rightType==1){
                node=node.rightNode;
                System.out.println(node.data);
            }
            node=node.rightNode;
        }
    }

    public void threadedNodes() {
        threadedNodes(root);
    }
    public void threadedNodes(ThreadedNode node){
        if (node==null){
            return;
        }
        //处理左子树
        threadedNodes(node.leftNode);
        if (node.leftNode==null){
            node.leftNode=pre;
            node.leftType=1;
        }
        //处理前驱的右指针，如果前驱节点的右指针是null(没有指下右子树)
        if(pre!=null&&pre.rightNode==null) {
            //让前驱节点的右指针指向当前节点
            pre.rightNode=node;
            //改变前驱节点的右指针类型
            pre.rightType=1;
        }
        //每处理一个节点，当前节点是下一个节点的前驱节点
        pre=node;
        //处理右子树
        threadedNodes(node.rightNode);
    }
    //前序遍历
    public void frontShow() {
        if(root!=null) {
            root.frontShow();
        }
    }

    //中序遍历
    public void midShow() {
        if(root!=null) {
            root.midShow();
        }
    }

    //后序遍历
    public void afterShow() {
        if(root!=null) {
            root.afterShow();
        }
    }

    //前序查找
    public ThreadedNode frontSearch(int i) {
        return root.frontSearch(i);
    }

    //删除子树
    public void delete(int i) {
        if(root.data==i) {
            root=null;
        }else {
            root.delete(i);
        }
    }
}
