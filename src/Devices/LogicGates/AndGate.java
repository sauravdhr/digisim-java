package Devices.LogicGates;


import Devices.Gates;
import dlds.Board;
import dlds.Indexer;
import dlds.PinPointer;
import dlds.Consta;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class AndGate extends Gates{
    
    int[] inputValues;
    int outputValue;
    public AndGate(){}
    public AndGate(int x,int y,int pin){    
        super(x,y,pin);
        inputValues = new int[pin];
    }
    public void draw(Graphics g,int x,int y,int pin){
        Color c=g.getColor();
        int a=x;
        int b=y;
        g.setColor(c);
        g.drawLine(a-50, b-24, a-25, b-24);
        g.drawLine(a-50, b+24, a-25, b+24);
        g.drawLine(a-50, b-24, a-50, b+24);
        g.drawArc(a-50, b-24, 50, 48, -90, 180);
        
        g.fillOval(a-2, b-2, 4, 4);
        
        switch(pin){
            case 4:
                g.fillOval(a-52, b-22, 4, 4);
                g.fillOval(a-52, b-12, 4, 4);
                g.fillOval(a-52, b+18, 4, 4);
                g.fillOval(a-52, b+8, 4, 4);
                break;
            case 5:
                g.fillOval(a-52, b-12, 4, 4);
                g.fillOval(a-52, b+8, 4, 4);
            case 3:
                g.fillOval(a-52, b-2, 4, 4);
            case 2:
                g.fillOval(a-52, b-22, 4, 4);
                g.fillOval(a-52, b+18, 4, 4);
                break;
        }
        
        g.setColor(c); 
    }
    public void update(Board b[][]){
        int pin = super.getPosPin();
        Indexer[] inpt = new Indexer[pin];
        if (pin == 5){
            inpt[0] = new PinPointer(super.getPosX()-52,super.getPosY()-22).toIndex();
            inpt[1] = new PinPointer(super.getPosX()-52,super.getPosY()-12).toIndex();
            inpt[2] = new PinPointer(super.getPosX()-52,super.getPosY()-2).toIndex();
            inpt[3] = new PinPointer(super.getPosX()-52,super.getPosY()+8).toIndex();
            inpt[4] = new PinPointer(super.getPosX()-52,super.getPosY()+18).toIndex();
        }
        if (pin == 4){
            inpt[0] = new PinPointer(super.getPosX()-52,super.getPosY()-22).toIndex();
            inpt[1] = new PinPointer(super.getPosX()-52,super.getPosY()-12).toIndex();
            inpt[2] = new PinPointer(super.getPosX()-52,super.getPosY()+8).toIndex();
            inpt[3] = new PinPointer(super.getPosX()-52,super.getPosY()+18).toIndex();
        }
        if (pin == 3){
            inpt[0] = new PinPointer(super.getPosX()-52,super.getPosY()-22).toIndex();
            inpt[1] = new PinPointer(super.getPosX()-52,super.getPosY()-2).toIndex();
            inpt[2] = new PinPointer(super.getPosX()-52,super.getPosY()+18).toIndex();  
        }
        if (pin == 2){
            inpt[0] = new PinPointer(super.getPosX()-52,super.getPosY()-22).toIndex();
            inpt[1] = new PinPointer(super.getPosX()-52,super.getPosY()+18).toIndex();  
        }
        for (int i=0;i<pin;i++){
            inputValues[i] = b[inpt[i].i][inpt[i].j].value;
        }
        outputValue=Consta.True;
        
        for(int i=0; i<inputValues.length; i++){
            if(inputValues[i]==Consta.False){
                outputValue=Consta.False;
                break;
            }
        }
        for(int i=0; i<inputValues.length; i++){
            if(inputValues[i]==Consta.Undefined){
                outputValue=Consta.Undefined;
                break;
            }   
        }
        
        Indexer opt = new PinPointer(super.getPosX()-2,super.getPosY()-2).toIndex();
        b[opt.i][opt.j].value = outputValue;
    }
}