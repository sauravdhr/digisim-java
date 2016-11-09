
package Devices.LogicGates;

import Devices.Gates;
import dlds.Board;
import dlds.Indexer;
import dlds.PinPointer;
import dlds.Consta;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class NotGate extends Gates{
    int inputValue,outputValue;
    public NotGate(){}
    public NotGate(int x,int y,int pin){
        super(x,y,pin);
        outputValue=0;
    }
    public void draw(Graphics g,int x,int y,int pin){
       Color c=g.getColor();
        int a=x;
        int b=y;
        g.setColor(c);
        
        g.drawLine(a-40, b-15, a-40, b+15);
        g.drawLine(a-11, b, a-40, b-15);
        g.drawLine(a-11, b, a-40, b+15);
        g.drawOval(a-11, b-5, 10, 10);
        
        g.fillOval(a-42, b-2, 4, 4);
        g.fillOval(a-2, b-2, 4, 4);        
        
        g.setColor(c);  
    }
    public void update(Board b[][]){
        Indexer inpt = new PinPointer(super.getPosX()-42,super.getPosY()-2).toIndex();
        inputValue = b[inpt.i][inpt.j].value;

        if (inputValue == Consta.Undefined)
            outputValue = Consta.Undefined;
        
        if (inputValue == 1 || inputValue == 0)
            outputValue = (inputValue==Consta.False ? Consta.True : Consta.False);
        
        Indexer opt = new PinPointer(super.getPosX()-2,super.getPosY()-2).toIndex();
        b[opt.i][opt.j].value = outputValue;
    }
}