package dlds;

import java.awt.Point;
import java.io.Serializable;


public class PinPointer implements Serializable{
    public int x, y;    
    public PinPointer(){
        x=y=-1;
    }
    public PinPointer(int a, int b){
	x=a;y=b;
    }
    public PinPointer(PinPointer p){
	this.x=p.x;
        this.y=p.y;
    }
    public PinPointer(Point p){
        this.x= p.x;
        this.y = p.y;
    }

    
    
    public Indexer toIndex(){
        Indexer i=new Indexer();
        i.i=this.x/Consta.Size;
        i.j=this.y/Consta.Size;
        return i;
    }
    public PinPointer toTopLeft(){
        PinPointer p=new PinPointer();
        p.x=this.x/Consta.Size*Consta.Size;
        p.y=this.y/Consta.Size*Consta.Size;
        return p;
    }
    public PinPointer toMid(){
        PinPointer p=new PinPointer();
        p.x=this.x/Consta.Size*Consta.Size+Consta.Size/2;
        p.y=this.y/Consta.Size*Consta.Size+Consta.Size/2;
        return p;
    }
    
    public static Indexer toIndex(PinPointer p){
        Indexer i=new Indexer();
        i.i=p.x/Consta.Size;
        i.j=p.y/Consta.Size;
        return i;
    }
    
    public static PinPointer toTopLeft(PinPointer q){
        PinPointer p=new PinPointer();
        p.x=q.x/Consta.Size*Consta.Size;
        p.y=q.y/Consta.Size*Consta.Size;
        return p;
    }
    public static PinPointer toMid(PinPointer q){
        PinPointer p=new PinPointer();
        p.x=q.x/Consta.Size*Consta.Size+Consta.Size/2;
        p.y=q.y/Consta.Size*Consta.Size+Consta.Size/2;
        return p;
    }
}
