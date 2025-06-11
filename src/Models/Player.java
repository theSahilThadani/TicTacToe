package Models;

public class Player {
    private Symbol symbol;
    private String name;
    private PlayerType playerType;

    public Player(Symbol symbol, String name, PlayerType playerType) {
        this.symbol = symbol;
        this.name = name;
        this.playerType = playerType;
    }
    //methods
    public Cell makeMove(){
        return null;
    }

    //getter setters
    public Symbol getSysmbol() {
        return symbol;
    }

    public void setSysmbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }
}
