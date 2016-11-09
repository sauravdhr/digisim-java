
package DigiSim;

import java.io.Serializable;
public class Board implements Serializable{
    public int left, top;
    public int midx, midy;
    public int value;
    

    public Board() {
    }
    public int getIndexX(){
        return left/Consta.Size;
    }
    public int getIndexX(int locx){
	return locx/Consta.Size;
    }
    public int getIndexY(){
	return top/Consta.Size;
    }
    public int getIndexY(int locy){
        return locy/Consta.Size;
    }
    public int getx(){
        return left;
    }
    public int gety(){
        return top;
    }
    public static int getmidx(int locx){
        return locx/Consta.Size*Consta.Size+Consta.Size/2;
    }
    public static int getmidy(int locy){
        return locy/Consta.Size*Consta.Size+Consta.Size/2;
    }
    public int getValue(){
        return value;
    }
    
    
    public Board(int i, int j){
        if(i>3)
            value=Consta.Undefined;
        else if(i<2)
            value=Consta.True;
        else value=Consta.False;
        
        left=i*Consta.Size;
        top=j*Consta.Size;
        midx=left+(Consta.Size)/2;
        midy=top+(Consta.Size)/2;
        
    }
}
