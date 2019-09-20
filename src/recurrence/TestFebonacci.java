package recurrence;

public class TestFebonacci {
    public static void main(String[] args) {
        System.out.println(febonacci(2));
    }
    public static int febonacci(int i){
        if (i==1||i==2){
            return 1;
        }else {
            return febonacci(i-1)+febonacci(i-2);
        }
    }
}
