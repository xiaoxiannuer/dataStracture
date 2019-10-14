package hashTable;


public class StuInfo {
    private int age;
    private int count;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public StuInfo(int age, int count) {
        //super()调用父类无参构造函数，如果不加这句，系统会自动加上，如果加上这句系统就不加。
        super();
        this.age = age;
        this.count = count;
    }
    public int hashcode(){
        return age;
    }

    public StuInfo(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "StuInfo{" +
                "age=" + age +
                ", count=" + count +
                '}';
    }
}
