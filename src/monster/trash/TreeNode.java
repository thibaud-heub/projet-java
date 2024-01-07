package monster.trash;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    private static int lastID = 0;

    private int id;
    private TreeNode left; 
    private TreeNode right;
    //TreeNode node3;

    private TreeNode parent;

    public TreeNode(TreeNode parent){
        this.id = ++lastID;
        this.left = null;
        this.right = null;
        this.parent = parent;

        if(parent!= null)
        {
            if(parent.getLeft() == null) parent.setLeft(this);
            else parent.setRight(this);
        }
    }

    public TreeNode ()
    {
        this(null);
    }


    public void addNode(TreeNode node, int nodeID)
    {

    }

    public void setLeft(TreeNode node)
    {
        this.left = node;
    }

    public void setRight(TreeNode node)
    {
        this.right = node;
    }

    public int getID()
    {
        return this.id;
    }
    
    public TreeNode getParent()
    {
        return this.parent;
    }

    public TreeNode getLeft()
    {
        return this.left;
    }

    public TreeNode getRigt()
    {
        return this.right;
    }
    
    public void nodePrint(){
        System.out.println("\nID : " + this.id);
        
        int parent = (this.parent != null ? this.parent.getID() : -1);
        System.out.println("Parent : " + parent);

        int left = (this.left != null ? this.left.getID() : -1);
        System.out.println("Left : " + left);

        int right = (this.right != null ? this.right.getID() : -1);
        System.out.println("Right : " + right);
        

    }

    public void treePrint(){

        if(this != null) 
        {
            this.nodePrint();

            if (this.left != null) this.left.treePrint();
            if (this.right != null) this.right.treePrint();
        }
    }

    public TreeNode search (int targetID)
    {
        if(this == null || this.getID() == targetID) return this;
        
        TreeNode leftResult = ((left != null) ? left.search(targetID) : null);
        if(left != null) return leftResult;
        
        return right != null ? right.search(targetID) : null;
    
    }
    
    public TreeNode createTree(int nb){

        TreeNode root = new TreeNode();

        for(int i = 0; i<nb; i ++)
        {
            TreeNode node 
        }
    }

    public TreeNode BFS (TreeNode root)
    {
        Queue<TreeNode> queue = new LinkedList<>();

    }



    }
}
