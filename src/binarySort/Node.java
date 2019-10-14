package binarySort;

public class Node {
    int data;
    Node left;
    Node right;
    public Node(int data){
        this.data=data;
    }

    /**
     * 获取左子树的高度
     * @return
     */
    public int leftHeight(){
        if (left==null){
            return 0;
        }
        return left.height();
    }
    /**
     * 获取右子树的高度
     */
    public int rightHeight() {
        if (right==null){
            return 0;
        }
        return right.height();
    }

    /**
     * 返回当前节点的高度
     * @return
     */
    public int height() {
        return Math.max(left==null?0:left.height(),right==null?0:right.height())+1;
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
        //查询是否平衡
        //进行右旋转
        if (leftHeight()-rightHeight()>=2){
            //双旋转
            if (left!=null&&left.leftHeight()<left.rightHeight()){
                //先左旋转
                left.leftRotate();
                //再右旋转
                rightRotate();
            }else {
                rightRotate();
            }

        }
        if (leftHeight()-rightHeight()<=-2){
            //双旋转
            if (right!=null&&right.rightHeight()<right.leftHeight()){
                //先右旋转
                right.rightRotate();
                //再左旋转
                leftRotate();
            }else {
                rightRotate();
            }

        }
    }

    private void leftRotate() {
        Node newNode=new Node(data);
        newNode.left=left;
        newNode.right=right.left;
        data=right.data;
        right=right.right;
        left=newNode;
    }

    private void rightRotate() {
        //创建一个新节点，值等于当前节点的值
        Node newNode=new Node(data);
        //把新节点的右子树设置为当前节点的右子树
        newNode.right=right;
        //把新节点的左子树设置为当前节点的左子树的右子树
        newNode.left=left.right;
        //把当前节点的值替换为左子节点的值
        data=left.data;
        //把当前节点的左子树设置为左子树的左子树
        left=left.left;
        //把当前节点的右子树设置为新节点
        right=newNode;
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

    public Node searchParent(int data) {
        if ((this.left!=null&&this.left.data==data)||(this.right!=null&&this.right.data==data)){
            return this;
        }else {
            if (this.left!=null&&this.data>data){
                return this.left.searchParent(data);
            }else if (this.right!=null&&this.data<data){
                return this.right.searchParent(data);
            }
            return null;
        }
    }
}
