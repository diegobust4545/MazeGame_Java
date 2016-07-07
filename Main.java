package com.company;
import java.io.*;
import java.util.Scanner;


/**
 * Created by DiegoB on 9/13/15.
 * This main class tests the Gameboard and Room class

 */

public class Main {

    public static void main(String[] args) {
        try {
            Scanner scan = new Scanner(System.in);
            Gameboard game = new Gameboard();
            game.greeting();
            game.drawBoard();
            game.playGameBord();
            while (game.play()) {
                game.Path();
                System.out.println("\n" + "How will you like to move? (U,D,L,R,S,G)");
                String shot = scan.nextLine();
                game.move(shot);
                game.playGameBord();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
