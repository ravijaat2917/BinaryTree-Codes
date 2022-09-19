import java.util.*;


/*
 * Sample Input : 
 * 5
 * 1 2 3 4 5
 */
class Node {
    int data;
    Node left, right;

    public Node(int value) {
        data = value;
        left = right = null;
    }
}

class BinaryTree {

    Node root;

    BinaryTree(){
        root = null;
    }

    // Method to construct a binary tree from the given array
    public Node insertNode(int[] elementsArr, Node node, int i){
        if(i < elementsArr.length){
            node = new Node(elementsArr[i]);

            node.left = insertNode(elementsArr,node.left,2 * i + 1);
            node.right = insertNode(elementsArr,node.right,2 * i + 2);
        }
        return node;
    }

    // Method to find the largest value in the tree
    
    public int findMax(Node node)
    {
        //Write your code here.
       Queue<Integer> queue = new LinkedList<>();

       int max = 0;

       if( node == null ){
        return -1;
       }

       queue.add(node.data);

       queue.add(findMax(node.left));
       queue.add(findMax(node.right));

       while( !queue.isEmpty() ){
        if(queue.peek() > max ){
            max = queue.remove();
        }else{
            queue.remove();
        }
       }
       return max;
}
// WARNING: Do not edit the code given below; otherwise the test cases might fail
public class printMaximumInBinaryTree{
    public static void main(String[] x){
        BinaryTree tree = new BinaryTree();

        int size;
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();

        if(size == 0){
            System.out.println("-1");
        }

        else if (size < 0){
            System.out.println("Size should be a positive integer");
        }

        else{
            int[] elementsArr = new int[size];
            for(int i = 0; i < size; i++){
                elementsArr[i] = sc.nextInt();
            }

            tree.root = tree.insertNode(elementsArr,tree.root,0);

            System.out.println(tree.findMax(tree.root));
            sc.close();
        }
    }
  }
}