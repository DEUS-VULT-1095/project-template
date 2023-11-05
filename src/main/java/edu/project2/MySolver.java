package edu.project2;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class MySolver implements Solver {
    @Override
    public Cell[][] getPath(int startY, int startX, int endY, int endX, Cell[][] maze)
        throws CloneNotSupportedException {
        if (startY < 0 || startY >= maze.length || startX < 0 || startX >= maze[0].length
        || endY < 0 || endY >= maze.length || endX < 0 || endX >= maze[0].length) {
            throw new RuntimeException("Incorrect input parameters");
        }
        Cell[][] mazeWithSolve = new Cell[maze.length][maze[0].length];
        List<Cell> cells = new ArrayList<>();
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                mazeWithSolve[i][j] = (Cell) maze[i][j].clone();
                cells.add(mazeWithSolve[i][j]);
            }
        }

        Random random = new Random();

        Deque<Cell> visitedStack = new LinkedList<>();

        Cell currentCell = cells.stream()
            .filter(cell -> cell.getY() == startY && cell.getX() == startX)
            .findAny()
            .get();

        currentCell.setVisitedWhileSolve(true);
        visitedStack.push(currentCell);

        while (currentCell.getY() != endY || currentCell.getX() != endX) {

            List<Cell> neighbours = getNeighbours(currentCell, cells);
            if (!neighbours.isEmpty()) {
                Cell neighbourCell = neighbours.get(random.nextInt(neighbours.size()));
                currentCell = neighbourCell;
                currentCell.setVisitedWhileSolve(true);
                visitedStack.addLast(currentCell);
            } else {
                visitedStack.removeLast();
                currentCell = visitedStack.peekLast();
            }
        }

        visitedStack.forEach(next -> next.setSolve(true));

        return mazeWithSolve;
    }

    private List<Cell> getNeighbours(Cell currentCell, List<Cell> cells) {
        int y = currentCell.getY();
        int x = currentCell.getX();

        List<Cell> validNeighbours = new ArrayList<>();

        validNeighbours.add(cells.stream()
            .filter(cell -> cell.getY() == y - 1 && cell.getX() == x && !cell.isVisitedWhileSolve()
                && !cell.isDownBorder())
            .findFirst()
            .orElse(null)
        );

        validNeighbours.add(cells.stream()
            .filter(cell -> cell.getY() == y && cell.getX() == x + 1 && !cell.isVisitedWhileSolve()
                && !currentCell.isRightBorder())
            .findFirst()
            .orElse(null)
        );

        validNeighbours.add(cells.stream()
            .filter(cell -> cell.getY() == y + 1 && cell.getX() == x && !cell.isVisitedWhileSolve()
                && !currentCell.isDownBorder())
            .findFirst()
            .orElse(null)
        );

        validNeighbours.add(cells.stream()
            .filter(cell -> cell.getY() == y && cell.getX() == x - 1 && !cell.isVisitedWhileSolve()
                && !cell.isRightBorder())
            .findFirst()
            .orElse(null)
        );

        validNeighbours.removeIf(Objects::isNull);

        return validNeighbours;
    }
}
