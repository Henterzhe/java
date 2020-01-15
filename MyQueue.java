package Day4;
class Node {
    public int val;
    public Node next;
    public Node(int val){
        this.val=val;
    }
}

public class MyQueue {
    public Node head=null;
    public Node tail=null;
    private int size=0;
    public void offer(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            tail=newNode;
            size++;
            return;
        }else {
            tail.next=newNode;
            tail=tail.next;
            size++;
            return;
        }
    }
    public Integer poll(){
        if(head==null){
            return null;
        }
        Integer ret=head.val;
        head=head.next;
        if(head==null){
            tail=null;
        }
        size--;
        return ret;
    }
    public Integer peek(){//去堆顶元素
        if(head==null){
            return null;
        }
        return head.val;

    }
    public  boolean isEmpty(){
        return head==null;
    }
    public int size(){
        return size;
    }
}
