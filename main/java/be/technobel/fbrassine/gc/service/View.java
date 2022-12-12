package be.technobel.fbrassine.gc.service;

import be.technobel.fbrassine.gc.service.GameController;
import be.technobel.fbrassine.gc.model.Player;;

public class View {

    GameController controller;
    public void setController(GameController gc) {
        this.controller = gc;
    }
    public void newPlayer(){

    }
    public void cardFlip(){

    }
    public void newGame(){

    }
    public String showPlayerName (int size, Player p){
        String name = p.getName();
        return name;
    }
    public void showCardBack(int index, String name){

    }
    public void showCardFace(int index, String name, String rank, String suit){

    }
    public void showWinner (String name){

    }
}
