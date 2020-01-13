package Day3;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Test0113 {
    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        System.out.println("输入haystack");
//        String haystack=scanner.next();
//        System.out.println("输入needle");
//        String needle=scanner.next();
//        System.out.println(strStr(haystack,needle));

    }
    public static int strStr(String haystack, String needle) {
        if(needle==null&&haystack!=null){
            return 0;
        }
        for (int i = 0; i <haystack.length() ; i++) {
            char a=haystack.charAt(i);
            for (int j = 0; j <needle.length() ; j++) {
                char c=needle.charAt(0);
                if(a==c){
                    String tmp=haystack.substring(i,i+needle.length());
                    if(tmp.equals(needle)){
                        return i;
                    }
                    return -1;
                }
            }

        }
        return -1;

    }
    public int divide(int dividend, int divisor) {
        if(dividend==0){
            return 0;
        }
        if(dividend==Integer.MIN_VALUE&&divisor==-1){
            return Integer.MAX_VALUE;
        }
        int flag=-1;
        if(dividend>0&&divisor>0||dividend<0&&divisor<0){
            flag=1;
        }
        long a=Math.abs((long) dividend);
        long b=Math.abs((long)divisor);
  return flag*getPos(a,b);


    }
    private  int getPos(long a,long b){
        if(a<b){
            return 0;
        }
        int count=1;
        long tmp=b;
        while (a>b<<1){
            b=b<<1;
            count=count<<1;
        }
        return  count+getPos(a-b,tmp);

    }
    public void nextPermutation(int[] nums) {
        /*
        * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。

如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

必须原地修改，只允许使用额外常数空间。

以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
先判断这个排列是否存在更大的排列，不存在，逆序输出
存在，
* */
        if(isBiggestSore(nums)!=null) {
              swap(nums,isBiggestSore(nums),isBiggestSore(nums)+1);
        }else {
            reverse(nums);
        }


    }
    private  Integer isBiggestSore(int[]nums){
        for (int i = 0; i <nums.length ; i++) {


            return i;
        }
        return null;

    }
    private  void swap(int[]nums,int left,int right){
        int tmp;
        tmp=  nums[left];
        nums[left]=nums[right];
        nums[right]=tmp;

    }
    private  void reverse(int[]nums){
        int left=0;
        int right=nums.length;
         while (left<right){
             int tmp;
          tmp=  nums[left];
          nums[left]=nums[right];
          nums[right]=tmp;
          left++;
          right--;
         }
    }
    public int longestValidParentheses(String s) {
        //给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
        //思路：寻找匹配的子串

        int maxLength=0;//(()(())))
        for (int i = 0; i <s.length() ; i++) {
            for (int j = i+2; j <s.length() ; j+=2) {
                if(isVaild(s.substring(i,j))){
                    maxLength=Math.max(maxLength,j-i);
                }

            }

        }
        return  maxLength;


        }
        private boolean isVaild(String s){
        Stack<Character> stack =new Stack<Character>();
            for (int i = 0; i <s.length() ; i++) {
                if(s.charAt(i)=='('){
                    stack.push('(');
                }else if(!stack.empty()&&stack.peek()=='('){
                    stack.pop();
                }else {
                    return false;
                }

            }
            return stack.isEmpty();
    }
}




