package binaryTree;

public class BinaryTree {
    Node root;
    public void setRoot(Node root){
        this.root=root;
    }
    public void frontShow(){
        if(root!=null){
            root.frontShow();
        }
    }
    public void midShow(){
        if (root!=null){
            root.midShow();
        }
    }
    public void afterShow(){
        if (root!=null){
            root.afterShow();
        }
    }
    public Node frontSearch(int i){
        return root.frontSearch(i);
    }
    public void delete(int i){
        if (root.data==i){
            root=null;
        }else {
            root.delete(i);
        }
    }
}
