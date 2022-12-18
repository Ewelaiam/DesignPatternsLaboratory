package pl.edu.agh.dp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("*****\t Finite State Machine\t*****");
        System.out.println("Enter the word:");
        String word = scanner.nextLine();

        FiniteStateMachine finiteStateMachine = new FiniteStateMachine();
        System.out.println("Accepted:\t" + finiteStateMachine.isWordAccepted(word));
    }
}
