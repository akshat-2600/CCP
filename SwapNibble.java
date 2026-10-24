import java.util.Scanner;

public class SwapNibble {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();
        
        // Isolate, shift, and combine the lower and upper 4 bits
        int swapnum = ((num & 0x0F) << 4) | ((num & 0xF0) >> 4);
        // 0x0F -> 0000 1111
        // 0xF0 -> 1111 0000
        
        System.out.println("Before swapping the nibble: " + num);
        System.out.println("After swapping the nibble: " + swapnum);
        
        scanner.close();
    }
}
