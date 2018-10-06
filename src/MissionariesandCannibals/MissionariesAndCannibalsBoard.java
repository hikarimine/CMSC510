//WolfGoatCabbageBoard.java

package MissionariesandCannibals;

import java.util.Arrays;

import aima.core.agent.Action;
import aima.core.agent.impl.DynamicAction;

public class MissionariesAndCannibalsBoard {

    private int[] state;
    
    public static Action moveMM = new DynamicAction("moveMM");
    public static Action moveCC = new DynamicAction("moveCC");
    public static Action moveC = new DynamicAction("moveC");
    public static Action moveM = new DynamicAction("moveM");
    public static Action moveMC = new DynamicAction("moveMC");
    public static Action moveB = new DynamicAction("moveB");
    
// State rep: [LeftC,LeftM,RightC,RightM,Boat] 
// Default constructor starts everyone on the left bank.
    public MissionariesAndCannibalsBoard() {
        state = new int[]{0, 0, 0, 0, 0};
        //start [3,3,0,0,0]
        //end [0,0,3,3,1]
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
     public void moveB() {
        if (state[4] == 0){
            state[4] = 1;
        }else{
            state[4] = 0;
        }   
    }
    public void moveMM() {
        if(state[1] >= 2){ // MM move from left to right
            state[1] = state[1] - 2;
            state[3] = state[3] + 2;
        }else{ //MM move from right to left
            state[1] = state[1] + 2;
            state[3] = state[3] - 2;
        }
    }
    public void moveCC() { 
        if(state[0] >= 2){ // CC move from left to right
            state[0] = state[0] - 2;
            state[2] = state[2] + 2;
        }else{ // CC move from right to left
            state[0] = state[0] + 2;
            state[2] = state[2] - 2;
        }
    }
    public void moveMC() { 
        if(state[1] >= 1 && state[0] >= 1){ // M and C move from left to right
            state[1] = state[1] - 1;
            state[0] = state[0] - 1;
            state[2] = state[2] + 1;
            state[3] = state[3] + 1;
        }else{  // M and C move from right to left
            state[1] = state[1] + 1;
            state[0] = state[0] + 1;
            state[2] = state[2] - 1;
            state[3] = state[3] - 1;
        }
    }
    public void moveM(){  
        if(state[1] >= 1){  // M move from left to right
            state[1] = state[1] - 1;
            state[3] = state[3] + 1;
        }else{  // M move from right to left
            state[1] = state[1] + 1;
            state[3] = state[3] - 1;
        }
    }
    public void moveC(){
        if(state[0] >= 1){  // C move from left to right
            state[0] = state[0] - 1;
            state[2] = state[2] + 1;
        }else{  // C move from right to left
            state[0] = state[0] + 1;
            state[2] = state[2] - 1;
        }
    }
// This implements the logic for whether the Action object is a valid move.
    public boolean isValidMove(Action where) {
        if (where.equals(moveMM)){ // move MM to another side
            // MM and B are both on left
            if (state[1] >= 2 && state[4] == 0){ 
                // check that there are equal or more Ms than Cs before and after the move
                return ((state[1] - 2) >= state[0])&&((state[3] + 2) >= state[2]);
            } else if(state[3] >= 2 && state[4] == 1){ // check that MM and B are both on right
                return ((state[3] - 2) >= state[2])&&((state[1] + 2) >= state[0]);
            } else 
                return false;
        }else if (where.equals(moveCC)){
            if (state[0] >= 2 && state[4] == 0){ //check that CC and B are both on left
                // check that there are equal or more Ms than Cs before and after the move
                return ((state[0] - 2) <= state[1])&&((state[2] + 2) <= state[3]);
            } else if(state[2] >= 2 && state[4] == 1){ // check that CC and B are both on right
                return ((state[2] - 2) <= state[3])&&((state[0] + 2) <= state[1]);
            } else 
                return false;
        }else if (where.equals(moveM)){ // moving M from one side to another
            if (state[1] >= 1 && state[4] == 0){ //check that M and B are both on left
                // check that there are equal or more Ms than Cs before and after the move
                return ((state[1] - 1) >= state[0])&&((state[3] + 1) >= state[2]);
            } else if(state[3] >= 1 && state[4] == 1){ // check that M and B are both on right
                return ((state[3] - 1) >= state[2])&&((state[1] + 1) >= state[0]);
            } else 
                return false;
        }else if (where.equals(moveC)){ // moving C from one side to another
            if (state[0] >= 1 && state[4] == 0){ //check that C and B are both on left
                // check that there are equal or more Ms than Cs before and after the move
                return ((state[0] - 1) <= state[1])&&((state[2] + 1) <= state[3]);
            } else if(state[2] >= 1 && state[4] == 1){ // check that C and B are both on right
                return ((state[2] - 1) <= state[3])&&((state[0] + 1) <= state[1]);
            } else 
                return false;
        }else if(where.equals(moveMC)){
            if(state[0] > 0 && state[1] > 0 && state[4] == 0){ // at least one C and on M on left side
                // check that there are euqal or more Ms than Cs before and after the move
                return ((state[0] - 1) <= (state[1] - 1)) && (state[2] + 1) <= (state[3] + 1);
            } else if(state[2] > 0 && state[3] > 0 && state[4] == 1){ // at least one C and M on right side
                return ((state[2] - 1) <= (state[3] - 1)) && (state[0] + 1) <= (state[1] + 1);
            } else
                return false;
        }else
        // todo: add the case for moveB, think about the case when boat can/cannot move, otherwise NO SOLUTION FOUND
            return false;
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
        } 
        if(state[4] == 1) {
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
