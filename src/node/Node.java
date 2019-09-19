package node;

public class Node {
    int data;
    Node next;
    public Node(int data){
        this.data=data;
    }
    //为节点追加节点
    public Node append(Node node){
        Node currentNode=this;
        while (true){
            Node nextNode=currentNode.next;
            if (nextNode==null){
                break;
            }else {
                currentNode=nextNode;
            }
        }
        currentNode.next=node;
        return this;
    }
    //插入一个节点
    public void after(Node node){
        Node nextNext=next;
        this.next=node;
        node.next=nextNext;
    }
    //显示所有节点
    public void show(){
        Node currentNode=this;
        while (true){
            System.out.println(currentNode.data+"");
            currentNode=currentNode.next;
            if (currentNode==null){
                break;
            }
        }
        System.out.println();
    }
    //删除下一个节点
    public void removeNext(){
        Node nextNext=next.next;
        this.next=nextNext;
    }
    //获取下一个节点
    public Node next(){
        return this.next;
    }
    //获取节点中的数据
    public int getData(){
        return this.data;
    }
    //当前节点是否是最后一个节点
    public boolean isLast(){
        return next==null;
    }
}
