package edu.project2;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomizedPrimAlgorithmGenerator implements Generator {

    @SuppressWarnings("MultipleStringLiterals")
    @Override
    public Cell[][] generate(int height, int width) {
        Cell[][] maze = new Cell[height][width];
        List<Cell> cells = new ArrayList<>();

        initialization(maze, cells);

        Random random = new Random();
        Cell currentCell = cells.stream()
            .skip(random.nextInt(cells.size()))
            .findFirst()
            .get();

        currentCell.setVisited(true);

        Deque<Cell> visitedStack = new LinkedList<>();

        do {
            Map<String, Cell> neighbours = getNeighbours(currentCell, cells);
            if (!neighbours.isEmpty()) {
                visitedStack.push(currentCell);
                int randomPosition = random.nextInt(neighbours.size());
                int currentPosition = 0;
                Cell neighborCell = null;
                String direction = null;
                for (Map.Entry<String, Cell> next : neighbours.entrySet()) {
                    if (currentPosition == randomPosition) {
                        direction = next.getKey();
                        neighborCell = next.getValue();
                    }
                    currentPosition++;
                }

                switch (direction) {
                    case "up" -> neighborCell.setDownBorder(false);
                    case "right" -> currentCell.setRightBorder(false);
                    case "down" -> currentCell.setDownBorder(false);
                    case "left" -> neighborCell.setRightBorder(false);
                    default -> throw new RuntimeException("Incorrect program perform");
                }
                currentCell = neighborCell;
                currentCell.setVisited(true);
            } else if (!visitedStack.isEmpty()) {
                currentCell = visitedStack.removeLast();
            } else {
                List<Cell> notVisitedCellsList = cells.stream().filter(cell -> !cell.isVisited()).toList();
                currentCell = notVisitedCellsList.get(random.nextInt(notVisitedCellsList.size()));
                currentCell.setVisited(true);
            }

        } while (!cells.stream().filter(cell -> !cell.isVisited()).toList().isEmpty());

        return maze;
    }

    private void initialization(Cell[][] maze, List<Cell> cells) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                Cell newCell = new Cell(i, j);
                maze[i][j] = newCell;
                cells.add(newCell);
            }
        }
    }

    private Map<String, Cell> getNeighbours(Cell cell, List<Cell> cells) {
        int y = cell.getY();
        int x = cell.getX();

        Map<String, Cell> neighbours = new LinkedHashMap<>();

        neighbours.put("up",
            cells.stream()
            .filter(cellUp -> cellUp.getY() == y - 1 && cellUp.getX() == x)
            .findAny()
            .orElse(null)
        );

        neighbours.put("right",
            cells.stream()
            .filter(cellUp -> cellUp.getY() == y && cellUp.getX() == x + 1)
            .findAny()
            .orElse(null)
        );

        neighbours.put("down", cells.stream()
            .filter(cellUp -> cellUp.getY() == y + 1 && cellUp.getX() == x)
            .findAny()
            .orElse(null)
        );

        neighbours.put("left", cells.stream()
            .filter(cellUp -> cellUp.getY() == y && cellUp.getX() == x - 1)
            .findAny()
            .orElse(null)
        );

        neighbours.entrySet()
            .removeIf(stringCellEntry -> stringCellEntry.getValue() == null || stringCellEntry.getValue().isVisited());

        return neighbours;
    }
}
