package player;

import java.util.UUID;

public enum Signature {

    // incase one wants to use enums
    // use predefined colors and id
    Signature1 ("red"),
    Signature2("blue"),
    Signature3("yellow"),
    Signature4("green");
    public final String color;
    public final String id;

    Signature(String color){
        this.color=color;
        this.id=UUID.randomUUID().toString();
    }
}
