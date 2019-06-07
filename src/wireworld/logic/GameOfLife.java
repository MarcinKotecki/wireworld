package wireworld.logic;

public class GameOfLife extends Grid implements CellularAutomata {

    public GameOfLife(int width, int height) {
        super(width, height);
    }

    public GameOfLife(String path) {
        super(path);
    }

    public GameOfLife(String path, String name) {
        super(path, name);
    }

    public Grid nextGen() {
        Grid nextGen = new GameOfLife(getWidth(), getHeight());
        for (int x = 0; x < getWidth(); x++)
            for (int y = 0; y < getHeight(); y++)
                if (getCell(x, y) == 0 && neighboursCount(x, y, 1) == 3)
                    nextGen.setCell(x, y, 1);
                else if (getCell(x, y) == 1)
                    if (neighboursCount(x, y, 1) != 2 && neighboursCount(x, y, 1) != 3)
                        nextGen.setCell(x, y, 0);
                    else
                        nextGen.setCell(x, y, 1);
        return nextGen;
    }

}
