/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rubik2;

import java.util.ArrayList;
import java.util.LinkedList;
import static rubik2.Rubik2.working;

public class State {
    
    public  LinkedList<corner> cubes =   new LinkedList<>();

    int[] pos = new int[8]; 
    
    int[] pos_x = new int[8]; 
    int[] pos_y = new int[8]; 
    int[] pos_z = new int[8];
    
    State parent = null;
    
    Integer action = null;
    
    State(int[] pos,int[]  pos_x,int[] pos_y,int[] pos_z, State parent, Integer action) 
    {
        this.pos = pos;
        
        this.pos_x = pos_x;
        this.pos_y = pos_y;
        this.pos_z = pos_z;
        
        this.parent = parent;
        
        this.action = action;
    }
    
    State(LinkedList<corner> cubes, State parent, Integer action) 
    {
        this.cubes = cubes;
        
          for(int i=0; i<8; i++){
                pos[i] = cubes.get(i).corner_position();
                pos_x[i] = cubes.get(i).get_x();
                pos_y[i] = cubes.get(i).get_y();
                pos_z[i] = cubes.get(i).get_z();
         }
         
        
        this.parent = parent;
        
        this.action = action;
    }

}
