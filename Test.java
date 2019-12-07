public class Test {
    public static void main(String[] args) {
        MySeqList mySeqList =new MySeqList();
        mySeqList.add(0,1);
        mySeqList.add(1,5);
        mySeqList.add(2,7);
        mySeqList.add(3,10);
        mySeqList.display();
        System.out.println(mySeqList.search(5));
        System.out.println(mySeqList.contains(12));
        System.out.println(mySeqList.size());
        mySeqList.remove(10);
        mySeqList.display();
        mySeqList.remove(5);
        mySeqList.display();
        mySeqList.add(6,45);
        mySeqList.add(8,55);
        mySeqList.add(10,78);
        mySeqList.display();

    }
}
