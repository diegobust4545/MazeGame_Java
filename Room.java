package com.company;


/**
 * This class generates what is in each room
 * @author Diego Bustamante
 */
public class Room {
    private boolean endPoint;
    private boolean wall;
    private boolean empty;
    private String Symbol;


    public Room(){
        endPoint = false;
        wall = false;
        empty = false;
    }


    /**
     * This method return true if it detects a end point in the file
     * @param End sets the endpoint to be true
     */
    public void setEndpoint(Boolean End){
        endPoint = End;
    }

    /**
     * This method sets true if it detects a wall in the file
     * @param Wall sets the wall to be true
     */
    public void setWall(Boolean Wall){
        wall = Wall;
    }

    /**
     * This method sets true if it detects a empty space in the file
     * @param Space sets the space to be true
     */
    public void setSpace(Boolean Space) {
        empty = Space;
    }

    /**
     * This method sets the symbol
     * of the current room on the grid
     * @param current sets the symbol of the room
     */
    public void setSymbol(String current)
    {
        Symbol = current;
    }

    /**
     * This method returns the symbol
     * @return returns the symbol
     */
    public String getSymbol()
    {
        return Symbol;
    }

    /**
     * This method returns the endpoint on the grid
     * @return returns the endpoint
     */
    public boolean checkEndpoint(){
        return endPoint;
    }

    /**
     * This method returns a wall on the grid
     * @return returns the wall
     */
    public boolean checkWall(){
        return wall;
    }

    /**
     * This method returns a empty space on the grid
     * @return returns a empty space
     */
    public boolean checkEmpty(){ return empty; }
}
