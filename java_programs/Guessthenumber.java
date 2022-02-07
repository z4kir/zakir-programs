package games;

import java.util.*;
import java.lang.*;


class Guessnumber {

    private int noOfGuesses = 0;
    private int rand;
    private int input;

    Guessnumber() {
        Random random = new Random();
        this.rand = random.nextInt(100);
        // return random.nextInt(100);
    }

    public void takeUserInput() {
        Scanner userinput = new Scanner(System.in);
        this.input = userinput.nextInt();

    }

    public boolean correctNumber() {
        if (rand == input) {
            return true;
        } else {
            if (rand < input) {
                System.out.println("your number is greater than random number");
            }
            if (rand > input) {
                System.out.println("your number is less than random number");
            }
            return false;
        }

    }

    public int getnoOfGussses() {
        return noOfGuesses;
    }

    public void setnoOfGussses() {
        this.noOfGuesses++;
    }


}


public class Guessthenumber {
    public static void main(String[] args) {
        boolean c;
        // int s=0;
        Guessnumber guessnumber = new Guessnumber();
        do {
            System.out.println("enter your no:");
            guessnumber.takeUserInput();
            guessnumber.setnoOfGussses();
            c = guessnumber.correctNumber();
        } while (!c);
        System.out.println("Total no. of gusses: " + guessnumber.getnoOfGussses());
        // userinput.close(); 

    }


}

