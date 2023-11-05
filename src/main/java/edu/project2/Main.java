package edu.project2;

public final class Main {
    private static final int Y_BOARD = 11;
    private static final int X_BOARD = 11;
    private static final int START_Y = 0;
    private static final int START_X = 0;
    private static final int END_Y = 10;
    private static final int END_X = 10;

    private Main() {
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Generator generator = new RandomizedPrimAlgorithmGenerator();
        Cell[][] maze = generator.generate(Y_BOARD, X_BOARD);
        Render.renderMaze(maze);

        Solver solver = new MySolver();
        Cell[][] solveMaze = solver.getPath(START_Y, START_X, END_Y, END_X, maze);
        Render.renderMaze(solveMaze);
    }
}
