package recurrence;

public class TestHanoi {
    public static void main(String[] args) {
        hanoi(2,'A','B','C');
    }

    /**
     *
     * @param n 共有N个盘子
     * @param from 开始的柱子
     * @param in 中间的柱子
     * @param to 目标柱子
     * 无论有多少个盘子，都认为只有两个盘子。上面的所有盘子和最下面的一个盘子。
     */
    public static void hanoi(int n,char from,char in,char to){
        if (n==1){
            System.out.println("第1个盘子从"+from+"移动到"+to);
        }else {
            hanoi(n-1,from,to,in);
            System.out.println("第"+n+"个盘子从"+from+"移动到"+to);
            hanoi(n-1,in,from,to);
        }
    }
}
