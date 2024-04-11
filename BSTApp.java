package binary;
import java.util.Scanner;

public class BSTApp {
    public static void main(String[] args) {
        IntBST bst = new IntBST();
        Scanner in = new Scanner(System.in);
        int temp;
        
        System.out.print("Integer: ");
        temp = in.nextInt();
        
        while (temp > 0) {
            bst.insert(temp);
            System.out.print("Integer: ");
            temp = in.nextInt();
        }
        
        System.out.print("Search: ");    
        temp = in.nextInt();
        
        IntBSTNode tempNode = bst.search(temp);
        if (tempNode == null)
            System.out.println("Not Found");
        else
            System.out.println("Present");
    }    
}
