package edu.project2;

public final class Render {

    private Render() {
    }

    @SuppressWarnings("RegexpSinglelineJava")
    public static void renderMaze(Cell[][] maze) {
        for (int i = 0; i < maze.length; i++) {
            System.out.print("____");
        }
        System.out.println();
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if (j == 0) {
                    System.out.print("");
                }
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
    }
}
