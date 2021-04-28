/*
BinarySearchTree BST
space    - O(n)
insert   - O(lg n)
search   - O(lg n)
traverse - O(n)
*/
public class BinarySearchTree {
    public class Node{
        int data;
        Node left;
        Node right;

        public Node(int value){
            data = value;
            left = null;
            right = null;
        }
    }
    Node root;

    public static void traversePreorder(Node node){
        if(node != null){
            System.out.println(node.data);
            traversePreorder(node.left);
            traversePreorder(node.right);
        }
    }

    public static void traverseInorder(Node node){
        if(node != null){
            traverseInorder(node.left);
            System.out.println(node.data);
            traverseInorder(node.right);
        }
    }

    public static void traversePostorder(Node node){
        if(node != null){
            traversePostorder(node.left);
            traversePostorder(node.right);
            System.out.println(node.data);
        }
    }

    public void insert(int data){
        root = insert(root, data);
    } 
    private Node insert(Node root, int data){

        if(root == null){
            root = new Node(data);
            return root;
        }

        if(data < root.data){
            root.left = insert(root.left, data);
   
        }
        else{
            root.right = insert(root.right, data);          
        }

        return root;
    }

    public boolean search(int data){
        return search(root, data);
    }
    private boolean search(Node root, int data){
        if(root == null)
            return false;
        
        if(root.data == data)
            return true;

        boolean ret = false;
        
        if(data  < root.data)
            ret = search(root.left, data);
        else
            ret = search(root.right, data);
        
        return ret;
        }

    public void delete(int data){
        
    }
}
