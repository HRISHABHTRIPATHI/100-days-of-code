public class Main {
    public static int pIndex = 0;

    public static Node constructTree(int[] preorder, int data, int min, int max) {
        if (pIndex < preorder.length) {
            if (preorder[pIndex] > min && preorder[pIndex] < max) {
                Node root = new Node(data);
                pIndex++;
                if (pIndex < preorder.length) {
                    // nodes lies between min and data will create left subtree
                    root.left = constructTree(preorder, preorder[pIndex], min,
                            data);
                    // nodes lies between data and max will create right subtree
                    root.right = constructTree(preorder, preorder[pIndex],
                            data, max);
                }
                return root;
            }
        }
        return null;
    }

    public static void displayTree(Node root) {
        if (root != null) {
            displayTree(root.left);
            System.out.print(" " + root.data);
            displayTree(root.right);
        }
    }

    public static void main(String args[]) {
        int[] preOrder = { 20, 10, 5, 1, 7, 15, 30, 25, 35, 32, 40 };
        Node root = constructTree(preOrder, preOrder[0], Integer.MIN_VALUE,
                Integer.MAX_VALUE);
        System.out.println("Inorder Traversal of Constructed Tree : ");
        displayTree(root);
    }
}

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }
}