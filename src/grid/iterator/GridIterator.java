package grid.iterator;

import grid.GridCell;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

public class GridIterator implements Iterator<ArrayList<GridCell>> {
    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public ArrayList<GridCell> next() {
        return null;
    }
}
