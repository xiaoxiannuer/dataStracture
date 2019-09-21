package binaryTree;

public class TestBinaryTree {
    public static void main(String[] args) {
        BinaryTree binaryTree=new BinaryTree();
        Node root=new Node(1);
        binaryTree.setRoot(root);
        Node rootL=new Node(2);
        root.setLeftNode(rootL);
        Node rootR=new Node(3);
        root.setRightNode(rootR);
        binaryTree.frontShow();
        System.out.println("=============");
        binaryTree.midShow();
        System.out.println("=============");
        binaryTree.afterShow();
        System.out.println("=============");
        System.out.println(binaryTree.frontSearch(4));
        binaryTree.delete(2);
        binaryTree.frontShow();

    }



}
