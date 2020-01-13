package Day1;

import java.util.*;

//实现函数 ToLowerCase()，该函数接收一个字符串参数 str
//        并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
public class Test0108 {

        public static void main(String[] args) {
            System.out.println(isValid("]"));
        }
        public String toLowerCase(String str){
         StringBuffer sb=new StringBuffer();
         char temp;
                for (int i = 0; i <str.length() ; i++) {
                        temp=str.charAt(i);
                        if(temp>='A'&&temp<='Z'){
                                temp=(char)(temp+32);
                        }
                        sb.append(temp);
                }
                return sb.toString();
        }
        public int[] rotate(int[] nums, int k) {
                int len=nums.length;
                if(k>nums.length){
                     k%=len;
             }
                nums=new int[len*2];//原数组扩容
                //原来123456   k=3
                //现在123456000000
                //     123456123456
                for (int i = len; i <len; i++) {
                        nums[i]=nums[i+len];
                }
                int[]nums1=subInt(nums,len-k,2*len-k);
                return nums1;
        }
        private int[] subInt(int[]nums,int left,int right){
                int[] output=new int[right-left];
                int j=0;
                for (int i=left;i<right;i++){
                        output[j]=nums[i];
                        j++;
                }
                return output;
        }

    public static boolean isValid(String s) {//括号匹配
        Stack <Character>stack=new Stack();//用栈解决
        for (int i = 0; i <s.length() ; i++) {
            char c=s.charAt(i);
           //({[]})
            if(c=='('||
                    c=='{'||
                    c=='['){
                stack.push(c);
            }
            if(stack.isEmpty()){
                return false;
            }
            else {
                if(c==')'){
                    if(stack.peek()=='(')
                        stack.pop();
                    else
                        return false;
                }
                if(c=='}'){
                    if(stack.peek()=='{')
                        stack.pop();
                    else
                        return false;
                }
                if(c==']'){
                    if(stack.peek()=='[')
                        stack.pop();
                    else
                        return false;
                }
            }

        }
        return stack.isEmpty();

}
}
