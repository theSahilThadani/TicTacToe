package Models;

public class Player {
    private Sysmbol sysmbol;
    private String name;
    private PlayerType playerType;

    public Player(Sysmbol sysmbol, String name, PlayerType playerType) {
        this.sysmbol = sysmbol;
        this.name = name;
        this.playerType = playerType;
    }

    public Sysmbol getSysmbol() {
        return sysmbol;
    }

    public void setSysmbol(Sysmbol sysmbol) {
        this.sysmbol = sysmbol;
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
