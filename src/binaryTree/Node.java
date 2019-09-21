package binaryTree;

public class Node {
    int data;
    Node leftNode;
    Node rightNode;
    public Node(int data){
        this.data=data;
    }
    public void setLeftNode(Node leftNode){
        this.leftNode=leftNode;
    }
    public void setRightNode(Node rightNode){
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
    public Node frontSearch(int i){
        Node target=null;
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
        Node parent=this;
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
