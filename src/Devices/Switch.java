/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Devices;

import dlds.Board;
import dlds.Indexer;
import dlds.Consta;
import java.awt.Color;
import java.awt.Graphics;
import dlds.PinPointer;
import java.io.Serializable;

public class Switch implements Serializable{
    int value;
    int refx, refy;
    PinPointer ref;
    
    public Switch(){
        value = Consta.False;
    }
    public Switch(int x, int y){
        refx = x;
        refy = y;
        value = Consta.False;
    }
    public int GetRefx(){
        return refx;
    }
    public int GetRefy(){
        return refy;
    }
    public void toggle(){
        if(value==Consta.False)
            value=Consta.True;
        else value=Consta.False;
    }
    public void draw(Graphics g){
        Color c=g.getColor();
        if(value==Consta.False)
            g.setColor(Color.BLACK);
        else if(value==Consta.True) 
            g.setColor(Color.GREEN);
        else 
            g.setColor(Color.BLUE);
        
        g.drawRect(refx-2*Consta.Size+3, refy-Consta.Size+3, 2*Consta.Size-6, 2*Consta.Size-6);
        g.drawRect(refx-2*Consta.Size+2, refy-Consta.Size+2, 2*Consta.Size-4, 2*Consta.Size-4);
        g.fillOval(refx-2, refy-2,4,4);
        
        if(value==Consta.True){
            g.setColor(Color.darkGray);
            g.drawString("1", refx-Consta.Size-2, refy+5);
        }
         if(value==Consta.False){
            g.setColor(Color.darkGray);
            g.drawString("0", refx-Consta.Size-2, refy+5);
        }
        
        if(value==Consta.Undefined){
            g.setColor(Color.darkGray);
            g.drawString("x", refx-Consta.Size-2, refy+5);
        }
        
        g.setColor(c);
    }
    public void draw(Graphics g,int x,int y){
        refx = x;
        refy = y;
        Color c=g.getColor();
        
        if(value==Consta.False)
            g.setColor(Color.BLACK);
        else if(value==Consta.True) 
            g.setColor(Color.GREEN);
        else 
            g.setColor(Color.BLUE);
        
        g.drawRect(refx-2*Consta.Size+3, refy-Consta.Size+3, 2*Consta.Size-6, 2*Consta.Size-6);
        g.drawRect(refx-2*Consta.Size+2, refy-Consta.Size+2, 2*Consta.Size-4, 2*Consta.Size-4);
        g.fillOval(refx-2, refy-2,4,4);
        if(value==Consta.True){
            g.setColor(Color.darkGray);
            g.drawString("1", refx-Consta.Size-2, refy+5);
        }
         if(value==Consta.False){
            g.setColor(Color.darkGray);
            g.drawString("0", refx-Consta.Size-2, refy+5);
        }
        
        if(value==Consta.Undefined){
            g.setColor(Color.darkGray);
            g.drawString("x", refx-Consta.Size-2, refy+5);
        }
        
        g.setColor(c);
    }
    public void update(Board b[][]){
        ref = new PinPointer(refx,refy);
        Indexer i=ref.toIndex();
        b[i.i][i.j].value=value;
    }
}
