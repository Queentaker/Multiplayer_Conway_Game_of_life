import GUI.Frame;
import player.HumanPlayer;
import player.PlayersSignature;
import player.Signature;

public class Main {
    public static void main(String[] args) {
        new Frame();
        System.out.println("welcome");
        PlayersSignature playersSignature= new HumanPlayer("bob","#");
        System.out.println(playersSignature.getPlayerId());
        System.out.println(Signature.Signature2.id);
        System.out.println(Signature.Signature2.id);
    }
}
