
//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int value) {
        data = value;
        left = null;
        right = null;
    }
}

class InorderPostorderToTree {
    public void preOrder(Node root) {
        if (root == null)
            return;

        System.out.print(root.data + " ");
        preOrder(root.left);

        preOrder(root.right);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        InorderPostorderToTree ip = new InorderPostorderToTree();
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int inorder[] = new int[n];
            int postorder[] = new int[n];
            for (int i = 0; i < n; i++)
                inorder[i] = sc.nextInt();
            for (int i = 0; i < n; i++)
                postorder[i] = sc.nextInt();
            GfG g = new GfG();
            Node root = g.buildTree(inorder, postorder, n);
            ip.preOrder(root);
            System.out.println();

            T--;
        }
    }
}

// } Driver Code Ends

/*
 * Tree node structure
 * class Node
 * {
 * int data;
 * Node left;
 * Node right;
 * 
 * Node(int value)
 * {
 * data = value;
 * left = null;
 * right = null;
 * }
 * }
 */

class GfG {
    // Function to return a tree created from postorder and inoreder traversals.
    Node buildTree(int in[], int post[], int n) {
        // Your code here
        Node ptr = new Node(-1);
        if (n == 0) {
            return null;
        } else if (n == 1) {
            ptr.data = in[0];
            return ptr;
        } else {
            int k = post[n - 1];
            int i = 0;
            while (k != in[i]) {
                i++;
            }
            int g = i;
            int j = 0;
            int arr1[] = new int[i];
            int arr2[] = new int[n - i - 1];
            int arr3[] = new int[i];
            int arr4[] = new int[n - i - 1];
            for (j = 0; j < i; j++) {
                arr1[j] = in[j];
                arr3[j] = post[j];
            }

            j = j + 1;
            i = 0;
            while (j < n) {
                arr2[i] = in[j];
                arr4[i] = post[j - 1];
                j++;
                i++;
            }

            ptr.data = post[n - 1];
            ptr.left = buildTree(arr1, arr3, g);
            ptr.right = buildTree(arr2, arr4, n - g - 1);
            return ptr;
        }
    }
}
