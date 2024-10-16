import java.util.Queue;
import java.util.LinkedList;
import java.util.*;
import java.util.ArrayList;
class Node
{
    int data;
    Node left;
    Node right;
    public Node(int data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
class BinarySearchTree
{
    ArrayList<Integer> Elem = new ArrayList<Integer>();
    public Node insert(Node root,int val)
    {
        if(root == null)
        {
            root= new Node(val);
            return root;
        }
        if(root.data > val)
        {
            //left subtree
            root.left = insert(root.left,val);
        }
        else
        {
            //right subtree
            root.right = insert(root.right,val);
        }
        return root;
    }
    public void inorder(Node root)
    {
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public boolean searchKey(Node root,int val)
    {
        if(root == null)
        {
            return false;
        }
        if(root.data == val)
        {
            return true;
        }
        if(root.data > val)
        {
            return searchKey(root.left,val);
        }
        else
        {
            return searchKey(root.right,val);
        }
    }
    public Node deleteNode(Node root,int val)
    {
        if(root.data > val)
        {
            root.left = deleteNode(root.left,val);
        }
        else if(root.data < val)
        {
            root.right = deleteNode(root.right,val);
        }
        else  // if(root.data == val)
        {
            // case 1: leaf node
            if(root.left == null && root.right == null) 
            {
                return null;
            }
            // case 2: one child
            if(root.left == null)
            {
                return root.right;
            }
            else if(root.right == null)
            {
                return root.left;
            }

            //case 3: two children 
            Node IS = inorderSuccessor(root.right);
            root.data = IS.data;
            root.right = deleteNode(root.right, IS.data);
        }
        return root;
    }
    public Node inorderSuccessor(Node root)
    {
        while(root.left != null)
        {
            root = root.left;
        }
        return root;
    }
    public void levelorder(Node root)
        {
             if(root == null){
                return;
             }
             Queue<Node> q = new LinkedList<>();
             q.add(root);
             q.add(null);

             while(!q.isEmpty()){
                Node currNode = q.remove();
                if(currNode == null)
                {
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }
                    else{
                        q.add(null);
                    }

                }
                else
                {
                    System.out.print(currNode.data+" ");
                    if(currNode.left !=null)
                    {
                        q.add(currNode.left);
                    }
                    if(currNode.right !=null)
                    {
                        q.add(currNode.right);
                    }
                }
             }
        }
        public void printInrange(Node root,int x, int y)
        {
            int flag = 0;
            System.out.print("The elements which exists in the tree are : ");
            for(int i = x; i<=y;i++)
            {
               
                if(searchKey(root,i))
                {
                    flag++;
                    System.out.print(i+" ");
                }
               
            }
             if(flag==0)
            {
                System.out.print("None");

            }
            System.out.println();
        }
        public void printInrange2(Node root,int x,int y)
        {
            if(root == null)
            {
                return;
            }
            
            if(x<= root.data && y>=root.data)
            {
                System.out.print(root.data+" ");
            }
            if(x<= root.data && y>root.data)
            {
                printInrange2(root.left,x,y);
                printInrange2(root.right,x,y);
            }
            else if(x>root.data)
            {
                printInrange2(root.right,x,y);
            }
            else
            {
                printInrange2(root.left,x,y);
            }
            
            
        }
        public void rootToLeafPath(Node root)
        {
             
            Elem.add(root.data);
            
            if(root.left == null && root.right == null)
            {
              System.out.println();
                for(int i:Elem)
                {
                    System.out.print(i+" ");
                }
                if(Elem.size() != 0)
                {
                Elem.remove(Elem.size()-1);
                }

                
                return;
            }
           
            //System.out.println();
            if(root.left != null)
            {
                rootToLeafPath(root.left);
               

            }
            if(root.right != null)
            {
                rootToLeafPath(root.right);
                
            }
            if(Elem.size() != 0)
            {
            Elem.remove(Elem.size()-1);
            }  
            

            
            
        }
}
class Demo
{
    public static void main(String[] args)
    {
        int values[] = {8,5,3,1,4,6,10,11,14};
        Node root = null;
        BinarySearchTree tree = new BinarySearchTree();
        for(int i:values)
        {
            root = tree.insert(root,i);
        }
        System.out.print("Inorder traversal is: ");
        tree.inorder(root);
        System.out.println();
        System.out.println("Levelorder traversal is: ");
        tree.levelorder(root);
        System.out.println();
        System.out.println("The node 4 exists in the tree is: "+tree.searchKey(root,4));
        tree.rootToLeafPath(root);
        tree.deleteNode(root,5);
        System.out.println();
        System.out.println("Levelorder traversal is: ");
        tree.levelorder(root);
        System.out.println();
        System.out.println("The node 5 exists in the tree is: "+tree.searchKey(root,5));
        tree.printInrange(root,6,10);
        System.out.print("Print in range by recursive function: ");
        tree.printInrange2(root,1,14);
        System.out.println();
        
    }
}