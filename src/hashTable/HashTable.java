package hashTable;

import java.util.Arrays;

public class HashTable {
    StuInfo[] data=new StuInfo[100];
    public void put(StuInfo stuInfo){
        int index=stuInfo.hashcode();
        //data[index%10]=stuInfo;
        data[index]=stuInfo;
    }
    public StuInfo get(StuInfo stuInfo){
        return data[stuInfo.hashcode()];
    }

    @Override
    public String toString() {
        return "HashTable{" +
                "data=" + Arrays.toString(data) +
                '}';
    }
}
