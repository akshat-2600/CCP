// T.C : O(n)
// S.C : O(1)

class Move_Hypen_To_Begining {
    static void moveSpaceInFront(char str[]) {
        // Traverse from end and swap hyphens
        int i = str.length - 1;
        for (int j = i; j >= 0; j--) {
            if (str[j] != '-') {
                char c = str[i];
                str[i] = str[j];
                str[j] = c;
                i--;
            }
        }
    }

    public static void main(String[] args) {
        char str[] = "Code- 4 -lyf".toCharArray();
        moveSpaceInFront(str);
        System.out.println(String.valueOf(str));
    }
}

// -----------------------------------------------------------------------------------

class EthCode {

    static void moveSpaceInFront(char str[]) {
        // Keep copying non-space characters
        int i = str.length - 1;

        for (int j = i; j >= 0; j--) {
            if (str[j] != ' ') {
                str[i--] = str[j];
            }
        }

        // Move spaces to the beginning
        while (i >= 0) {
            str[i--] = ' ';
        }
    }

    public static void main(String[] args) {
        char str[] = "Code- 4 -lyf".toCharArray();
        moveSpaceInFront(str);
        System.out.println(String.valueOf(str));
    }
}
