//WolfGoatCabbageBoard.java

package MissionariesandCannibals;

import java.util.Arrays;

import aima.core.agent.Action;
import aima.core.agent.impl.DynamicAction;

public class MissionariesAndCannibalsBoard {

    private int[] state;
    
    public static Action moveB = new DynamicAction("moveB");
    public static Action cBoard = new DynamicAction("cBoard");
    public static Action mBoard = new DynamicAction("mBoard");
    public static Action cDebark = new DynamicAction("cDebark");
    public static Action mDebark = new DynamicAction("mDebark");
    
    
// State rep: [wolf, goat, cabbage, boat] (0=L)
// Default constructor starts everyone on the left bank.
    public MissionariesAndCannibalsBoard() {
        state = new int[]{0, 0, 0, 0, 0};
    }
// Construct a board based on the array representation to copy.
    public MissionariesAndCannibalsBoard(int[] state) {
        this.state = new int[state.length];
        System.arraycopy(state, 0, this.state, 0, state.length);
    }
// Construct a copy of board based on another board object.
    public MissionariesAndCannibalsBoard(MissionariesAndCannibalsBoard copyBoard) {
        this(copyBoard.getState());
    }

// Public accessor for the array representing the state.
    public int[] getState() {
        return state;
    }

// Update the state based on the action.
// Only  gets called if move is for sure legal
    //Move Wolf (and boat)
    public void moveB() {
        //Finish writing this method...
             
    }

    public void cBoard() {
        //Finish writing this method...
           
    }

    public void mBoard() {
        //Finish writing this method...
          
    }

    public void cDebark() {
        //Finish writing this method...
          
    }
    
    public void mDebark() {
        
    }

// This implements the logic for whether the Action object is a valid move.
// This code uses (a+b+c)%3 a lot. Since a,b,c all either 0 or 1,
// (a+b+c)%3 = 0 iff a=b=c.
    public boolean isValidMove(Action where) {
        return false;
// Check each of the possible 4 actions.
        
    }

    @Override
    public int hashCode() {     // Where is this used?
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.hashCode(state);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        MissionariesAndCannibalsBoard other = (MissionariesAndCannibalsBoard) obj;
        if (!Arrays.equals(state, other.state)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String s = "";
        if(state[0] == 0) s += " ";
        if(state[0] == 1) s += "C ";
        if(state[0] == 2) s += "C C ";
        if(state[0] == 3) s += "C C C ";
        if(state[1] == 0) s += " ";
        if(state[1] == 1) s += "M ";
        if(state[1] == 2) s += "M M ";
        if(state[1] == 3) s += "M M M ";
        if (state[4] == 0) {
            s += "BOAT --RIVER--      ";   
        } else {
            s += "      --RIVER-- BOAT ";
        }
        if(state[2] == 0) s += " ";
        if(state[2] == 1) s += "C ";
        if(state[2] == 2) s += "C C ";
        if(state[2] == 3) s += "C C C ";
        if(state[3] == 0) s += " ";
        if(state[3] == 1) s += "M ";
        if(state[3] == 2) s += "M M ";
        if(state[3] == 3) s += "M M M ";
        //s+=" RIGHT";
        return s;
    }
}
