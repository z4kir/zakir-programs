import java.util.*;
import java.lang.*;


class Relation {

    public int MomDadLsisLbro(int age) {
        if (age < 25) {
            Random random = new Random();
            int rand = random.nextInt(2) + 3;
            return rand;
        } else {
            Random random = new Random();
            int rand = random.nextInt(3) + 2;
            return rand;

        }
    }


    public void Loveprint(String b2, String b, int n) {
        String a[] = new String[5];
        a[0] = "No love";
        a[1] = "weak love";
        a[2] = "average love";
        a[3] = "Strong love";
        a[4] = "One of the most lovable person";
        Scanner z2 = new Scanner(System.in);
        if (b2.equals("mom") || b2.equals("dad")) {
            if (n == 4) {
                System.out.println("\nyour(" + b + ") " + b2 + " is " + a[n] + " in your life\n");
            } else {
                System.out.println("\n" + a[n] + " between you(" + b + ") and your " + b2 + "\n");
            }

        } else {
            System.out.println("enter your " + b2 + " name");
            String b3 = z2.nextLine();
            if (n == 4) {
                System.out.println("\nyour(" + b + ") " + b2 + b3 + " is " + a[n] + " in your life\n");
            } else {
                System.out.println("\n" + a[n] + " between you(" + b + ") and your " + b2 + " " + b3 + "\n");
            }
        }


        z2.close();
    }
}


public class Lovescale {
    public static void main(String[] args) {


        Scanner z = new Scanner(System.in);
        Scanner z1 = new Scanner(System.in);

        System.out.print("insert your;\nname:");
        String b = z.nextLine();
        System.out.print("\nage:");
        int b1 = z.nextInt();
        System.out.println("\nFor relation write one of the following as it is;\n{mom ,dad ,grandpa ,grandma ,granddaughter ,grandson ,uncle ,aunty ,daughter ,son ,wife ,husband,\ncousin ,little brother ,big brother ,little sister ,big sister ,friend ,bestfriend,\nclosefriend(it includes girlfriend and boyfriend) ,person(it refres to the person you met one or two time) ,enemy}");

        System.out.println("\nEnter relation between you and the person you want to check for love:");
        Relation relation = new Relation();
        int n = relation.MomDadLsisLbro(b1);
        String b2 = z1.nextLine();

        switch (b2) {
            case "mom":
                relation.Loveprint(b2, b, n);
                break;

            case "dad":
                relation.Loveprint(b2, b, n);
                break;

            case "little sister":
                relation.Loveprint(b2, b, n);
                break;

            case "little brother":
                relation.Loveprint(b2, b, n);
                // System.out.println("enter your little brother name");
                // String b3=z.nextLine();
                // if(relation.MomDadLsisLbro(b1)==5){
                // System.out.println("your("+b+")" +b2+" "+a[relation.MomDadLsisLbro(b1)]+"in your life");
                // }
                // else{
                //     System.out.println(a[relation.MomDadLsisLbro(b1)]+"between you("+b+") and yo");
                // }
                break;


            default:
                System.out.println("please enter relation as it is as explained above");
                break;
        }


        // Relation relation=new Relation();
        // System.out.println(a[relation.MomDadLsisLbro(b1)]);


        // if (!b2.equalsIgnoreCase("mom")) {
        // System.out.println("\nEnter name of the person you want to check for love:");
        // String b3=z.nextLine();
        // }
        // else{if (!b2.equalsIgnoreCase("dad")) {

        //     System.out.println("\nEnter nname of the person you want to check for love:");
        // String b3=z.nextLine();
        // }

        // }
        z.close();
        z1.close();

    }

}
