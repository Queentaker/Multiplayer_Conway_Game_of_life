import player.HumanPlayer;
import player.PlayersSignature;

public class Main {
    public static void main(String[] args) {
        System.out.println("welcome");
        HumanPlayer humanPlayer=new HumanPlayer("bob","#");
        PlayersSignature playersSignature=humanPlayer;
        System.out.println(playersSignature.getPlayerId());
    }
}
