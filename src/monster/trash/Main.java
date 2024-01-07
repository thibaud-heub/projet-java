package monster.trash;

public class Main {

    public static void main(String[] args)    
    {
        TreeNode root = new TreeNode();
        for (int i = 0; i<19; i++)
        {
            new TreeNode(root);
            System.out.println("fge");
        }

        root.treePrint();
        root.search(19);
    }
}
