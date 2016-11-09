/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Devices;

import dlds.Board;
import dlds.Indexer;
import dlds.PinPointer;
import dlds.Consta;
import dlds.PinPointer;
import java.awt.*;
import java.io.Serializable;
import java.util.Random;

public class Wire implements Serializable{
    Point starter,ender;
    int value;
    public Wire(){
        starter = new Point();
        ender = new Point();
        value = Consta.Undefined;
    }
    public Wire(Point s,Point e){
        starter = s;
        ender = e;
    }
    public Point getStartPoint(){
        return starter;
    }
    public Point getEndPoint(){
        return ender;
    }
    public void setStartPoint(Point p){
        starter = p;
    }
    public void setEnderPoint(Point p){
        ender = p;
    }
    public void draw(Graphics g,Point start,Point end){
        
        if(value==Consta.Undefined)
            g.setColor(Color.BLUE);
        else if(value==Consta.True)
            g.setColor(Color.GREEN);
        else if(value==Consta.False)
            g.setColor(Color.BLACK);
        
        
        Point mid = new Point((start.x+end.x)/2,(start.y+end.y)/2);
        /*PinPointer tempo = new PinPointer(mid);
        mid = new Point(tempo.toMid().x,tempo.toMid().y);*/
        g.drawLine(start.x, start.y, mid.x, start.y);
        g.drawLine(mid.x, start.y, mid.x, end.y);
        g.drawLine(mid.x, end.y, end.x, end.y);        
        if (start.x > 0 && start.y > 0){
            g.fillOval(start.x-2,start.y-2,4,4);
            g.fillOval(end.x-2,end.y-2,4,4);
        }
//        g.drawLine(start.x,start.y,end.x,end.y);
    }
    public void update(Board b[][]){
        Indexer i= new PinPointer(starter.x,starter.y).toIndex();
        Indexer j = new PinPointer(ender.x,ender.y).toIndex();
        value = Consta.Undefined;
        
        if (b[i.i][i.j].value == Consta.True){
            value = Consta.True;
            b[j.i][j.j].value = Consta.True;
        }
        else if (b[j.i][j.j].value == Consta.True){
            value = Consta.True;
            b[i.i][i.j].value = Consta.True;
        }
        else if (b[i.i][i.j].value == Consta.False){
            value = Consta.False;
            b[j.i][j.j].value = Consta.False;
        }
        else if (b[j.i][j.j].value == Consta.False){
            value = Consta.False;
            b[i.i][i.j].value = Consta.False;
        }
    }
}
