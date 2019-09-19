package node;

public class DoubleNode {
    DoubleNode pre=this;
    DoubleNode next=this;
    int data;
    public DoubleNode(int data){
        this.data=data;
    }
    //插入节点
    public void after(DoubleNode node){
        DoubleNode nextNext=next;
        this.next=node;
        node.next=nextNext;
        node.pre=this;
        nextNext.pre=node;
    }
    //下一个节点
    public DoubleNode next() {
        return this.next;
    }

    //上一个节点
    public DoubleNode pre() {
        return this.pre;
    }

    //获取数据
    public int getData() {
        return this.data;
    }
}
