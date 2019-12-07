import java.util.Arrays;

public class MySeqList {
   //初始容量10
  private int []data=new int[10];
   //有效长度
   private int size=0;
   public void display(){
      //打印

      System.out.println("[");
      for(int i=0;i<size;i++){
         System.out.print(data[i]);
         if(i!=data.length-1){
            System.out.print(",");
         }
      }
      System.out.println("]");
//      System.out.println(Arrays.toString(data));
   }
   public void add(int pos,int data){
      //在pos位置增加date元素
      if(pos<0||pos>size){
         return;
      }
      if(this.size>=this.data.length){
         realloc();
      }
      if(pos==size){
         this.data[pos]=data;
         this.size++;
         return;
         //尾插
      }
      //普通位置
      for (int i = this.size; i >pos ; i--) {
         this.data[i]=this.data[i-1];
      }
      this.data[pos]=data;
      size++;
   }
   public void realloc(){
      int []newdata=new int[this.data.length*2];
      for (int i = 0; i <this.data.length ; i++) {
         newdata[i]=this.data[i];
      }
      this.data=newdata;
   }
   public  boolean contains(int toFind){
      //是否含有toFind，有返回true
      return  (search(toFind)>=0);

   }
   public int search(int toFind){
      //是否含有toFind，有返回位置
      for (int i = 0; i <this.size ; i++) {
         if(this.data[i]==toFind){
            return i;
         }
      }
      return -1;
   }
   public int getPos(int pos){
      return this.data[pos];
   }
   public void setPos(int pos,int value){
      //将pos位置的值设置为value
      this.data[pos]=value;
   }
   public void remove(int toRemove){
      //删除第一次出现的位置
      int pos=search(toRemove);
      if(pos==-1){
         return;
      }
      //尾删
      if(pos==this.size-1){
         size--;
         return;
      }
      //普通情况
      for (int i = pos; i <this.size -1; i++) {
         this.data[i]=this.data[i+1];
         size--;
      }
   }
   public int size(){
      return this.size;
   }
   public void clear(){
      this.size=0;
      this.data=new int[10];
   }
}
