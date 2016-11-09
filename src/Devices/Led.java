/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Devices;

import dlds.*;
import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;


public class Led implements Serializable{
    int x,y;
    int val;
    PinPointer p;
    public Led(){
        val=0;
    }
    public Led(int a,int b,Board bo[][]){
       x=a;
       y=b;
       p=new PinPointer(x,y);
       Indexer i = p.toIndex();
       val=bo[i.i][i.j].value;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }     
    public void draw(Graphics g,int x,int y) {
        Color c=g.getColor();
        int a=x;
        int b=y;
        g.drawLine(a, b, a, b-6);
        g.setColor(Color.BLACK);
        g.drawRect(a-8, b-18, 15, 12);
        g.drawRect(a-7, b-18, 15, 12);
        g.drawLine(a, b, a, b-6);
         
        g.setColor(Color.GRAY);
        g.fillRect(a-7, b-18, 15, 12);
        g.setColor(Color.BLACK);
        g.drawLine(a-8, b-18, a+8, b-18);
        if(val==Consta.True)
        {
            g.setColor(Color.RED);
            g.fillArc(a-7, b-48, 13, 60, -180, -90);
            g.fillArc(a-4, b-48, 11, 60, 0, 90);
            g.fillRect(a, b-48, 2, 30);
             
        }
        else if(val==Consta.False){
            g.setColor(Color.BLACK);
            g.fillArc(a-7, b-48, 13, 60, -180, -90);
            g.fillArc(a-4, b-48, 11, 60, 0, 90);
            g.fillRect(a, b-48, 2, 30);
        }
        else if(val==Consta.Undefined){
            g.setColor(Color.BLACK);
            g.drawArc(a-7, b-48, 13, 60, -180, -90);
            g.drawArc(a-4, b-48, 11, 60, 0, 90);      
        }
        else if(val==Consta.Notallowed){
            g.setColor(Color.GREEN);
            g.fillArc(a-6, b-48, 12, 60, -180, -90);
            g.fillArc(a-4, b-48, 10, 60, 0, 90);
            g.fillRect(a, b-48, 2, 30);
        }
        g.setColor(c);
     }
    
     public void update(Board b[][]){
        Indexer i=p.toIndex();
        val=b[i.i][i.j].value;
     }
}
