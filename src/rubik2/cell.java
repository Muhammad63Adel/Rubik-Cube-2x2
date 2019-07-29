
package rubik2;




public class cell {
    
    public enum Color {
        B, G, R, Y, O, W
    }
    
    /*
    public  enum Vector {
        X, Y, Z, XX, YY, ZZ
    }
    */
    public Color color;
    public int cell_pos;
    
    //public Vector position;
   
    // constructor 
    public cell(Color c,int pos){
        color = c;
        cell_pos = pos;
    }
    
    
    //function returns the color of the cell
    public String  getName(){
        return this.color.name();
    }
    
    
    public int getVector(){   
        return this.cell_pos;
    }
    
    
    public void  change_dir( int pos){
        this.cell_pos = pos;
        
    }
    
}
