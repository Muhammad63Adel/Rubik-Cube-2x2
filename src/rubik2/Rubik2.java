
package rubik2;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import static rubik2.BFS.sol_moves;


public class Rubik2 {
     static cube c = new cube();
     
     static int []goal = new int[8];
     static int []working = new int[8];
     static int []goal_x = new int[8];
     static int []working_x = new int[8];
     static int []goal_y = new int[8];
     static int []working_y = new int[8];
     static int []goal_z = new int[8];
     static int []working_z = new int[8];
     
     static int hashGoal;
     
     static int count = 0;
     
       static State play;
     public static void main(String[] args){
        
         Scanner in = new Scanner(System.in);
         
         while(true)
         {
            String command = in.next();
        
            //String command = text.substring(0, text.indexOf(" "));
            //String argus = text.substring(text.indexOf(" ") + 1);

            init_arrays();
            BFS.init();
        
            switch (command) {
        
                case "rand":
                    System.out.println();
                    randMoves();
                    
                    System.out.println("Finished Randomization\n");

                    break;

                case "getSol":
                    System.out.println();
                    BFS.Solve(play);
                    //printRubikCube (play);
                    

                    break;

                case "sol":
                    System.out.println();
                    for (int move: BFS.sol_moves)
                    {
                        switch(move)
                        {
                            case 1:
                                play = c.up(play);
                                update_state();
                                

                                break;

                            case -1:
                                play = c.up_inv(play);
                                update_state();

                                break;
                                
                             case 2:
                                play = c.down(play);
                                update_state();

                                break;

                            case -2:
                                play = c.down_inv(play);
                                update_state();

                                break;
                                
                            case 3:
                                play = c.front(play);
                                update_state();

                                break;

                            case -3:
                                play = c.front_inv(play);
                                update_state();

                                break;
                                
                            case 4:
                                play = c.back(play);
                                update_state();

                                break;

                            case -4:
                                play = c.back_inv(play);
                                update_state();

                                break;
                                
                            case 5:
                                play = c.right(play);
                                update_state();

                                break;

                            case -5:
                                play = c.right_inv(play);
                                update_state();

                                break;
                                
                            case 6:
                                play = c.left(play);
                                update_state();

                                break;

                            case -6:
                                play = c.left_inv(play);
                                update_state();

                                break;
                        }
                    }
                    
                    System.out.println(checkGoal());
                    break;

                default:
                    break;
            }
         }
        
       
        
        
        
        //System.out.println(checkGoal());
        
        
        
        
       /*
        init_arrays();
        print_working();
        print_goal();
        
        System.out.print("the positions of cells befor moving up "); 
        System.out.print(c.working_cube.get(1).get_x());
        System.out.print(c.working_cube.get(1).get_y());
        System.out.println(c.working_cube.get(1).get_z());
        
        algo();
        update_working();
        print_working();
        
        
        while (!check()){
            
            algo();
            update_working();
            print_working();
            if(count == 51){
                break;
            }
        }
        
     
        
            System.out.print("the positions of cells after moving up "); 
            //for(int i=0; i<8; i++){
                System.out.print(c.working_cube.get(1).get_x());
                System.out.print(c.working_cube.get(1).get_y());
                System.out.println(c.working_cube.get(1).get_z());
                
                System.out.print(" the final state is ==========>> "); 
                
                for(int i=0; i<8; i++){
                    System.out.print(c.working_cube.get(i).corner_position());

                }
           
        */
        /*
       
        System.out.println("the up corners before moving: ");
            System.out.print(c.working_cube.get(0).print_position());
            System.out.print(c.working_cube.get(1).print_position());
            System.out.print(c.working_cube.get(2).print_position());
            System.out.print(c.working_cube.get(3).print_position());
            System.out.println("");
        
      
        for(int i = 1 ; i<5; i++){
            c.right_inv();
                System.out.print( i +" iteration :  ");
                System.out.print(c.working_cube.get(0).print_position());
                System.out.print(c.working_cube.get(1).print_position());
                System.out.print(c.working_cube.get(2).print_position());
                System.out.print(c.working_cube.get(3).print_position());
                System.out.println("");
        }
          
      */ 
     }
     
    public static void randMoves()
    {
        play = new State(c.working_cube,null ,null);
        printRubikCube (play);
        Random rand = new Random();

        int iter = rand.nextInt(3) + 2;
        
        iter = 5;
        
        for(int i = 0; i < iter; i++)
        {
            int r = rand.nextInt(13) - 6;
            if(r == 0)
                r = 1;
            
            switch(r)
            {
                case 1:
                    play = c.up(play);
                    System.out.println(1);
                    update_state();

                    break;

                case -1:
                    play = c.up_inv(play);
                    System.out.println(-1);
                    update_state();

                    break;
                                
                case 2:
                    play = c.down(play);
                    System.out.println(2);
                    update_state();

                    break;

                case -2:
                    play = c.down_inv(play);
                    System.out.println(-2);
                    update_state();

                    break;
                                
                case 3:
                    play = c.front(play);
                    System.out.println(3);
                    update_state();

                    break;

                case -3:
                    play = c.front_inv(play);
                    System.out.println(-3);
                    update_state();

                    break;
                                
                case 4:
                    play = c.back(play);
                    System.out.println(4);
                    update_state();

                    break;

                case -4:
                    play = c.back_inv(play);
                    System.out.println(-4);
                    update_state();

                    break;
                                
                case 5:
                    play = c.right(play);
                    System.out.println(5);
                    update_state();

                    break;

                case -5:
                    play = c.right_inv(play);
                    System.out.println(-5);
                    update_state();

                    break;
                                
                case 6:
                    play = c.left(play);
                    System.out.println(6);
                    update_state();

                    break;

                case -6:
                    play = c.left_inv(play);
                    System.out.println(-6);
                    update_state();

                    break;
            }
            
        }

    }
     
    public static void printRubikCube(State s)
    {
        int[] pos = new int[8]; 
        System.out.print("the current state is : ");
        for(int i=0; i<8; i++){
                pos[i] = s.cubes.get(i).corner_position();
                System.out.print(pos[i]);
                
        }
        System.out.println();
        /*
        
        sticker indices:
                ┌──┬──┐
                │ 0│ 1│
                ├──┼──┤
                │ 2│ 3│
          ┌──┬──┼──┼──┼──┬──┬──┬──┐
          │16│17│ 8│ 9│ 4│ 5│20│21│
          ├──┼──┼──┼──┼──┼──┼──┼──┤
          │18│19│10│11│ 6│ 7│22│23│
          └──┴──┼──┼──┼──┴──┴──┴──┘
                │12│13│
                ├──┼──┤
                │14│15│
                └──┴──┘

        face colors:
            ┌──┐
            │ 0│
         ┌──┼──┼──┬──┐
         │ 4│ 2│ 1│ 5│
         └──┼──┼──┴──┘
            │ 3│
            └──┘
        */
    }
             
     static  void init_arrays(){
         
         
            //System.out.println(c.working_cube.get(0).print_position());
         for(int i=0; i<8; i++){
             
                goal[i] = c.working_cube.get(i).corner_position();
                goal_x[i] = c.working_cube.get(i).get_x();
                goal_y[i] = c.working_cube.get(i).get_y();
                goal_z[i] = c.working_cube.get(i).get_z();
         }
         
         
         
         for(int i=0; i<8; i++){
                working[i] = c.working_cube.get(i).corner_position();
                working_x[i] = c.working_cube.get(i).get_x();
                working_y[i] = c.working_cube.get(i).get_y();
                working_z[i] = c.working_cube.get(i).get_z();
         }
         
         
         
     }
     
     
     
     
     
     static void algo(){
         
        // c.left();
         //c.left_inv();
         //c.up_inv();
        
         
       //  c.right();
         //c.left();
         //c.right_inv();
     }
     
     
    static void update_working(){
        
    
      for(int i=0; i<8; i++){
           working[i] = c.working_cube.get(i).corner_position();
           working_x[i] = c.working_cube.get(i).get_x();
            working_y[i] = c.working_cube.get(i).get_y();
            working_z[i] = c.working_cube.get(i).get_z();
         }
      count ++;
      
      }
    
    static void update_state(){
        
    
      for(int i=0; i<8; i++){
            play.pos[i] =       play.cubes.get(i).corner_position();
            play.pos_x[i] =  play.cubes.get(i).get_x();
            play.pos_y[i] =  play.cubes.get(i).get_y();
            play.pos_z[i] = play.cubes.get(i).get_z();
         }
      printRubikCube (play);
      count ++;
      
      }
    
    static void update_state(State s){
        
    
      for(int i=0; i<8; i++){
            s.pos[i] =       s.cubes.get(i).corner_position();
            s.pos_x[i] =  s.cubes.get(i).get_x();
            s.pos_y[i] =  s.cubes.get(i).get_y();
            s.pos_z[i] = s.cubes.get(i).get_z();
         }
 
      
      }
    
    static void print_goal(){
        System.out.print("the goal is : ");
        for(int i=0; i<8; i++){
            
                System.out.print(goal[i]);
                
            }
        
        System.out.println(" ");

    }
    
    
    static void print_working(){
        
        System.out.print("the current state of itiration " + count +" is ");  
        for(int i=0; i<8; i++){
                 
                System.out.print(working[i]);
            }
        System.out.println(" ");

    }

    
    static boolean check(){
        boolean corner = Arrays.equals(goal,working);
        boolean cell_x = Arrays.equals(goal_x,working_x);
        boolean cell_y = Arrays.equals(goal_y,working_y);
        boolean cell_z = Arrays.equals(goal_z,working_z);
        
        
        
        if (corner && cell_x && cell_y && cell_z){
            return true;
        }
        
        return false;
    }
    
    static boolean checkGoal(){
        
        boolean corner = Arrays.equals(goal,play.pos);
        boolean cell_x = Arrays.equals(goal_x,play.pos_x);
        boolean cell_y = Arrays.equals(goal_y,play.pos_y);
        boolean cell_z = Arrays.equals(goal_z,play.pos_z);
        
        
        
        return (corner && cell_x && cell_y && cell_z);
            
    }
    
    static boolean checkGoal(State s){
        
        boolean corner = Arrays.equals(goal,s.pos);
        boolean cell_x = Arrays.equals(goal_x,s.pos_x);
        boolean cell_y = Arrays.equals(goal_y,s.pos_y);
        boolean cell_z = Arrays.equals(goal_z,s.pos_z);
        
        
        
        return (corner && cell_x && cell_y && cell_z);
            
    }
    
}


