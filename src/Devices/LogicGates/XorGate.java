
package Devices.LogicGates;


import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import Devices.Gates;
import dlds.Board;
import dlds.Indexer;
import dlds.PinPointer;
import dlds.Consta;

public class XorGate extends Gates{
    int[] inputValues;
    int outputValue;
    public XorGate(){}
    public XorGate(int x,int y,int pin){
        super(x,y,pin);
        inputValues = new int[pin];
    }
    public void draw(Graphics g,int x,int y,int pin){
        Color c = g.getColor();
        int a=x;
        int b=y;
        g.setColor(c);
        g.drawArc(a-60, b-24, 20, 48, -90, 180);
        g.drawArc(a-70, b-24, 20, 48, -90, 180);        
        g.drawArc(a-92,b-24,90,48,-90,90);
        g.drawArc(a-92,b-24,90,48,0,90);
        g.fillOval(a-2, b-2, 4, 4);
        
        switch(pin){
            case 4:
                g.fillOval(a-62, b-22, 4, 4);
                g.drawLine(a-62, b-20, a-55, b-20);
                g.fillOval(a-62, b-12, 4, 4);
                g.drawLine(a-62, b-10, a-52, b-10);
                g.fillOval(a-62, b+18, 4, 4);
                g.drawLine(a-62, b+20, a-55, b+20);
                g.fillOval(a-62, b+8, 4, 4);
                g.drawLine(a-62, b+10, a-52, b+10);
                break;
            case 5:
                g.fillOval(a-62, b-12, 4, 4);
                g.drawLine(a-62, b-10, a-52, b-10);
                g.fillOval(a-62, b+8, 4, 4);
                g.drawLine(a-62, b+10, a-52, b+10);
            case 3:
                g.fillOval(a-62, b-2, 4, 4);
                g.drawLine(a-62, b, a-50, b);
            case 2:
                g.fillOval(a-62, b-22, 4, 4);
                g.drawLine(a-62, b-20, a-55, b-20);
                g.fillOval(a-62, b+18, 4, 4);
                g.drawLine(a-62, b+20, a-55, b+20);
                break;
        }
        
        g.setColor(c); 
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
        int sum=0,flag=0;
        outputValue = Consta.False;
        
        for(int i=0;i<pin;i++){
            if(inputValues[i]==Consta.True){
               sum++;
               flag=1;
           }
           else if(inputValues[i]==Consta.False){
               flag=1;
           }
        }
        for(int i=0;i<pin;i++){
           if (inputValues[i]==Consta.Undefined){
                outputValue=Consta.Undefined;
                flag=0;                
            }
        }
        if(flag==1){
           if (sum == 1 || sum==3 || sum==5)
               outputValue = Consta.True;
           else 
               outputValue = Consta.False;
        }    
        Indexer opt = new PinPointer(super.getPosX()-2,super.getPosY()-2).toIndex();
        b[opt.i][opt.j].value = outputValue;
    }
}