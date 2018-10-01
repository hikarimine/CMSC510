//WolfGoatCabbageBoard.java

package WolfGoatCabbage;

import java.util.Arrays;

import aima.core.agent.Action;
import aima.core.agent.impl.DynamicAction;

public class WolfGoatCabbageBoard {

    private int[] state;
    
    public static Action moveW = new DynamicAction("moveW");
    public static Action moveG = new DynamicAction("moveG");
    public static Action moveC = new DynamicAction("moveC");
    public static Action moveB = new DynamicAction("moveB");
    
// State rep: [wolf, goat, cabbage, boat] (0=L)
// Default constructor starts everyone on the left bank.
    public WolfGoatCabbageBoard() {
        state = new int[]{0, 0, 0, 0};
    }
// Construct a board based on the array representation to copy.
    public WolfGoatCabbageBoard(int[] state) {
        this.state = new int[state.length];
        System.arraycopy(state, 0, this.state, 0, state.length);
    }
// Construct a copy of board based on another board object.
    public WolfGoatCabbageBoard(WolfGoatCabbageBoard copyBoard) {
        this(copyBoard.getState());
    }

// Public accessor for the array representing the state.
    public int[] getState() {
        return state;
    }

// Update the state based on the action.
// Only  gets called if move is for sure legal
    //Move Wolf (and boat)
    public void moveW() {
        //Finish writing this method...
        if (state[0] == 0){
            state[0] = 1;
            state[3] = 1;
        }else{
            state[0] = 0;
            state[3] = 0;
        }        
    }

    //Move Goat (and boat)
    public void moveG() {
        //Finish writing this method...
        if (state[1] == 0){
            state[1] = 1;
            state[3] = 1;
        }else{
            state[1] = 0;
            state[3] = 0;
        }   
    }

    //Move Cabbage (and boat)
    public void moveC() {
        //Finish writing this method...
        if (state[2] == 0){
            state[2] = 1;
            state[3] = 1;
        }else{
            state[2] = 0;
            state[3] = 0;
        }   
    }

    //Just move Boat
    public void moveB() {
        //Finish writing this method...
        if (state[3] == 0){
            state[3] = 1;
        }else{
            state[3] = 0;
        }   
    }
    
    /*private void toggle(int a){
        state[a] = (state[a] + 1) % 2;
    }*/

// This implements the logic for whether the Action object is a valid move.
// This code uses (a+b+c)%3 a lot. Since a,b,c all either 0 or 1,
// (a+b+c)%3 = 0 iff a=b=c.
    public boolean isValidMove(Action where) {
// Check each of the possible 4 actions.
        if (where.equals(moveW)) {
            //boat and wolf need to be in same place
             if(state[0] != state[3]) return false;
             //if boat, goat and cabbage all on same side, move invalid
             return (state[1] + state[2] + state[3])%3 != 0;
        } else if (where.equals(moveG)) {
            //G,B must be on same side
            return state[1] == state[3];
            
        } else if (where.equals(moveC)) {
            //C,B must be on same side
             if(state[2] != state[3]) return false;
             //if W,G,B on same side, invalid
             return (state[0] + state[1] + state[3])%3 != 0;
        }   //Can't move boat if W,G,B together or G,C,B together
        return ((state[0] + state[1] + state[3])%3) * ((state[1] + state[2] + state[3])%3) != 0; // return boolean result
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
        WolfGoatCabbageBoard other = (WolfGoatCabbageBoard) obj;
        if (!Arrays.equals(state, other.state)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String s = "";
        if(state[0] == 0) s += "W ";
        if(state[1] == 0) s += "G ";
        if(state[2] == 0) s += "C ";
        if (state[3] == 0) {
            s += "BOAT --RIVER--      ";    // Where's the boat?
        } else {
            s += "      --RIVER-- BOAT ";
        }
        if(state[0] == 1) s += "W ";
        if(state[1] == 1) s += "G ";
        if(state[2] == 1) s += "C ";
        //s+=" RIGHT";
        return s;
    }
}
