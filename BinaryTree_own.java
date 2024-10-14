
   import java.util.Queue;
   import java.util.LinkedList;
   import java.util.*;
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
    class BinaryTree
    {
         int count =0;
         int sum = 0;
         int idx = -1;
        int c = -1;
        public Node buildTree(int nodes[])
        {
            idx++;
            if(nodes[idx] ==-1){
                return null;
            }

            Node newNode = new Node(nodes[idx]); 
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
        public void preorder(Node root)
        {
            if(root == null){
                return;
            }
            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);
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
        public void postorder(Node root)
        {
            if(root == null){
                return;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data+" ");
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
        public void countNode(Node root)
        {
            if(root == null)
            {
                return;
            }
           
            count++;
            
            countNode(root.left);
            countNode(root.right);
        }
        public void SumofNode(Node root)
        {
            if(root == null)
            {
                return;
            }
           
            sum+=root.data;
            
            SumofNode(root.left);
            SumofNode(root.right);
        }
        public int countofNode(Node root)
        {
            if(root == null)
            {
                return 0;
            }
            if(root.left==null && root.right==null)
            {
                return 1;
            }
            int nL=countofNode(root.left);
            int nR=countofNode(root.right);
            return nL+nR+1;
        }
        public int HeightofTree(Node root)
        {
            if(root == null)
            {
                return 0;
            }
            
            
            int hL=HeightofTree(root.left);
            int hR=HeightofTree(root.right);
            if(hL>hR)
            {
                return hL+1;
            }
            else
            {
                return hR+1;
            }      
        }
        public int DiameterOfTree(Node root)
        {
           
            if(root==null)
            {
                return 0;
            }
           
            int nL=DiameterOfTree(root.left);
            int nR=DiameterOfTree(root.right);

            int diameter=HeightofTree(root.left)+HeightofTree(root.right) + 1;

            return Math.max(diameter, Math.max(nL,nR));
        }
        public TreeInfo diameter2(Node root)
        {
            if(root==null)
            {
                return new TreeInfo(0, 0);
            }
            TreeInfo lt = diameter2(root.left);
            TreeInfo rt = diameter2(root.right);

            int myHeight = Math.max(lt.ht, rt.ht) + 1;

            int diam1 = lt.diam;
            int diam2 = rt.diam;
            int diam3 = lt.ht + rt.ht + 1;

            int mydiam = Math.max(Math.max(diam1, diam2),diam3);

            TreeInfo myInfo = new TreeInfo(myHeight, mydiam);

            return myInfo;
        }
        public boolean isIdentical(Node root, Node subRoot)
        {
            if(root == null && subRoot == null)
            {
                return true;
            }
            if(root == null || subRoot == null)
            {
                return false;
            }
            if(root.data == subRoot.data)
            {
                return (isIdentical(root.left, subRoot.left) && isIdentical(root.right,subRoot.right));
            }
            return false;
        }
        public boolean isSubtree(Node root, Node subRoot)
        {
            if(subRoot==null)
            {
                return true;
            }
            if(root == null)
            {
                return false;
            }
            if(root.data==subRoot.data)
            {
                if(isIdentical(root,subRoot))
                {
                    return true;
                }
            }
            return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
           
        }
    }
    class TreeInfo{
        int ht;
        int diam;

        TreeInfo(int ht, int diam)
        {
            this.ht = ht;
            this.diam = diam;
        }
    }
    class Demo
    {
        public static void main(String[] args)
        {
            int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
            int sNodes[]={2,4,-1,-1,5,-1,-1};
            BinaryTree tree = new BinaryTree();
            BinaryTree tree2 = new BinaryTree();
            Node root = tree.buildTree(nodes);
           // tree.idx = -1;
            Node sRoot = tree2.buildTree(sNodes);
            tree.countNode(root);
            tree.SumofNode(root);
            tree.HeightofTree(root); 
            System.out.println(root.data);
            System.out.println("The preorder traversal is: ");
            tree.preorder(root);
            System.out.println();
            System.out.println("The inorder traversal is: ");
            tree.inorder(root);
            System.out.println();
            System.out.println("The postorder traversal is: ");
            tree.postorder(root);
            System.out.println();
            System.out.println("The levelorder traversal is: ");
            tree.levelorder(root);
            System.out.println("No of nodes in the tree is: "+tree.count);
            System.out.println("No of nodes in the tree(By second method) is: "+tree.countofNode(root));
            System.out.println("The sum of nodes is: "+tree.sum);
            System.out.println("The height of the tree: "+tree.HeightofTree(root));
            System.out.println("The diameter of the tree: "+tree.DiameterOfTree(root));
            System.out.println("The diameter of the tree from function2 is: "+tree.diameter2(root).diam);
            System.out.println("The subtree(2,4,-1,-1,5,-1,-1) is existing:  "+tree.isSubtree(root,sRoot));
        }
    }