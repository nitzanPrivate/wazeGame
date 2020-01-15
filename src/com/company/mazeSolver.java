package com.company;

import java.util.LinkedList;

public class mazeSolver {

  static  int[][] maze ={

          {0,0,0,0,0,0},
          {2,0,1,1,1,0},
          {0,1,1,0,1,0},
          {0,0,0,0,1,0},
          {2,1,1,1,1,0},
          {2,0,0,0,2,0}

  };
  //0 = can't pass (or X )
  //1 = path (or 0)
  //2 = destination -a path cell, which is on the edge of the map,

   static LinkedList<Position> path = new LinkedList<Position>();  //store our path

    public static void main(String[] args){
    Position p = new Position(2,1);  //start point
    path.push(p);

    while (true) {
    int y = path.peek().y;
    int x= path.peek().x;
    maze[y][x] = 0;   //change place we visit to a 0 = wall so not going again there

        //down
        if(isValid(y+1,x)){
            if (maze[y + 1][x] == 2) {
                System.out.println("Moved Down = you won!");
                return;
            } else if (maze[y + 1][x] == 1) {
                System.out.println("Moved Down");
                path.push(new Position(y + 1, x));
                continue;
            }
        }

        //left
        if(isValid(y,x-1)){
            if (maze[y][x-1] == 2) {
                System.out.println("Moved Left = you won!");
                return;
            } else if (maze[y][x-1] == 1) {
                System.out.println("Moved Left");
                path.push(new Position(y, x-1));
                continue;
            }
        }

        //up
       if(isValid(y-1,x))
       {
           if (maze[y - 1][x] == 2) {
               System.out.println("Moved Up = you won!");
               return;
           } else if (maze[y - 1][x] == 1) {
               System.out.println("Moved Up");
               path.push(new Position(y - 1, x));
               continue;
           }
       }

        //right
        if(isValid(y,x+1)) {
            if (maze[y][x + 1] == 2) {
                System.out.println("Moved Right = you won!");
                return;
            } else if (maze[y][x + 1] == 1) {
                System.out.println("Moved Right");
                path.push(new Position(y, x + 1));
                continue;
            }
        }

            //backtracking if we encounter a wall till it reach point it can continue
            path.pop();
        System.out.println("Moved back");
            if(path.size() <= 0)
            {
                System.out.println("No Path");
                return;
            }
        }

    }


    //check if we out of maze length (y & x)
    public static boolean isValid (int y, int x){
        if(y < 0 ||
           y >= maze.length ||
           x < 0 ||
           x >= maze[y].length)
        {
            return false;
        }
        return true;

    }
}
