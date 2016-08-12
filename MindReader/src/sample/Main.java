package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Scanner;

public class Main{

    /**
     * Mind Reader - Human vs CPU
     *
     * Creates prompts for game
     * Game uses a linked list (ResponseBuffer) to hold previous patterns of human coin flips
     * Stores each unique pattern of a set length (currently 4) in a HashMap
     * Searches based off of the current string of flip choices that is at the set length in the HashMap
     * First one to 10 wins
     *
     * @param args
     */
    public static void main(String[] args) {
        MindReader game = new MindReader (4);//int sets the maximum size of the linked list
        Scanner scan = new Scanner(System.in);
        char guess;//human choice
        int computerScore=0;
        int playerScore=0;
        char computerGuess;


        System.out.println("WELCOME TO MINDREADER!!!!!!!!");
        System.out.println("*****************************");
    while(computerScore<15 && playerScore<15) {
            System.out.println("I've made my prediction about what you will enter.");
            System.out.println("Enter 'h' or 't':");//Ask human for guess
            computerGuess = game.MakeGuess();//generates computer guess based off of HashMap
            guess = scan.nextLine().charAt(0);
        if (computerGuess == guess) {//computer guesses right so it gets a point
            System.out.println("I was right, take that");
            computerScore++;
     } else {//computer guesses wrong so human gains a point
            System.out.println("Dang I was wrong");
            playerScore++;
    }
    game.update(guess);
        System.out.println(game.fun);
        System.out.println("Computer Score: " + computerScore);
        System.out.println("Player Score: " + playerScore);
}
        if(computerScore>playerScore){
            System.out.println("I WIN");
        }else{
            System.out.println("Good job you win");
        }
    }
}
