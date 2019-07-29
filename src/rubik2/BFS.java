package rubik2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class BFS {
    
    static ArrayList<State> frontir = new ArrayList();
    static ArrayList<Integer> explored = new ArrayList();
    
    static ArrayList<Integer> sol_moves = new ArrayList();
    
    public BFS()
    {
        
    }
    
    public static  void init ()
    {
        for(int i=0; i<8; i++){
             
                Rubik2.goal[i] = Rubik2.c.working_cube.get(i).corner_position();
                Rubik2.goal_x[i] = Rubik2.c.working_cube.get(i).get_x();
                Rubik2.goal_y[i] = Rubik2.c.working_cube.get(i).get_y();
                Rubik2.goal_z[i] = Rubik2.c.working_cube.get(i).get_z();
         }
         int [] h = new int [4];
         
        h[0] = Arrays.hashCode(Rubik2.goal);
        h[1] = Arrays.hashCode(Rubik2.goal_x);
        h[2] = Arrays.hashCode(Rubik2.goal_y);
        h[3] = Arrays.hashCode(Rubik2.goal_z);
        
        Rubik2.hashGoal = Arrays.hashCode(h);
        
          
    }
    
    public static void test()
    {
             
         int[] h = new int[4];
         
        h[0] = Arrays.hashCode(Rubik2.working);
        h[1] = Arrays.hashCode(Rubik2.working_x);
        h[2] = Arrays.hashCode(Rubik2.working_y);
        h[3] = Arrays.hashCode(Rubik2.working_z);
        
        int newHash = Arrays.hashCode(h);
        
        if( Rubik2.hashGoal == newHash){
            System.out.println("hash is fine");
        }
    }
    
    public static int ourHash(int[] a, int [] b, int[] c, int[] d)
    {
        int[] h = new int[4];
         
        h[0] = Arrays.hashCode(a);
        h[1] = Arrays.hashCode(b);
        h[2] = Arrays.hashCode(c);
        h[3] = Arrays.hashCode(d);
        
        return Arrays.hashCode(h);
    }
    
    static void update_state(State s){
        
    
      for(int i=0; i<8; i++){
            s.pos[i] =       s.cubes.get(i).corner_position();
            s.pos_x[i] =  s.cubes.get(i).get_x();
            s.pos_y[i] =  s.cubes.get(i).get_y();
            s.pos_z[i] = s.cubes.get(i).get_z();
         }
 
      
      }
    
    public static void Solve(State s){
        
        int iteration = 0;
        
        int stateHash = ourHash(s.pos, s.pos_x, s.pos_y, s.pos_z);
        //System.out.println(Rubik2.hashGoal);
        
        while(stateHash != Rubik2.hashGoal)
        {
            
        
        //System.out.println(stateHash);
        //System.out.println(explored);
        //System.out.println(explored);
            while(explored.contains(stateHash))
            {
                
                //System.out.println("In");
                
                //if(frontir.isEmpty())
                    //break;
                
                s = frontir.get(0);
                stateHash = ourHash(s.pos, s.pos_x, s.pos_y, s.pos_z);
                
                frontir.remove(0);
                
            }
            
            explored.add(stateHash);
            iteration ++;
            
            State temp;
            cube cu = new cube();
            
            temp = cu.up(s);
            frontir.add(temp);
            temp.parent= s;
            temp.action = 1;
            update_state(temp);
            
            temp = cu.up_inv(s);
            frontir.add(temp);
            temp.parent= s;
            temp.action = -1;
            update_state(temp);
            
            
            temp = cu.down(s);
            frontir.add(temp);
            temp.parent= s;
            temp.action = 2;
            update_state(temp);
            
            temp = cu.down_inv(s);
            frontir.add(temp);
            temp.parent= s;
            temp.action = -2;
            update_state(temp);
            
            temp = cu.front(s);
            frontir.add(temp);
            temp.parent= s;
            temp.action = 3;
            update_state(temp);
            
            temp = cu.front_inv(s);
            frontir.add(temp);
            temp.parent= s;
            temp.action = -3;
            update_state(temp);
            
            temp = cu.back(s);
            frontir.add(temp);
            temp.parent= s;
            temp.action = 4;
            update_state(temp);
            
            temp = cu.back_inv(s);
            frontir.add(temp);
            temp.parent= s;
            temp.action = -4;
            update_state(temp);
            
            temp = cu.right(s);
            frontir.add(temp);
            temp.parent= s;
            temp.action = 5;
            update_state(temp);
            
            temp = cu.right_inv(s);
            frontir.add(temp);
            temp.parent= s;
            temp.action = -5;
            update_state(temp);
            
            temp = cu.left(s);
            frontir.add(temp);
            temp.parent= s;
            temp.action = 6;
            update_state(temp);
            
            temp = cu.left_inv(s);
            frontir.add(temp);
            temp.parent= s;
            temp.action = -6;
            update_state(temp);
            
            
            if(frontir.isEmpty())
            {
                break;
            }
            s = frontir.get(0);
            frontir.remove(0);
            stateHash = ourHash(s.pos, s.pos_x, s.pos_y, s.pos_z);
        }
        
        
        System.out.println("the goal reached after :  " + iteration + " iteration ");
        
        
        System.out.println("Moves: ");
        
        sol_moves.clear();
        
        while(s.parent!= null)
        {
            sol_moves.add(s.action);
            s = s.parent;
        }
        
        Collections.reverse(sol_moves);
        
        for (int move: sol_moves) System.out.println(move);
        System.out.println();
        
        
        
    }
    
}
