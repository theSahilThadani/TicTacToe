package Models;

public class Bot extends Player{
    private BotDifficultyLevel botDifficultyLevel;

    public Bot(Sysmbol sysmbol, String name, BotDifficultyLevel botDifficultyLevel) {
        super(sysmbol, name, PlayerType.BOT);
        this.botDifficultyLevel = botDifficultyLevel;
    }

    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }
}
