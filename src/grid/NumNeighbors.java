package grid;

import java.util.HashMap;
import java.util.Map;

public enum NumNeighbors {

    Zero(0),
    One(1),
    Two(2),
    Three(3),
    Four(4),
    Five(5),
    Six(6),
    Seven(7),
    Eight(8);

    public final int value;
    private static final Map<Integer,NumNeighbors> map=new HashMap<>();

    NumNeighbors(int value){
        this.value=value;
    }
    static {
        for (NumNeighbors numNeighbors: NumNeighbors.values()){
            map.put(numNeighbors.value,numNeighbors);
        }
    }
    public static NumNeighbors getEnum(int value){
        return map.get(value);
    }

}
