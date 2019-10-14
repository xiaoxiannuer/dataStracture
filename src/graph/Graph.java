package graph;

import node.MyStack;

public class Graph {
    private Vertex[] vertex;
    private int curretSize;
    public int[][] adjMat;
    private int currentIndex;
    MyStack myStack=new MyStack();
    public Graph(int size) {
        vertex=new Vertex[size];
        adjMat=new int[size][size];
    }

    /**
     * 向图中加入一个顶点
     * @param v
     */
    public void addVertex(Vertex v){
        vertex[curretSize++]=v;
    }
    public void addEdge(String v1,String v2){
        //找出两个顶点的下标
        int index1=0;
        for (int i=0;i<vertex.length;i++){
            if (vertex[i].getData().equals(v1)){
                index1=i;
                break;
            }
        }
        int index2=0;
        for (int i=0;i<vertex.length;i++){
            if (vertex[i].getData().equals(v2)){
                index2=i;
                break;
            }
        }
        adjMat[index1][index2]=1;
        adjMat[index2][index1]=1;
    }

    /**
     * 深度优先搜寻算法遍历
     */
    public void dfs(){
        vertex[0].visited=true;
        myStack.push(0);
        System.out.println(vertex[0].getData());
        out:while (!myStack.isEmpty()){
            for (int i=currentIndex+1;i<vertex.length;i++){
                if (adjMat[currentIndex][i]==1&&vertex[i].visited==false){
                    myStack.push(i);
                    System.out.println(vertex[i].getData());
                    vertex[i].visited=true;
                    continue out;
                }
            }
            myStack.pop();
            if (!myStack.isEmpty()){
                currentIndex=myStack.peek();
            }

        }

    }
}
