package threadedBinaryTree;


public class ThreadedNode {
    int data;
    ThreadedNode leftNode;
    ThreadedNode rightNode;
    //等于0表示子节点，等于1表示前驱节点后继节点
    int leftType;
    int rightType;
    public ThreadedNode(int data){
        this.data=data;
    }
    public void setLeftNode(ThreadedNode leftNode){
        this.leftNode=leftNode;
    }
    public void setRightNode(ThreadedNode rightNode){
        this.rightNode=rightNode;
    }
    public void frontShow(){
        System.out.println(data);
        if (leftNode!=null){
            leftNode.frontShow();
        }
        if (rightNode!=null){
            rightNode.frontShow();
        }
    }
    public void midShow(){
        if (leftNode!=null){
            leftNode.midShow();
        }
        System.out.println(data);
        if (rightNode!=null){
            rightNode.midShow();
        }
    }
    public void afterShow(){
        if (leftNode!=null){
            leftNode.afterShow();
        }
        if (rightNode!=null){
            rightNode.afterShow();
        }
        System.out.println(data);
    }
    public ThreadedNode frontSearch(int i){
        ThreadedNode target=null;
        if (this.data==i){
            return this;
        }else {
            if (leftNode!=null){
                target=leftNode.frontSearch(i);
            }
            if (target!=null){
                return target;
            }
            if (rightNode!=null){
                target=rightNode.frontSearch(i);
            }
        }
        return target;
    }
    public void delete(int i){
        ThreadedNode parent=this;
        if (parent.leftNode!=null&&parent.leftNode.data==i){
            parent.leftNode=null;
            return;
        }
        if (parent.rightNode!=null&&parent.rightNode.data==i){
            parent.rightNode=null;
            return;
        }
        parent=leftNode;
        if (parent!=null){
            parent.delete(i);
        }
        parent=rightNode;
        if (parent!=null){
            parent.delete(i);
        }

    }
}
