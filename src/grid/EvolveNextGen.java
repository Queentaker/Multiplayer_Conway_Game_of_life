package grid;

public class EvolveNextGen {
    private Grid beforeEvolution;
    public void evolve(Grid grid){
        beforeEvolution= new Grid(grid);
    }
    private int getAliveNeighbors(){
        return 0;
    }
}
