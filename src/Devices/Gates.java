/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Devices;

import java.io.Serializable;

public class Gates implements Serializable{
    int posX,posY,gatePin;
    public int getPosX(){
        return posX;
    }
    public int getPosY(){
        return posY;
    }
    public int getPosPin(){
        return gatePin;
    }
    public Gates(){}
    public Gates(int x,int y,int pin){
        posX = x;
        posY = y;
        gatePin = pin;
    }
   
}
