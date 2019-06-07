package wireworld.logic;

public class Wireworld extends Grid implements CellularAutomata {

    public Wireworld(int width, int height) {
        super(width, height);
    }

    public Wireworld(String path) {
        super(path);
    }

    public Wireworld(String path, String name) {
        super(path, name);
    }

    public Grid nextGen() {
        Grid nextGen = new Wireworld(getWidth(), getHeight());
        for (int x = 0; x < getWidth(); x++)
            for (int y = 0; y < getHeight(); y++)
                if (getCell(x, y) == 0)
                    nextGen.setCell(x, y, 0);
                else if (getCell(x, y) == 1)
                    nextGen.setCell(x, y, 2);
                else if (getCell(x, y) == 2)
                    nextGen.setCell(x, y, 3);
                else if ((getCell(x, y) == 3) && (neighboursCount(x, y, 1) == 1 || neighboursCount(x, y, 1) == 2))
                    nextGen.setCell(x, y, 1);
                else
                    nextGen.setCell(x, y, 3);
        return nextGen;
    }

}
