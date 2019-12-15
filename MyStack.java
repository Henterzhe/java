import java.lang.reflect.Array;
import java.util.Arrays;

public class MyStack {//用数组实现栈

//    private  int[]array=new int[10];
//    private int top=0;
//    private void ensureCapacity(){
//        if(top<array.length){
//            return;
//        }
//        array= Arrays.copyOf(array,2*array.length);
//    }
//    public  int push(int elemant){//将项目推送到这个堆栈的顶部
//        ensureCapacity();
//        array[top++]=elemant;
//        return elemant;
//    }
//    public  int pop(){//删除此堆栈顶部的对象，并将该对象作为此函数的值返回
//        return array[--top];
//    }
//    public int peek(){//查看此堆栈顶部的对象，而不从堆栈中删除它
//        return  array[top-1];
//    }
//    public boolean empty(){//判断栈顶是否为空
//        return  top==0;
//    }
//    public int size(){
//        return top;
//    }
//    public  int search(int element){//返回一个对象在此堆栈上基于1的位置
//        for (int i = 0; i <top ; i++) {
//            if(array[i]==element){
//                return  i;
//            }
//        }
//        return  -1;
//    }
    private int[] array=new int[100];
    private int  size=0;
    //核心操作就只有三个
    //1.入栈
    public  void push(int x){
        array[size]=x;
        size++;
    }
    //2.出栈
    public  Integer pop(){
        if(size==0){
            return null;
        }
        int ret=array[size-1];
        return ret;
    }
    //3.取栈顶元素的值
    public Integer peek(){
        if(size==0){
            return  null;
        }
        return array[size-1];
    }
    //4.判断栈为空
    public boolean isEmpty(){
        return size==0;
    }
    //5.栈的大小
    public int size(){
        return size;
    }
}
