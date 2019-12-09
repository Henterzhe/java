import org.omg.CORBA.TRANSACTION_MODE;

import java.util.*;


public class MyTreeNode {
    static class  TreeNode{
        public  int val;
        public  TreeNode left;
        public  TreeNode right;
        TreeNode(int val){
            this.val=val;
        }
        private List<List<Integer>>result=new ArrayList<>();//用一个result保存
        public  List<List<Integer>> levelOrder(TreeNode root){
            //层序遍历
            if(root==null){
                return result;
            }
            helper(root,0);
            return result;
        }
        private  void helper(TreeNode root,int level){
            if(level==result.size()){
                //扩容
                result.add(new ArrayList<>(0));
            }
            result.get(level).add(root.val);
            if(root.left!=null){
                helper(root.left,level+1);
            }else {
                helper(root.right,level+1);
            }
        }
        private  TreeNode cal=null;//用来保存公共祖先
        public TreeNode lowestCommonAncetor(TreeNode root,TreeNode p,TreeNode q){
            //最近公共祖先
            if(root==null){
                return null;
            }
            findNode(root,p,q);
            return cal;
        }
        public boolean findNode(TreeNode root,TreeNode p,TreeNode q){
            if(root==null) {
                return false;
            }
            int left=findNode(root.left,p,q)?1:0;
            int right=findNode(root.right,p,q)?1:0;
            int mid=(root==p||root==q)?1:0;
            if(left+right+mid>=2){
                cal=root;
            }
            return (left+right+mid)>0;
        }
        public void preOrder(TreeNode root){
            //前序遍历
            preOrder(root.left);
            System.out.println(root.val);
            preOrder(root.right);
        }
        public  void preOrder2(TreeNode root){
            Stack<TreeNode> stack=new Stack<>();
            if(root==null){
                return;
            }
            stack.push(root);
            while (!stack.isEmpty()){
                TreeNode cur=stack.pop();
                System.out.println(cur.val);
                //先判断右子树 在判断左子树
                if(cur.right!=null){
                    stack.push(cur.right);
                }
                if(cur.left!=null){
                    stack.push(cur.left);
                }
            }
        }
        public void inOrder(TreeNode root){
            inOrder(root.left);
            System.out.println(root.val);
            inOrder(root.right);
        }
        public void inOrder2(TreeNode root){
            if(root==null){
                return;
            }
            Stack<TreeNode> stack=new Stack<>();
            TreeNode cur=root;
            while (true){
                if(cur!=null){
                    stack.push(cur);
                    cur=cur.left;
                }
                if(stack.isEmpty()){
                    break;
                }
                TreeNode top=stack.pop();
                System.out.println(top.val);
                cur=top.right;
            }
            return;
        }
        public void postOrder(TreeNode root){
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.val);
        }
        public void popstOrder2(TreeNode root){
            if(root==null){
                return;
            }
            Stack<TreeNode> stack=new Stack<>();
            TreeNode cur=root;
            TreeNode prev=null;
            while (true){
                if(cur!=null){
                    stack.push(cur);
                    cur=cur.left;
                }
                if(stack.isEmpty()){
                    break;
                }
                TreeNode top= stack.peek();
                if(cur.right==null||prev==top.right){
                    System.out.println(top.val);
                    stack.pop();
                    prev=top.right;
                }else {
                    cur=top.right;
                }
            }



        }
        public boolean isCompelete(TreeNode root){
            Queue<TreeNode>queue=new ArrayList<>();
            queue.offer(root);
            boolean flag=false;
            while (!queue.isEmpty()){
                TreeNode curNode=queue.poll();
                if(curNode==null){
                    flag=true;
                    continue;
                }
                if(flag){
                    return  false;

                }
                queue.offer(curNode.left);
                queue.offer(curNode.right);
            }
        }
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> result=new ArrayList<>();
            if(root==null){
                return result;
            }
            result.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
            return result;

        }
    }
}

