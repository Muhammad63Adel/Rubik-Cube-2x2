
package rubik2;
import java.util.*;

public class cube implements Cloneable{
    
    
    
     public corner[] corners;
    
    public  LinkedList<corner> working_cube =     new LinkedList<>();
        
    
    public Object clone()throws CloneNotSupportedException{  
        return super.clone();  
    }  
    public cube (){

        corners = new corner[8];
        corners[0] = new corner(cell.Color.R,cell.Color.G,cell.Color.Y,
                                                        0,1,2,3);
        
        corners[1] = new corner(cell.Color.O,cell.Color.G,cell.Color.Y,
                                                        1,1,2,3);
        
        corners[2] = new corner(cell.Color.O,cell.Color.G,cell.Color.W,
                                                        2,1,2,3);
                                                        
        corners[3] = new corner(cell.Color.R,cell.Color.G,cell.Color.W,
                                                        3,1,2,3);
        
        corners[4] = new corner(cell.Color.R,cell.Color.B,cell.Color.Y,
                                                        4,1,2,3);
        
        corners[5] = new corner(cell.Color.O,cell.Color.B,cell.Color.Y,
                                                        5,1,2,3);
        
        corners[6] = new corner(cell.Color.O,cell.Color.B,cell.Color.W,
                                                        6,1,2,3); 
        
        corners[7] = new corner(cell.Color.R,cell.Color.B,cell.Color.W,
                                                        7,1,2,3);
        
        working_cube.add(corners[0]);
        working_cube.add(corners[1]);
        working_cube.add(corners[2]);
        working_cube.add(corners[3]);
        working_cube.add(corners[4]);
        working_cube.add(corners[5]);
        working_cube.add(corners[6]);
        working_cube.add(corners[7]);
        
        
    }
    
    /*
        // get all colors of the cube
     public String printcube(){
        StringBuilder cubeString = new StringBuilder();
        
         for(corner f: corners){
            cubeString.append(f.printcorner()); 
        }
        return cubeString.toString();
    
     }
    */ 
     
    

     
        public State up(State s){
              
            LinkedList<corner> cubes_temp =  new LinkedList<corner>();
            
            try{
            cubes_temp.add((corner)(s.cubes.get(0).clone()));
            cubes_temp.add((corner)(s.cubes.get(1).clone()));
            cubes_temp.add((corner)(s.cubes.get(2).clone()));
            cubes_temp.add((corner)(s.cubes.get(3).clone()));
            cubes_temp.add((corner)(s.cubes.get(4).clone()));
            cubes_temp.add((corner)(s.cubes.get(5).clone()));
            cubes_temp.add((corner)(s.cubes.get(6).clone()));
            cubes_temp.add((corner)(s.cubes.get(7).clone()));
            }
            catch(CloneNotSupportedException c){
            System.out.println("Clone not supported");
            }  
            
            
            
            State temp = new State(cubes_temp, null, null);
            
              Collections.swap(temp.cubes,1,0);
              Collections.swap(temp.cubes,5,4);
              Collections.swap(temp.cubes,4,1);
              
              temp.cubes.get(0).cell_up();
              temp.cubes.get(1).cell_up();
              temp.cubes.get(4).cell_up();
              temp.cubes.get(5).cell_up();
              
              return temp;
              
        }
          
         public State  up_inv(State s){
              
              LinkedList<corner> cubes_temp =  new LinkedList<corner>();
            
            try{
            cubes_temp.add((corner)(s.cubes.get(0).clone()));
            cubes_temp.add((corner)(s.cubes.get(1).clone()));
            cubes_temp.add((corner)(s.cubes.get(2).clone()));
            cubes_temp.add((corner)(s.cubes.get(3).clone()));
            cubes_temp.add((corner)(s.cubes.get(4).clone()));
            cubes_temp.add((corner)(s.cubes.get(5).clone()));
            cubes_temp.add((corner)(s.cubes.get(6).clone()));
            cubes_temp.add((corner)(s.cubes.get(7).clone()));
            }
            catch(CloneNotSupportedException c){
            System.out.println("Clone not supported");
            }  
            
            
            
            State temp = new State(cubes_temp, null, null);
              
              Collections.swap(temp.cubes,4,1);
              Collections.swap(temp.cubes,1,0);
              Collections.swap(temp.cubes,5,4);
              
              
              temp.cubes.get(0).cell_up();
              temp.cubes.get(1).cell_up();
              temp.cubes.get(4).cell_up();
              temp.cubes.get(5).cell_up();
              
              return temp;
        }
          
        
        public State down(State s){
            
            LinkedList<corner> cubes_temp =  new LinkedList<corner>();
            
            try{
            cubes_temp.add((corner)(s.cubes.get(0).clone()));
            cubes_temp.add((corner)(s.cubes.get(1).clone()));
            cubes_temp.add((corner)(s.cubes.get(2).clone()));
            cubes_temp.add((corner)(s.cubes.get(3).clone()));
            cubes_temp.add((corner)(s.cubes.get(4).clone()));
            cubes_temp.add((corner)(s.cubes.get(5).clone()));
            cubes_temp.add((corner)(s.cubes.get(6).clone()));
            cubes_temp.add((corner)(s.cubes.get(7).clone()));
            }
            catch(CloneNotSupportedException c){
            System.out.println("Clone not supported");
            }  
            
            
            
            State temp = new State(cubes_temp, null, null);
            
            
            
              Collections.swap(temp.cubes,2,7);
              Collections.swap(temp.cubes,3,2);
              Collections.swap(temp.cubes,7,6);
              
              
              temp.cubes.get(2).cell_down();
              temp.cubes.get(3).cell_down();
              temp.cubes.get(6).cell_down();
              temp.cubes.get(7).cell_down();
              
              return temp;
              
        }
          
        public State down_inv(State s){
            
              LinkedList<corner> cubes_temp =  new LinkedList<corner>();
            
            try{
            cubes_temp.add((corner)(s.cubes.get(0).clone()));
            cubes_temp.add((corner)(s.cubes.get(1).clone()));
            cubes_temp.add((corner)(s.cubes.get(2).clone()));
            cubes_temp.add((corner)(s.cubes.get(3).clone()));
            cubes_temp.add((corner)(s.cubes.get(4).clone()));
            cubes_temp.add((corner)(s.cubes.get(5).clone()));
            cubes_temp.add((corner)(s.cubes.get(6).clone()));
            cubes_temp.add((corner)(s.cubes.get(7).clone()));
            }
            catch(CloneNotSupportedException c){
            System.out.println("Clone not supported");
            }  
            
            
            
            State temp = new State(cubes_temp, null, null);
            
              Collections.swap(temp.cubes,3,2);
              Collections.swap(temp.cubes,7,6);
              Collections.swap(temp.cubes,2,7);
              
              temp.cubes.get(2).cell_down();
              temp.cubes.get(3).cell_down();
              temp.cubes.get(6).cell_down();
              temp.cubes.get(7).cell_down();
              
              return temp;
              
        }
        
        public State front(State s){
            
            LinkedList<corner> cubes_temp =  new LinkedList<corner>();
            
            try{
            cubes_temp.add((corner)(s.cubes.get(0).clone()));
            cubes_temp.add((corner)(s.cubes.get(1).clone()));
            cubes_temp.add((corner)(s.cubes.get(2).clone()));
            cubes_temp.add((corner)(s.cubes.get(3).clone()));
            cubes_temp.add((corner)(s.cubes.get(4).clone()));
            cubes_temp.add((corner)(s.cubes.get(5).clone()));
            cubes_temp.add((corner)(s.cubes.get(6).clone()));
            cubes_temp.add((corner)(s.cubes.get(7).clone()));
            }
            catch(CloneNotSupportedException c){
            System.out.println("Clone not supported");
            }  
            
            
            
            State temp = new State(cubes_temp, null, null);
            
              Collections.swap(temp.cubes,0,7);
              Collections.swap(temp.cubes,4,0);
              Collections.swap(temp.cubes,7,3);
              
            temp.cubes.get(0).cell_front();
            temp.cubes.get(3).cell_front();
            temp.cubes.get(4).cell_front();
            temp.cubes.get(7).cell_front();

            return temp;
        }
          
         public State front_inv(State s){
              
             LinkedList<corner> cubes_temp =  new LinkedList<corner>();
            
            try{
            cubes_temp.add((corner)(s.cubes.get(0).clone()));
            cubes_temp.add((corner)(s.cubes.get(1).clone()));
            cubes_temp.add((corner)(s.cubes.get(2).clone()));
            cubes_temp.add((corner)(s.cubes.get(3).clone()));
            cubes_temp.add((corner)(s.cubes.get(4).clone()));
            cubes_temp.add((corner)(s.cubes.get(5).clone()));
            cubes_temp.add((corner)(s.cubes.get(6).clone()));
            cubes_temp.add((corner)(s.cubes.get(7).clone()));
            }
            catch(CloneNotSupportedException c){
            System.out.println("Clone not supported");
            }  
            
            
            
            State temp = new State(cubes_temp, null, null);
             
              Collections.swap(temp.cubes,4,0);
              Collections.swap(temp.cubes,7,3);
              Collections.swap(temp.cubes,0,7);
              
            temp.cubes.get(0).cell_front();
            temp.cubes.get(3).cell_front();
            temp.cubes.get(4).cell_front();
            temp.cubes.get(7).cell_front();
              return temp;
        }
         
        public State back(State s){
            
            LinkedList<corner> cubes_temp =  new LinkedList<corner>();
            
            try{
            cubes_temp.add((corner)(s.cubes.get(0).clone()));
            cubes_temp.add((corner)(s.cubes.get(1).clone()));
            cubes_temp.add((corner)(s.cubes.get(2).clone()));
            cubes_temp.add((corner)(s.cubes.get(3).clone()));
            cubes_temp.add((corner)(s.cubes.get(4).clone()));
            cubes_temp.add((corner)(s.cubes.get(5).clone()));
            cubes_temp.add((corner)(s.cubes.get(6).clone()));
            cubes_temp.add((corner)(s.cubes.get(7).clone()));
            }
            catch(CloneNotSupportedException c){
            System.out.println("Clone not supported");
            }  
            
            
            
            State temp = new State(cubes_temp, null, null);  
            
            
              Collections.swap(temp.cubes,1,5);
              Collections.swap(temp.cubes,6,2);
              Collections.swap(temp.cubes,6,1);
             
                temp.cubes.get(1).cell_back();
                temp.cubes.get(2).cell_back();
                temp.cubes.get(5).cell_back();
                temp.cubes.get(6).cell_back();

                return temp;
        }
          public State back_inv(State s){
              
              
              LinkedList<corner> cubes_temp =  new LinkedList<corner>();
            
            try{
            cubes_temp.add((corner)(s.cubes.get(0).clone()));
            cubes_temp.add((corner)(s.cubes.get(1).clone()));
            cubes_temp.add((corner)(s.cubes.get(2).clone()));
            cubes_temp.add((corner)(s.cubes.get(3).clone()));
            cubes_temp.add((corner)(s.cubes.get(4).clone()));
            cubes_temp.add((corner)(s.cubes.get(5).clone()));
            cubes_temp.add((corner)(s.cubes.get(6).clone()));
            cubes_temp.add((corner)(s.cubes.get(7).clone()));
            }
            catch(CloneNotSupportedException c){
            System.out.println("Clone not supported");
            }  
            
            
            
            State temp = new State(cubes_temp, null, null);
              
              
              Collections.swap(temp.cubes,6,1);
              Collections.swap(temp.cubes,1,5);
              Collections.swap(temp.cubes,6,2);
              
             
                temp.cubes.get(1).cell_back();
                temp.cubes.get(2).cell_back();
                temp.cubes.get(5).cell_back();
                temp.cubes.get(6).cell_back();
                    return temp;
        }
          
        public State  right(State s){
            
            
            LinkedList<corner> cubes_temp =  new LinkedList<corner>();
            
            try{
            cubes_temp.add((corner)(s.cubes.get(0).clone()));
            cubes_temp.add((corner)(s.cubes.get(1).clone()));
            cubes_temp.add((corner)(s.cubes.get(2).clone()));
            cubes_temp.add((corner)(s.cubes.get(3).clone()));
            cubes_temp.add((corner)(s.cubes.get(4).clone()));
            cubes_temp.add((corner)(s.cubes.get(5).clone()));
            cubes_temp.add((corner)(s.cubes.get(6).clone()));
            cubes_temp.add((corner)(s.cubes.get(7).clone()));
            }
            catch(CloneNotSupportedException c){
            System.out.println("Clone not supported");
            }  
            
            
            
            State temp = new State(cubes_temp, null, null);
            
            
              Collections.swap(temp.cubes,3,1);
              Collections.swap(temp.cubes,0,1);
              Collections.swap(temp.cubes,3,2);
              
              
            temp.cubes.get(0).cell_right();
            temp.cubes.get(1).cell_right();
            temp.cubes.get(2).cell_right();
            temp.cubes.get(3).cell_right();
              return temp;
        }
          
        public State right_inv(State s){
            
            
              LinkedList<corner> cubes_temp =  new LinkedList<corner>();
            
            try{
            cubes_temp.add((corner)(s.cubes.get(0).clone()));
            cubes_temp.add((corner)(s.cubes.get(1).clone()));
            cubes_temp.add((corner)(s.cubes.get(2).clone()));
            cubes_temp.add((corner)(s.cubes.get(3).clone()));
            cubes_temp.add((corner)(s.cubes.get(4).clone()));
            cubes_temp.add((corner)(s.cubes.get(5).clone()));
            cubes_temp.add((corner)(s.cubes.get(6).clone()));
            cubes_temp.add((corner)(s.cubes.get(7).clone()));
            }
            catch(CloneNotSupportedException c){
            System.out.println("Clone not supported");
            }  
            
            
            
            State temp = new State(cubes_temp, null, null);
              
              
              Collections.swap(temp.cubes,0,1);
              Collections.swap(temp.cubes,3,2);
              Collections.swap(temp.cubes,3,1);
              
            temp.cubes.get(0).cell_right();
            temp.cubes.get(1).cell_right();
            temp.cubes.get(2).cell_right();
            temp.cubes.get(3).cell_right();
              return temp;
        }
        
        
        public State left(State s){
              
              LinkedList<corner> cubes_temp =  new LinkedList<corner>();
            
            try{
            cubes_temp.add((corner)(s.cubes.get(0).clone()));
            cubes_temp.add((corner)(s.cubes.get(1).clone()));
            cubes_temp.add((corner)(s.cubes.get(2).clone()));
            cubes_temp.add((corner)(s.cubes.get(3).clone()));
            cubes_temp.add((corner)(s.cubes.get(4).clone()));
            cubes_temp.add((corner)(s.cubes.get(5).clone()));
            cubes_temp.add((corner)(s.cubes.get(6).clone()));
            cubes_temp.add((corner)(s.cubes.get(7).clone()));
            }
            catch(CloneNotSupportedException c){
            System.out.println("Clone not supported");
            }  
            
            
            
            State temp = new State(cubes_temp, null, null);
              
              Collections.swap(temp.cubes,7,4);
              Collections.swap(temp.cubes,5,6);
              Collections.swap(temp.cubes,4,6);
              
              
            temp.cubes.get(4).cell_left();
            temp.cubes.get(5).cell_left();
            temp.cubes.get(6).cell_left();
            temp.cubes.get(7).cell_left();
            
            return temp;
        }
        
          public State left_inv(State s){
              
              
              LinkedList<corner> cubes_temp =  new LinkedList<corner>();
            
            try{
            cubes_temp.add((corner)(s.cubes.get(0).clone()));
            cubes_temp.add((corner)(s.cubes.get(1).clone()));
            cubes_temp.add((corner)(s.cubes.get(2).clone()));
            cubes_temp.add((corner)(s.cubes.get(3).clone()));
            cubes_temp.add((corner)(s.cubes.get(4).clone()));
            cubes_temp.add((corner)(s.cubes.get(5).clone()));
            cubes_temp.add((corner)(s.cubes.get(6).clone()));
            cubes_temp.add((corner)(s.cubes.get(7).clone()));
            }
            catch(CloneNotSupportedException c){
            System.out.println("Clone not supported");
            }  
            
            
            
            State temp = new State(cubes_temp, null, null);
              
              Collections.swap(temp.cubes,4,6);
              Collections.swap(temp.cubes,7,4);
              Collections.swap(temp.cubes,5,6);
              
              
              
            temp.cubes.get(4).cell_left();
            temp.cubes.get(5).cell_left();
            temp.cubes.get(6).cell_left();
            temp.cubes.get(7).cell_left();
            
            return temp;
            
        }
        
                         
     }
     
     
     

/*


corners = new corner[8];
        corners[0] = new corner(cell.Color.R,cell.Color.G,cell.Color.Y,
                                                        0, 1,2,3);
        
        corners[1] = new corner(cell.Color.O,cell.Color.G,cell.Color.Y,
                                                        1,-1,2,3);
        
        corners[2] = new corner(cell.Color.O,cell.Color.G,cell.Color.W,
                                                        2,-1,2,-3);
                                                        
        corners[3] = new corner(cell.Color.R,cell.Color.G,cell.Color.W,
                                                        3,1,2,-3);
        
        corners[4] = new corner(cell.Color.R,cell.Color.B,cell.Color.Y,
                                                        4,1,-2,3);
        
        corners[5] = new corner(cell.Color.O,cell.Color.B,cell.Color.Y,
                                                        5,-1,-2,3);
        
        corners[6] = new corner(cell.Color.O,cell.Color.B,cell.Color.W,
                                                        6,-1,-2,-3); 
        
        corners[7] = new corner(cell.Color.R,cell.Color.B,cell.Color.W,
                                                        7,1,-2,-3);
*/