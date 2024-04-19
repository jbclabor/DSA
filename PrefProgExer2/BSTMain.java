package PrefProgExer2;
import java.util.*;
import java.io.*;

public class BSTMain {
    
    public static void main(String[] args) throws FileNotFoundException {
        
        // File path to read input from
        String filepath = "C:\\Users\\DELL\\Documents\\NetBeansProjects\\Prefinals\\src\\PrefProgExer2\\bst.txt";
        Scanner file = new Scanner(new File(filepath));

        // Create a new BST
        BST bst = new BST();

        // Insert numbers from file into BST
        while (file.hasNextInt()) {
            int number = file.nextInt();
            bst.insert(number);
        }
        
        // Display the height of the BST
        bst.showHeight();
        
        // Display the number of leaves in the tree
        System.out.println("Number of leaves in the tree: "+ bst.postorder());
        
        // Display the count of non-terminal nodes in the tree
        bst.displayNonTerminalCount();
        
        // Display the Internal Path Length (IPL) of the tree
        bst.showIPL();
        
        // Display the average depth of the tree
        bst.showAverageDepth();
    }
}
