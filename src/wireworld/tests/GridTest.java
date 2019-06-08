package wireworld.tests;

import org.junit.jupiter.api.Test;
import wireworld.logic.GameOfLife;
import wireworld.logic.Grid;
import wireworld.logic.Wireworld;

import static org.junit.jupiter.api.Assertions.*;

class GridTest {

    @Test
    void gridTest1() {
        Grid g = new Wireworld("/wireGateOR", "OR gate");
        assertEquals(0, g.getCell(0, 0));
        assertEquals(3, g.getCell(0, 1));
        assertEquals(0, g.getCell(0, 2));
        assertEquals(3, g.getCell(0, 3));
        assertEquals(0, g.getCell(0, 4));
        assertEquals(0, g.getCell(5, 0));
        assertEquals(3, g.getCell(5, 1));
        assertEquals(3, g.getCell(5, 2));
        assertEquals(3, g.getCell(5, 3));
        assertEquals(0, g.getCell(0, 4));
    }

    @Test
    void gridTest2() {
        Grid g = new GameOfLife("/gameOfLifeGlider", "Glider");
        assertEquals(0, g.getCell(0, 0));
        assertEquals(0, g.getCell(0, 1));
        assertEquals(1, g.getCell(0, 2));
        assertEquals(1, g.getCell(1, 0));
        assertEquals(0, g.getCell(1, 1));
        assertEquals(1, g.getCell(1, 2));
        assertEquals(0, g.getCell(2, 0));
        assertEquals(1, g.getCell(2, 1));
        assertEquals(1, g.getCell(2, 2));
    }

    @Test
    void neighboursTest1() {
        Grid g = new GameOfLife("/gameOfLifeGlider", "Glider");
        assertEquals(1, g.neighboursCount(0, 0, 1));
        assertEquals(3, g.neighboursCount(1, 1, 0));
        assertEquals(5, g.neighboursCount(1, 1, 1));
        assertEquals(2, g.neighboursCount(2, 2, 1));
        assertEquals(1, g.neighboursCount(2, 2, 0));
    }

    @Test
    void neighboursTest2() {
        Grid g = new Wireworld("/wireGateAND", "AND gate");
        assertEquals(4, g.neighboursCount(7, 3, 0));
        assertEquals(0, g.neighboursCount(7, 3, 1));
        assertEquals(0, g.neighboursCount(7, 3, 2));
        assertEquals(4, g.neighboursCount(7, 3, 3));
        assertEquals(3, g.neighboursCount(4, 7, 0));
        assertEquals(0, g.neighboursCount(4, 7, 1));
        assertEquals(0, g.neighboursCount(4, 7, 2));
        assertEquals(2, g.neighboursCount(4, 7, 3));
    }

    @Test
    void nextGenTest1() {
        Grid g = new GameOfLife("/gameOfLifeGlider", "Glider");
        g = g.nextGen();
        assertEquals(0, g.getCell(0, 0));
        assertEquals(1, g.getCell(0, 1));
        assertEquals(0, g.getCell(0, 2));
        assertEquals(0, g.getCell(1, 0));
        assertEquals(0, g.getCell(1, 1));
        assertEquals(1, g.getCell(1, 2));
        assertEquals(0, g.getCell(2, 0));
        assertEquals(1, g.getCell(2, 1));
        assertEquals(1, g.getCell(2, 2));
    }

    @Test
    void nextGenTest2() {
        Grid g = new Wireworld("/wireGateAND", "AND gate");
        g.setCell(0, 0, 1);
        g.setCell(0, 3, 1);
        assertEquals(3, g.getCell(19, 4));
        for (int i = 0; i < 23; i++)
            g = g.nextGen();
        assertEquals(1, g.getCell(19, 4));
        assertEquals(2, g.getCell(18, 4));
        assertEquals(3, g.getCell(0, 0));
        assertEquals(3, g.getCell(3, 0));
    }

}