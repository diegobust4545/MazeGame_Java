package com.company;

import java.io.*;
import java.util.Stack;

/**
 * This class implements the grid and allows the
 * user to move around
 * @author Diego Bustamante
 */

public class Gameboard {
    Room grid[][];
    private Integer x;
    private boolean play = true;
    private FileReader file = new FileReader("maze.txt");
    private BufferedReader input = new BufferedReader(file);
    private Stack <String> st = new Stack<String>();
    int j = 0;
    int y = 0;
    int rounds = 0;


    /**
     * This constructs the grid by reading the file
     * @throws IOException of the text file
     */
    public Gameboard() throws IOException{
        x = new Integer(input.readLine());
        grid = new Room[x][x];
    }


    /**
     * This method introduces the user to the game
     * and displays the direction and rules
     */
    public void greeting(){

        System.out.println("~ Welcome to the Maze Game ~ "+"\n" + "\n" + "Navigate your way through the maze to find the end point"
                + "\n" + "U = Up" + "\n"+"D = Down"+ "\n"+"R = Right"+ "\n"+"L = Left"+ "\n"+"S = Start Over" + "\n"+"G = Give Up"
                + "\n"+ "\n"+ "Good luck!" + "\n");
    }


    /**
     * This method sets the board up for the usr
     * @throws IOException of the text file
     */
    public void drawBoard() throws IOException {
        for (int r = 0; r < x; r++) {
            for (int c = 0; c < x; c++){
                String line = input.readLine();
                grid[r][c] = new Room();

                if(line.equals("2"))
                {
                    grid[r][c].setEndpoint(true);
                }

                else if(line.equals("1"))
                {
                    grid[r][c].setWall(true);
                }

                else
                {
                    grid[r][c].setSpace(true);
                }

                grid[r][c].setSymbol("?");

            }
        }
        grid[0][0].setSymbol("P");

    }


    /**
     * This method actually displays the Game board to the user
     */
    public void playGameBord() {
        System.out.print("     ");
        for (int i = 0;  i< x; i++){
            System.out.printf("%3s  ", i);
        }
        System.out.println();

        for(int r =0; r<x; r++) {
            System.out.printf("%3s  ", r);
            for (int c =0; c<x; c++) {
                System.out.printf("%3s  ", grid[r][c].getSymbol());
            }
            System.out.println();

        }

    }


    /**
     * This method allows the user to move
     * around the by sending their move to
     * @param moveDir allows the user to move
     * in which ever direction they choose
     **/
    public void move(String moveDir) throws IOException {
        String Upper = moveDir.toUpperCase();

        if (Upper.equals("G"))
        {
            System.out.println("You are now exiting the game.");
            System.exit(0);
        }

        else if(Upper.equals("S")) {
            for (int z = 0; z < x; z++){
                for (int q =0; q < x; q++){
                    grid[z][q].setSymbol("?");

                }
            }

            while (!st.empty()) {
                st.pop();
            }
            System.out.println(st);

            j=0;
            y=0;
            rounds = 0;
            grid[0][0].setSymbol("P");


        }

        else if(Upper.equals("D")&& j!=x-1) {

            if (rounds == 0) {
                System.out.println("Your current coordinate location" + "("+ j + " , "+ y + ")" + "\n");
                grid[j][y].setSymbol("t");
                rounds = rounds + 1;
            }

            else {
                j = j + 1;
                System.out.println("Your current coordinate location" + "("+ j + " , "+ y + ")" + "\n");
                if (grid[j][y].checkEmpty()) {
                    grid[j][y].setSymbol("t");
                    rounds = rounds + 1;
                }

                else if (grid[j][y].checkWall()){
                    grid[j][y].setSymbol("w");
                    j = j - 1;
                    System.out.println("A wall is here. Please make another move" + "\n");
                    st.pop();
                }

                else if (grid[j][y].checkEndpoint()){
                    grid[j][y].setSymbol("E");
                    play = false;
                }
            }
        }

        else if(Upper.equals("U") && rounds != 0 && j!=0) {
            j = j - 1;
            System.out.println("Your current coordinate location" + "("+ j + " , "+ y + ")" + "\n");
            if (grid[j][y].checkEmpty()) {
                grid[j][y].setSymbol("t");
                rounds = rounds + 1;
            }

            else if (grid[j][y].checkWall()){
                grid[j][y].setSymbol("w");
                j = j + 1;
                System.out.println("A wall is here. Please make another move" + "\n");
                st.pop();
            }

            else if (grid[j][y].checkEndpoint()){
                grid[j][y].setSymbol("E");
                play = false;
            }
        }



        else if(Upper.equals("R")&& y!=x-1) {
            if (rounds == 0) {
                System.out.println("Your current coordinate location" + "("+ j + " , "+ y + ")" + "\n");
                grid[j][y].setSymbol("t");
                rounds = rounds + 1;
            }

            else {

                y = y + 1;
                System.out.println("Your current coordinate location" + "("+ j + " , "+ y + ")" + "\n");

                if (grid[j][y].checkEmpty()) {
                    grid[j][y].setSymbol("t");
                    rounds = rounds + 1;
                }

                else if (grid[j][y].checkWall()){
                    grid[j][y].setSymbol("w");
                    y = y - 1;
                    System.out.println("A wall is here. Please make another move" + "\n");
                    st.pop();
                }

                else if (grid[j][y].checkEndpoint()){
                    grid[j][y].setSymbol("E");
                    play = false;
                }
            }
        }



        else if(Upper.equals("L") && rounds != 0 && y != x-x) {

            y = y - 1;
            System.out.println("Your current coordinate location" + "("+ j + " , "+ y + ")" + "\n");
            if (grid[j][y].checkEmpty()) {
                grid[j][y].setSymbol("t");
                rounds = rounds + 1;
            }

            else if (grid[j][y].checkWall()){
                grid[j][y].setSymbol("w");
                y = y + 1;
                System.out.println("A wall is here. Please make another move"+ "\n");
                st.pop();

            }
            else if (grid[j][y].checkEndpoint()){
                grid[j][y].setSymbol("E");
                play = false;

            }
        }
        else {

            System.out.println("Cannot go out of bounds." + "\n" + "Please make another move." + "\n");

        }
    }


    /**
     * This method keeps track of the path
     * coordinates the user made throughout
     * the game
     */
    public void Path() {

        if (rounds!=0)
        st.push("\n" + "("+ j + " , "+ y + ")");

    }

    /**
     * This method checks whether the game should be found
     * @return returns true if the user hasn't found the game yet
     * It also displays the coordinate path the user made
     * throughout the game
     */
    public boolean play() {
        // while not a win play the game
        if(play == false)
        {

            System.out.println("You found the end!" + "\n" + "Your path was: " + st);
            System.exit(0);

        }
        return true;
    }


}
