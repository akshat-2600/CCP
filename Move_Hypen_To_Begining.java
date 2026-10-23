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
        char str[] = "sys-log-v3-err".toCharArray();
        moveSpaceInFront(str);
        System.out.println(String.valueOf(str));
    }
}

