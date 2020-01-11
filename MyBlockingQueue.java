package lesson4;

public class MyBlockingQueue {
    private  Object[] elements;

    public MyBlockingQueue(int capacity){
        elements=new Object[capacity];
    }
    public  void put(Object element){

    }
    public Object take(){

        return elements[0];
    }
}
