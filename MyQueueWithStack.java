import java.util.Stack;

public class MyQueueWithStack {//用栈实现队列
     private Stack<Integer> A=new Stack<>();
     private Stack<Integer> B=new Stack<>();
     public  void push(int x)
     {
         while(!B.isEmpty()){
             int tmp=B.pop();
             A.push(tmp);
         }
         A.push(x);
     }
     public  int pop() {//队首
         //如果是空队列 不需要进行出队列
         if (A.isEmpty() && B.isEmpty()) {
             return 0;
         }
         //要把a中的元素先都倒腾到B中
         while (!A.isEmpty()){
             int tmp=A.pop();
             B.push(tmp);
         }
         return B.pop();
     }
     public int peek(){
         if (A.isEmpty() && B.isEmpty()) {
             return 0;
         }
         //要把a中的元素先都倒腾到B中
         while (!A.isEmpty()){
             int tmp=A.pop();
             B.push(tmp);
         }
         return B.peek();
     }
     public  boolean empty(){
         return A.isEmpty()&&B.isEmpty();
     }
}
