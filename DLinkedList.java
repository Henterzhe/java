package Day4;

import Day2.ListNode;
import org.omg.CORBA.PUBLIC_MEMBER;
import sun.dc.pr.PRError;

//双向链表 带环的 带傀儡节点
class  DLinkedListNode{
    public  int val=0;
    DLinkedListNode prev=null;
    DLinkedListNode next=null;
    DLinkedListNode(int val){
        this.val=val;
    }

}
public class DLinkedList {
    private DLinkedListNode head=null;
    public DLinkedList(){//带环的双向链表
        head=new DLinkedListNode(-1);//傀儡节点
        head.next=head;
        head.prev=head;
    }
    public void addFirst(int data){//头插
        DLinkedListNode newNode=new DLinkedListNode(data);
        DLinkedListNode next=head.next;

        newNode.next=next;
        head.next=newNode;
        next.prev=newNode;
        newNode.prev=head;
    }
    public void addLast(int data){//尾插
        DLinkedListNode newNode=new DLinkedListNode(data);
        DLinkedListNode prev=head.prev;

        newNode.next=head;
        head.prev=newNode;
        prev.next=newNode;
        newNode.prev=prev;
    }
    public DLinkedListNode getPos(int index){
        DLinkedListNode cur=head;
        for (int i = 0; i <index ; i++) {
            cur=cur.next;
        }
        return cur;
    }
    public  int size(){
        int size=0;
        for (DLinkedListNode cur=head.next;cur!=null;cur=cur.next) {
            size++;
        }
        return  size;
    }
    public void addIndex(int index,int data){
        if(index<0||index>size()){
            return;
        }
        if(index==0){
            addFirst(data);
        }
        if(index==size()){
            addLast(data);
        }
        DLinkedListNode next=getPos(index);
        DLinkedListNode prev=next.prev;

        DLinkedListNode newNode=new DLinkedListNode(data);

        newNode.next=next;
        prev.next=newNode;
        next.prev=newNode;
        newNode.prev=prev;

    }
    public boolean contains(int data){
        for (DLinkedListNode cur=head.next;cur!=null;cur=cur.next) {
            if(cur.val==data){
                return true;
            }
        }
        return false;
    }
    public DLinkedListNode find(int key){
        for (DLinkedListNode cur=head.next;cur!=null;cur= cur.next) {
            if(cur.val==key){
                return cur;
            }
        }
        return null;
    }
    public void remove(int key){
        DLinkedListNode toRemove=find(key);
        if(toRemove==null){
            return;
        }
        DLinkedListNode prev=toRemove.prev;
        DLinkedListNode next=toRemove.next;
        prev.next=next;
        next.prev=prev;
    }
    public void removeAll(int key){
        while (true){
            DLinkedListNode toRemove=find(key);
            if(toRemove==null){
                return;
            }
            DLinkedListNode prev=toRemove.prev;
            DLinkedListNode next=toRemove.next;
            prev.next=next;
            next.prev=prev;
        }

    }
    public void clear(){
        head.next=head;
        head.prev=head;
    }

}
