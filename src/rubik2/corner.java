
package rubik2;



public class corner implements Cloneable{
    
    
    public cell[] cell;
    public int corner_position,cell_x,cell_y,cell_z ;
    
    public corner(cell.Color color_x,cell.Color color_y,cell.Color color_z,int position 
                                    ,int x,int y,int z){
        
        cell = new cell[3];
        
        cell[0]=new cell(color_x,x);
        cell[1]=new cell(color_y,y);
        cell[2]=new cell(color_z,z);
        
        corner_position = position;
        
        cell_x = x;
        cell_y = y;
        cell_z = z;
        
    }
    
    @Override
    public Object clone()throws CloneNotSupportedException{  
        return super.clone();  
    }  
    
    public int corner_position(){
        return this.corner_position;
    }
    
    
    public int get_x(){
        return this.cell_x;
    }
    public void set_x(int x){
        this.cell_x = x;
    }
    
    
    
    public int get_y(){
        return this.cell_y;
    }
    public void set_y(int y){
        this.cell_y = y;
    }
    
    
    
    public int get_z(){
        return this.cell_z;
    }
    public void set_z(int z){
        this.cell_x = z;
    }
    
    public int sum_cell(){
        int sum ;
        sum = this.cell_x + this.cell_y + this.cell_z;
        return sum;
    }
   
    
    
    
    
    
    
    
    
    public void cell_left(){
            int temp; 
            temp = cell_x;
            cell_x = cell_z;
            cell_z = temp;
            
            
        }
    
    public void cell_right(){
            int temp; 
            temp = cell_x;
            cell_x = cell_z;
            cell_z = temp;
            
            
        }
    public void cell_up(){
            int temp; 
            temp = cell_x;
            cell_x = cell_y;
            cell_y = temp;
            
            
        }
    public void cell_down(){
            int temp; 
            temp = cell_x;
            cell_x = cell_y;
            cell_y = temp;
            
            
        }
    public void cell_front(){
            int temp; 
            temp = cell_y;
            cell_y = cell_z;
            cell_z = temp;
            
            
        }
    public void cell_back(){
            int temp; 
            temp = cell_y;
            cell_y = cell_z;
            cell_z = temp;
            
            
        }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /*
    public int cells_position(){
        int sum = 0;
        for(cell c: cell){
            sum += c.getVector(); 
        }
        return sum;
    }
    */
    
    
        /*
     public String printcorner(){
        StringBuilder cornerString = new StringBuilder();
        
         for(cell c: corner){
            cornerString.append(c.getName()); 
        }
        return cornerString.toString();
    
     }
   */  
    
    
    
}

