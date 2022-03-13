package java;


public class Exercise1 {

    public static void main(String[] args) {
        int n = 100;
        if (args.length > 0) {
            try {
                n = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(e);
            }
        }
    }
}
