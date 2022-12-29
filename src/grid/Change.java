package grid;

public class Change {
    public int row;
    public int column;
    public GridCell newGridCell;

    public Change(int row, int column, GridCell newGridCell) {
        this.row = row;
        this.column = column;
        this.newGridCell = newGridCell;
    }
}
