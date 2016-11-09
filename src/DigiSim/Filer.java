package DigiSim;

import java.io.*;
import java.util.*;
import javax.swing.JFileChooser;
import javax.swing.*;


public class Filer{
    
    public void New(MyFrame x){
        JOptionPane jp=new JOptionPane();
        int val=0,chk=0;
        if(x.deviceList.size()>0){
            val=jp.showConfirmDialog(null, "Do you want to save this project?");
            if(val==JOptionPane.YES_OPTION){
                save(x);
            }
            else if(val==JOptionPane.NO_OPTION){
            }   
            else{ 
                chk = 1;
            }
        }
        if (chk == 0){
            x.deviceList.clear();
            x.undoList.clear();
        }
        
    }
	
    public void open(MyFrame x) throws FileNotFoundException, IOException, ClassNotFoundException{
        JOptionPane jp=new JOptionPane();
        int val=0,check = 0;
        if(x.deviceList.size()>0){
            val=jp.showConfirmDialog(null, "Do you want to save this project?");

            if(val==JOptionPane.YES_OPTION){
                save(x);
                check = 1;
            }
            else if(val==JOptionPane.NO_OPTION){
                x.deviceList.clear();
                x.undoList.clear();  
                check = 1;
            }
            else{            

            }
        }
        else if (x.deviceList.size()==0) 
            check = 1;
        if (check == 1){
        JFileChooser jf=new JFileChooser();
        jf.setCurrentDirectory( new File( "./SavedFiles") );
        
        int retval = jf.showOpenDialog(null);
            if (retval == JFileChooser.APPROVE_OPTION) {
                //... The user selected a file, get it, use it.
                File file = jf.getSelectedFile();
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream d=new ObjectInputStream(fis);
                Object v;
                try{
                    v=d.readObject();
                    MyFrame.deviceList=(Vector)v;
		}
		catch(StreamCorruptedException e){
                }
                d.close();
                fis.close();
            }
        }
    }
	
    public void save(MyFrame x){
         JFileChooser jf=new JFileChooser();
         jf.setCurrentDirectory( new File( "./SavedFiles") );
         jf.setDialogTitle("save");
         int retval = jf.showSaveDialog(null);
            
            if (retval == JFileChooser.APPROVE_OPTION) {
                File file = new File(jf.getSelectedFile()+".CKT");
                int n=0;
                while(n==0){
                    if(file.exists()){
                        retval = JOptionPane.showConfirmDialog(jf,"Replace existing file?");
                        if (retval == JOptionPane.NO_OPTION){
                            jf.showSaveDialog(jf);
                            file = new File(jf.getSelectedFile()+".CKT");
                        }
                        else if(retval == JOptionPane.YES_OPTION){
                            try {
                                FileOutputStream fis = new FileOutputStream(file);
                                ObjectOutputStream d = new ObjectOutputStream(fis);
                                 d.writeObject(x.deviceList);
                                d.flush();
                                d.close();
                                fis.close();
                            }
                            catch(IOException e) {
                                System.out.println("Exception during serialization: " + e);
                                System.exit(0);
                            }
                            n=1;
                        }
                    else if(retval == JOptionPane.CANCEL_OPTION){
                        n=1;
                    }
                }
                else{
                    try{
                        FileOutputStream fis = new FileOutputStream(file);
                        ObjectOutputStream d = new ObjectOutputStream(fis);
                        d.writeObject(x.deviceList);
                        d.flush();
                        d.close();
                        fis.close();
                    }
                    catch(Exception e){
                        System.out.println("Exception during serialization: ");   
                    }
                }
                n=1;
              }
    }  
    }
    public void exit(MyFrame x){
        New(x);
        System.exit(0);
    }
}