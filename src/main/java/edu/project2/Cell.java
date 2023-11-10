package edu.project2;

public class Cell implements Cloneable {
    private int y;
    private int x;
    private boolean isVisited;
    private boolean isVisitedWhileSolve;
    private boolean downBorder;
    private boolean rightBorder;
    private boolean isSolve;

    public Cell(int y, int x) {
        this.y = y;
        this.x = x;
        this.downBorder = true;
        this.rightBorder = true;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public boolean isDownBorder() {
        return downBorder;
    }

    public void setDownBorder(boolean downBorder) {
        this.downBorder = downBorder;
    }

    public boolean isRightBorder() {
        return rightBorder;
    }

    public void setRightBorder(boolean rightBorder) {
        this.rightBorder = rightBorder;
    }

    @Override
    public String toString() {
        return (downBorder ? (isSolve ? "_*_" : "___") : (isSolve ? " * " : "   "))
            + (rightBorder ? "|" : downBorder ? "_" : " ");
    }

    @SuppressWarnings("NoClone")
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public boolean isVisitedWhileSolve() {
        return isVisitedWhileSolve;
    }

    public void setVisitedWhileSolve(boolean visitedWhileSolve) {
        isVisitedWhileSolve = visitedWhileSolve;
    }

    public boolean isSolve() {
        return isSolve;
    }

    public void setSolve(boolean solve) {
        isSolve = solve;
    }
}
