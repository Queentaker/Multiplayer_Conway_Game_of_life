package grid.startingTemplates;

import grid.Grid;

public class GridToString {

    public static String gridToString(Grid grid) {
        StringBuilder returnString = new StringBuilder();
        for (int y = 0; y < grid.getGridHeight(); y++) {
            for (int x = 0; x < grid.getGridWidth(); x ++) {
                if(grid.getGridCell(x,y).isOccupied()) {
                    returnString.append("x");
                } else {
                    returnString.append("o");
                }
            }
            returnString.append("\n");
        }
        return returnString.toString();
    }
}
