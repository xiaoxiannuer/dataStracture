package huffmanTree;

import java.io.*;
import java.util.*;

public class TestHuffmanCode {
    public static void main(String[] args) {
       /* String msg="can you can a can as a can canner can a can.";
        byte[] bytes=msg.getBytes();
        //System.out.println(Arrays.toString(bytes));
        //进行赫夫曼编码
        //System.out.println(bytes.length);
        byte[] b=huffmanZip(bytes);
        //System.out.println(b.toString());
        //指定赫夫曼编码表解码
        byte[] newByte=deCode(huffCode,b);
        System.out.println(Arrays.toString(bytes));
        System.out.println(Arrays.toString(newByte));
        */
       /*String src="5.bmp";
       String dst="6.zip";
       try {
           zipFile(src,dst);
       }catch (Exception e) {
           e.printStackTrace();
       }*/
       String src="6.zip";
       String dst="7.bmp";
       try {
           unZip(src,dst);
       }catch (Exception e) {
           e.printStackTrace();
       }
    }

    /**
     * 解压文件
     * @param src
     * @param dst
     * @throws Exception
     */
    public static void unZip(String src,String dst)throws Exception{
        //创建一个输入流
        InputStream is=new FileInputStream(src);
        ObjectInputStream ois=new ObjectInputStream(is);
        //读取byte数组
        byte[] b= (byte[]) ois.readObject();
        //读取赫夫曼编码表
        Map<Byte,String>codes= (Map<Byte, String>) ois.readObject();
        ois.close();
        is.close();
        byte[] bytes=deCode(codes,b);
        //输出流
        OutputStream os=new FileOutputStream(dst);
        os.write(bytes);
        os.close();
    }
    /**
     * 压缩文件
     * @param src
     * @param dst
     * @throws Exception
     */
    public static void zipFile(String src,String dst) throws Exception{
        //创建一个输入流
        InputStream is=new FileInputStream(src);
        //创建一个和输入流指向的文件大小一样的byte数组
        byte[] b=new byte[is.available()];
        //读取文件内容
        is.read(b);
        is.close();
        //使用赫夫曼编码进行编码
        byte[] byteZip=huffmanZip(b);
        //输出流
        OutputStream os=new FileOutputStream(dst);
        ObjectOutputStream oos=new ObjectOutputStream(os);
        //把压缩后的byte数组写入文件
        oos.writeObject(byteZip);
        //把赫夫曼编码表写入文件
        oos.writeObject(huffCode);
        oos.close();
        os.close();
    }

    private static byte[] deCode(Map<Byte, String> huffCode, byte[] bytes) {
        StringBuilder sb=new StringBuilder();
        //把byte数组转换为二进制字符串
        for (int i=0;i<bytes.length;i++){
            byte b=bytes[i];
            //System.out.println(b);
            //是否是最后一个
            boolean flag=(i==bytes.length-1);
            sb.append(byteToBitStr(!flag,b));

        }
        //System.out.println(sb.toString());
        //把字符串按照指定的赫夫曼编码进行解码
        Map<String,Byte>map=new HashMap<>();
        for (Map.Entry<Byte,String>entry:huffCode.entrySet()){
            map.put(entry.getValue(),entry.getKey());
        }
        //创建一个集合用于存byte
        List<Byte>list=new ArrayList<>();
        //处理字符串
        for (int i=0;i<sb.length();){
            int count=1;
            boolean flag=true;
            Byte b=null;
            while (flag){
                b=map.get(sb.substring(i,i+count));
                if (b==null){
                    count++;
                }else {
                    flag=false;
                }
            }
            list.add(b);
            i+=count;
        }
        byte[] b=new byte[list.size()];
        for (int i=0;i<b.length;i++){
            b[i]=list.get(i);
        }
        return b;
    }

    private static String byteToBitStr(boolean flag,byte b) {
        int temp=b;
        if (flag){
            temp|=256;
        }
        String str=Integer.toBinaryString(temp);
        //System.out.println(str);
        if (flag){
            return str.substring(str.length()-8);
        }else {
            return str;
        }

    }


    //赫夫曼编码压缩
    private static byte[] huffmanZip(byte[] bytes) {
        List<Node>nodes=getNodes(bytes);
        //创建一颗赫夫曼树
        Node tree=createHuffmanTree(nodes);
        //创建一个赫夫曼编码表
        Map<Byte,String>huffCodes=getCodes(tree);
        //System.out.println(huffCodes);
        //编码
        byte[] b=zip(bytes,huffCodes);
        return b;
    }

    private static byte[] zip(byte[] bytes, Map<Byte, String> huffCodes) {
        StringBuilder sb=new StringBuilder();
        //把需要压缩的byte数组处理成一个二进制字符串
        for (byte b:bytes){
            sb.append(huffCodes.get(b));
        }
        //System.out.println(sb.toString());
        //定义长度
        int len;
        if (sb.length()%8==0){
            len=sb.length()/8;
        }else {
            len=sb.length()/8+1;
        }
        //用于存储压缩后的byte
        byte[] by=new byte[len];
        //记录新byte的位置
        int index=0;
        for (int i=0;i<sb.length();i+=8){
            String strByte;
            if (i+8>sb.length()){
                strByte=sb.substring(i);
            }else {
                strByte=sb.substring(i,i+8);
            }
            //二进制数输出为十进制数
            byte byt= (byte) Integer.parseInt(strByte,2);
            by[index]=byt;
            index++;
        }
        return by;
    }

    //用于临时存储路径
    static StringBuilder sb=new StringBuilder();
    //存储赫夫曼编码
    static Map<Byte,String>huffCode=new HashMap<>();
    private static Map<Byte, String> getCodes(Node tree) {
        if (tree==null){
            return null;
        }
        getCodes(tree.left,"0",sb);
        getCodes(tree.right,"1",sb);
        return huffCode;
    }

    private static void getCodes(Node node, String code, StringBuilder sb) {
        StringBuilder sb2=new StringBuilder(sb);
        sb2.append(code);
        if (node.data==null){
            getCodes(node.left,"0",sb2);
            getCodes(node.right,"1",sb2);
        }else {
            huffCode.put(node.data,sb2.toString());
        }
    }

    private static Node createHuffmanTree(List<Node> nodes) {
        while (nodes.size()>1){
            Collections.sort(nodes);
            Node left=nodes.get(nodes.size()-1);
            Node right=nodes.get(nodes.size()-2);
            Node parent=new Node(null,left.weight+right.weight);
            parent.left=left;
            parent.right=right;
            nodes.remove(left);
            nodes.remove(right);
            nodes.add(parent);
        }
        return nodes.get(0);
    }

    private static List<Node> getNodes(byte[] bytes) {
        List<Node>nodes=new ArrayList<>();
        Map<Byte,Integer>counts=new HashMap<>();
        for (byte b:bytes){
        Integer count=counts.get(b);
        if (count==null){
            counts.put(b,1);
        }else {
            counts.put(b,count+1);
        }
        }
        for (Map.Entry<Byte,Integer>entry:counts.entrySet()){
            nodes.add(new Node(entry.getKey(),entry.getValue()));
        }

        return nodes;
    }


}
