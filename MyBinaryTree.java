package Day4;
class TreeNode{
    public char val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode (char val){
        this.val=val;
    }

}
public class MyBinaryTree {
    private static TreeNode root=null;
    public static void  preOrder(TreeNode root){ //根 左子树 右子树
        if(root==null){
            return;
        }
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void inOrder(TreeNode root){//左子树 根 右子树
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }
    public  static  void postOrder(TreeNode root){//左子树 右子树 根
        if(root==null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val);
        }
        public  static int LeafCount(TreeNode root){
        if(root==null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            return 1;
        }
        return LeafCount(root.right)+LeafCount(root.left);

        }
        public  static int size(TreeNode  root){
        if(root==null){
            return 0;
        }
        return 1+size(root.left)+size(root.right);
        }
        public static int getKLevelCount(TreeNode root,int k){
        if(root==null||k<1){
            return 0;
        }
        if(k==1){
            return 1;
        }
        return getKLevelCount(root.left,k-1)+getKLevelCount(root.right,k-1);

        }





}
