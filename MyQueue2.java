public class MyQueue2 {
    private int[] data = new int[100];
    private int head=0;
    private int tail=0;
    private int size=0;

    //1.入队列，如果插入成功，返回true，否则返回false
    //  如果队列满了，再插入就会失败
    public  boolean offer(int x){
        if(size==data.length){
            return  false;
        }
        //新元素放在tail的位置上
        data[tail] = x;
        tail++;
        if(tail == data.length){
            tail=0;
        }
        size++;
        return true;
    }
    //2.出队列
    public  Integer poll(){
        if(size==0){
            return  null;
        }
        Integer ret = data[head];
        head++;
        if(head==data.length){
            head=0;
        }
        size--;
        return ret;
    }
    //3.取队首元素
    public  Integer peek(){
        if(size==0){
            return null;
        }
        return data[head];

    }
    //4.判定为空
    public boolean isEmpty(){
        return  size==0;
    }
    //5.取长度
    public int size(){
        return size;
    }


}
