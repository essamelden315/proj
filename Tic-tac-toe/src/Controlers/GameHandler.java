/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlers;
import java.util.*;
public class GameHandler {   
    
    public static String[] board;
    public static int [] winIndex ;
    
    // CheckWinner method will
    // decide the combination
    // of three box given below.
    public static String checkWinner(){
        String line=null ;
        boolean flag=true;
        
        String retval="Draw";
        for (int a = 0; a < 8&&flag; a++) {
            switch (a) {
            case 0:                  
                line = board[0] + board[1] + board[2];
                winIndex[0]=0;
                winIndex[1]=1;
                winIndex[2]=2;
                break;
            case 1:
                line = board[3] + board[4] + board[5];
                winIndex[0]=3;
                winIndex[1]=4;
                winIndex[2]=5;
                break;
            case 2:
                line = board[6] + board[7] + board[8];
                winIndex[0]=6;
                winIndex[1]=7;
                winIndex[2]=8;
                break;
            case 3:
                line = board[0] + board[3] + board[6];
                winIndex[0]=0;
                winIndex[1]=3;
                winIndex[2]=6;
                break;
            case 4:
                line = board[1] + board[4] + board[7];
                winIndex[0]=1;
                winIndex[1]=4;
                winIndex[2]=7;
                break;
            case 5:
                line = board[2] + board[5] + board[8];
                winIndex[0]=2;
                winIndex[1]=5;
                winIndex[2]=8;
                break;
            case 6:
                line = board[0] + board[4] + board[8];
                winIndex[0]=0;
                winIndex[1]=4;
                winIndex[2]=8;
                break;
            case 7:
                line = board[2] + board[4] + board[6];
                winIndex[0]=2;
                winIndex[1]=4;
                winIndex[2]=6;
                break;
            }
            //For X winner
            if (line.equals("XXX")) {
                 flag=false;
                retval= "X";
            }
              // For O winner
            else if (line.equals("OOO")) {
                flag=false;
                retval= "O";    
            }
        }      
        return retval;
    }
    
    
    
}
