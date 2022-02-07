
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * InnerFilehandling
 */
class InnerFilehandling {
    int a;
    String b;


}


public class Filehandling {
    public static void main(String[] args) throws IOException {
        int k = 19;
        String table = "";
        for (int i = 1; i <= 10; i++) {
            table += k + " X " + i + " = " + (i * k) + "\n";

        }
        File myfile = new File("table.txt");
        System.out.println(myfile.exists());
        myfile.createNewFile();

        // System.out.println(myfile.exists());
        PrintWriter p = new PrintWriter(new FileWriter("table.txt"));
        p.write(table);
        p.flush();


        // FileReader f=new FileReader("table.txt");
        // File myfile=new File("table.txt");
        Scanner sc = new Scanner(myfile);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            System.out.println(s);
        }
        sc.close();

        p.close();


    }


}
