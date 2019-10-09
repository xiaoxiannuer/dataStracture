package binarySort;

public class TestBinarySortTree {
    public static void main(String[] args) {
        int[] arr = new int[] {7,3,10,12,5,1,9};
        BinarySortTree tree=new BinarySortTree();
        for (int i:arr){
            tree.add(new Node(i));
        }
       // tree.midShow();
       // System.out.println("================");
        //System.out.println(tree.search(12).data);
        Node node=tree.search(20);
        System.out.println(node.data);
    }
}
