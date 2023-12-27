package hw6;

public class LineCenter {
    public static void main(String[] args) {
        String s = "qwerty";
        int stringLength = s.length();
        int middle = stringLength / 2;
        char c = s.charAt(middle);
        char d = s.charAt(middle - 1);
        System.out.println(d + String.valueOf(c));
    }
}
