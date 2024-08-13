class Node {
    int val;
    Node left, right;

    Node(int item) {
        val = item;
        left = right = null;
    }
}

public class LargestPerfectSubtree {

    static class Result {
        boolean isPerfect;
        int size;

        Result(boolean isPerfect, int size) {
            this.isPerfect = isPerfect;
            this.size = size;
        }
    }

    // Helper function to check if a tree is perfect and to get its size
    static Result isPerfectAndSize(Node root) {
        if (root == null) {
            return new Result(true, 0);
        }

        Result leftResult = isPerfectAndSize(root.left);
        Result rightResult = isPerfectAndSize(root.right);

        if (leftResult.isPerfect && rightResult.isPerfect &&
                ((root.left != null && root.right != null) || (root.left == null && root.right == null))) {
            return new Result(true, leftResult.size + rightResult.size + 1);
        }

        return new Result(false, Math.max(leftResult.size, rightResult.size));
    }

    // Function to find the size of the largest perfect subtree
    static int largestPerfectSubtree(Node root) {
        Result result = isPerfectAndSize(root);
        return result.size;
    }

    // Function to insert nodes in level order (for testing purposes)
    static Node insertLevelOrder(int[] arr, Node root, int i) {
        if (i < arr.length) {
            Node temp = new Node(arr[i]);
            root = temp;

            root.left = insertLevelOrder(arr, root.left, 2 * i + 1);
            root.right = insertLevelOrder(arr, root.right, 2 * i + 2);
        }
        return root;
    }

    // Driver program to test above function
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6,9,2,5,7,1,7,5,45,3,756,78,35};
        Node root = insertLevelOrder(arr, null, 0);
        System.out.println("Size of the largest perfect subtree is: " + largestPerfectSubtree(root));
    }
}