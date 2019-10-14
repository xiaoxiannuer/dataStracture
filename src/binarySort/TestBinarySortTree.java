package binarySort;

public class TestBinarySortTree {
    public static void main(String[] args) {
        int[] arr = new int[] {5,4,7,6,8,9};
        BinarySortTree tree=new BinarySortTree();
        for (int i:arr){
            tree.add(new Node(i));
        }
       // tree.midShow();
       // System.out.println("================");
        //System.out.println(tree.search(12).data);
       // Node node=tree.search(20);
       // System.out.println(node.data);
//        tree.delete(5);
//        tree.midShow();
//        System.out.println("===");
//        tree.delete(3);
//        tree.midShow();
       // tree.delete(10);
       // tree.midShow();
       // System.out.println(tree.root.rightHeight());
        //System.out.println(tree.root.data);
        //System.out.println(tree.root.height());
    }
}
