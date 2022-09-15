package Model.Functions;

import java.util.Scanner;

public class Input {
    public static String inputString(String prompt){
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.print(prompt);
            String str = sc.nextLine().trim();
            if(str.isEmpty()){
                System.out.println("You enter nothing,try again!");
                System.out.print(prompt);
            } else {
                return str;
            }
        }
    }
    public static float inputScore(String prompt){
        Scanner sc = new Scanner(System.in);
        float score;
        do {
            System.out.print(prompt);
            while (!sc.hasNextFloat()){
                System.out.println("Invalid score, try again!");
                System.out.println(prompt);
                sc.next();
            }
            score = sc.nextFloat();
        } while ((score < 0 || score > 10));
        return score;
    }
    public static int getUserChoice(String prompt, int nOfChoices){
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.print(prompt);
            while (!sc.hasNextInt()) {
                System.out.println("Invalid input, try again!");
                System.out.print(prompt);
                sc.next();
            }
            choice = sc.nextInt();
        } while (choice < 0 || choice > nOfChoices);
        return choice;
    }
    public static String getUpOrRemove(String prompt){
        while (true){
            String character = inputString(prompt);
            if (character.equalsIgnoreCase("U") || character.equalsIgnoreCase("D")) {
                return character;
            } else {
                System.out.println("Invalid input, try again!");
            }
        }
    }
}
