package dlds;

public class Indexer {
    public int i, j;
    public Indexer(){i=j=-1;}

    
    public Indexer(int a, int b){
        i=a; j=b;
    }
    public Indexer(PinPointer p){
        i=p.x;
        j=p.y;
    }
    public PinPointer toTopLeft(){
        PinPointer p=new PinPointer();
        p.x=this.i*Consta.Size;
        p.y=this.j*Consta.Size;
        return p;
    }
    public PinPointer toMid(){
        PinPointer p=new PinPointer();
        p.x=this.i*Consta.Size+Consta.Size/2;
        p.y=this.j*Consta.Size+Consta.Size/2;
        return p;
    }
    
    public static PinPointer toTopLeft(Indexer i){
        PinPointer p=new PinPointer();
        p.x=i.i*Consta.Size;
        p.y=i.j*Consta.Size;
        return p;
    }
    public static PinPointer toMid(Indexer i){
        PinPointer p=new PinPointer();
        p.x=i.i*Consta.Size+Consta.Size/2;
        p.y=i.j*Consta.Size+Consta.Size/2;
        return p;
    }
}
