
package Devices.LogicGates;

import Devices.Gates;
import dlds.Board;
import dlds.Indexer;
import dlds.PinPointer;
import dlds.Consta;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class NandGate extends Gates{
    int inputValues[],outputValue;
    public NandGate(){}
    
    public NandGate(int x,int y,int pin){
        super(x,y,pin);
        inputValues=new int[pin];
        outputValue  = Consta.False;
    }
    public void draw(Graphics g,int x,int y,int pin){
        Color c=g.getColor();
        int a=x;
        int b=y;
        g.setColor(c);
        g.drawLine(a-60, b-24, a-35, b-24);
        g.drawLine(a-60, b+24, a-35, b+24);
        g.drawLine(a-60, b-24, a-60, b+24);
        g.drawArc(a-60, b-24, 50, 48, -90, 180);
        g.drawOval(a-10, b-6, 10, 10);
        g.fillOval(a-2, b-2, 4, 4);
        
        switch(pin){
            case 4:
               g.fillOval(a-62, b-12, 4, 4);
               g.fillOval(a-62, b+8, 4, 4);
               g.fillOval(a-62, b-22, 4, 4);
               g.fillOval(a-62, b+18, 4, 4);
               break;
            case 5:
               g.fillOval(a-62, b-12, 4, 4);
               g.fillOval(a-62, b+8, 4, 4);
            case 3:
               g.fillOval(a-62, b-2, 4, 4);
            case 2:
               g.fillOval(a-62, b-22, 4, 4);
               g.fillOval(a-62, b+18, 4, 4);
               break;
        }  
        
    }
    public void update(Board b[][]){
        int pin = super.getPosPin();
        Indexer[] inpt = new Indexer[pin];
        if (pin == 5){
            inpt[0] = new PinPointer(super.getPosX()-62,super.getPosY()-22).toIndex();
            inpt[1] = new PinPointer(super.getPosX()-62,super.getPosY()-12).toIndex();
            inpt[2] = new PinPointer(super.getPosX()-62,super.getPosY()-2).toIndex();
            inpt[3] = new PinPointer(super.getPosX()-62,super.getPosY()+8).toIndex();
            inpt[4] = new PinPointer(super.getPosX()-62,super.getPosY()+18).toIndex();
        }
        if (pin == 4){
            inpt[0] = new PinPointer(super.getPosX()-62,super.getPosY()-22).toIndex();
            inpt[1] = new PinPointer(super.getPosX()-62,super.getPosY()-12).toIndex();
            inpt[2] = new PinPointer(super.getPosX()-62,super.getPosY()+8).toIndex();
            inpt[3] = new PinPointer(super.getPosX()-62,super.getPosY()+18).toIndex();
        }
        if (pin == 3){
            inpt[0] = new PinPointer(super.getPosX()-62,super.getPosY()-22).toIndex();
            inpt[1] = new PinPointer(super.getPosX()-62,super.getPosY()-2).toIndex();
            inpt[2] = new PinPointer(super.getPosX()-62,super.getPosY()+18).toIndex();  
        }
        if (pin == 2){
            inpt[0] = new PinPointer(super.getPosX()-62,super.getPosY()-22).toIndex();
            inpt[1] = new PinPointer(super.getPosX()-62,super.getPosY()+18).toIndex();  
        }
        for (int i=0;i<pin;i++){
            inputValues[i] = b[inpt[i].i][inpt[i].j].value;
        }
        outputValue=Consta.False;
        for(int i=0; i<inputValues.length; i++){
            if(inputValues[i]==Consta.False){
                outputValue=Consta.True;
                break;
            }
        }
        for(int i=0; i<inputValues.length; i++){
            if (inputValues[i]==Consta.Undefined){
                outputValue=Consta.Undefined;
                break;    
            }
        }
        Indexer opt = new PinPointer(super.getPosX()-2,super.getPosY()-2).toIndex();
        b[opt.i][opt.j].value = outputValue;
    }
    
}