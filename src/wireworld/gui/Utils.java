package wireworld.gui;

import wireworld.Manager;
import wireworld.logic.Grid;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Utils {

    public static BufferedImage getImage(Grid g) {
        BufferedImage img = new BufferedImage(g.getWidth(), g.getHeight(), BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < g.getWidth(); x++)
            for (int y = 0; y < g.getHeight(); y++) {
                if (Manager.getInstance().getMode() == 0) {
                    switch (g.getCell(x, y)) {
                        case 0:
                            img.setRGB(x, y, Color.WHITE.getRGB());
                            break;
                        case 1:
                            img.setRGB(x, y, Color.ORANGE.getRGB());
                            break;
                        case 2:
                            img.setRGB(x, y, Color.BLUE.getRGB());
                            break;
                        case 3:
                            img.setRGB(x, y, Color.BLACK.getRGB());
                            break;
                    }
                } else if (Manager.getInstance().getMode() == 1) {
                    switch (g.getCell(x, y)) {
                        case 0:
                            img.setRGB(x, y, Color.BLACK.getRGB());
                            break;
                        case 1:
                            img.setRGB(x, y, Color.WHITE.getRGB());
                            break;
                    }
                }
            }
        return img;
    }

}
