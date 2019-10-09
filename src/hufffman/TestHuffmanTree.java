package hufffman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestHuffmanTree {
    public static void main(String[] args) {
        int[] arr={3,8,7,5,23,14,29,11};
        System.out.println(createHuffmanTree(arr));
    }
    //创建赫夫曼树
    public static Node createHuffmanTree(int[] arr){
        //先使用数组中的所有元素创建若干个二叉树（只有一个节点）
        List<Node>nodes=new ArrayList<>();
        for (int data:arr){
            nodes.add(new Node(data));
        }
        //循环处理
        while (nodes.size()>1){
            //排序
            Collections.sort(nodes);
            //取出权值最小的两个二叉树
            Node left=nodes.get(nodes.size()-1);
            Node right=nodes.get(nodes.size()-2);
            //创建一颗新的二叉树
            Node parent=new Node(left.data+right.data);
            //把取出来的两个二叉树移除
            nodes.remove(left);
            nodes.remove(right);
            //放入原来的二叉树集合中
            nodes.add(parent);
        }

        return nodes.get(0);
    }
}
