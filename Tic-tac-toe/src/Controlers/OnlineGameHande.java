/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlers;

import javafx.scene.image.ImageView;
import tic.tac.toe.OnlineGameScreenViewBase;

/**
 *
 * @author User
 */
public class OnlineGameHande {

    OnlineGameScreenViewBase onlineGame;
    private static int playIndex;

    public static void setPlayIndex(int playI) {
        playIndex = playI;
    }

    public OnlineGameHande() {
        playIndex=1;
        onlineGame = new OnlineGameScreenViewBase();
    }

    public void oppinantGameTurn(int index) {
        ImageView iv = onlineGame.gameBoard[index];
        onlineGame.gameControl(iv, index);
        
        for (ImageView i : onlineGame.gameBoard) {
            i.setDisable(false);
        }
    }
    public int myGameTurn(){
        playIndex=onlineGame.playIndex;
        return playIndex;
    }

    

}
