import java.util.Scanner;

class level {
    public static void main(String... args) {
        String c;
        int level = 0;
        System.out.println("enter your difficuilty as expert,begginer or intermediate");
        Scanner s = new Scanner(System.in);
        c = s.nextLine();
        switch (c) {
            case "begginer":
                level = 1;
                break;
            case "intermediate":
                level = 2;
                break;
            case "expert":
                level = 3;
                break;
            default:
                level = 0;
                break;
        }
        System.out.println("your level is " + level);
    }
}