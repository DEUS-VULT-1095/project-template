package edu.project2;

public interface Solver {
    Cell[][] getPath(int startY, int startX, int endY, int endX, Cell[][] maze) throws CloneNotSupportedException;
}
