package tennis_kata;

public class TennisGame3 implements TennisGame {

    private int scorePlayer1;
    private int scorePlayer2;

    private final String player1Name;
    private final String player2Name;

    public TennisGame3(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (player1Name.equals(playerName))
            this.scorePlayer2 += 1;
        else
            this.scorePlayer1 += 1;
    }

    public String getScore() {
        if (isScoreLessThan4()) {
            return getScoreWhenPointAreLessThan4();
        } else {
            return getScoreWhenPointReach4();
        }
    }

    private boolean isScoreLessThan4() {
        return scorePlayer2 < 4 && scorePlayer1 < 4 && (scorePlayer2 + scorePlayer1) != 6;
    }

    private String getScoreWhenPointAreLessThan4() {
        final String[] possibleScores = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
        final String score = possibleScores[scorePlayer2];
        return (scorePlayer2 == scorePlayer1) ? score + "-All" : score + "-" + possibleScores[scorePlayer1];
    }

    private String getScoreWhenPointReach4() {
        final String score;

        if (scorePlayer2 == scorePlayer1) {
            score = "Deuce";
        } else {
            final String playerName = scorePlayer2 > scorePlayer1 ?
                    player1Name : player2Name;

            score = isAdvantageForPlayer() ?
                    "Advantage " + playerName : "Win for " + playerName;
        }

        return score;
    }

    private boolean isAdvantageForPlayer() {
        return (scorePlayer2 - scorePlayer1) * (scorePlayer2 - scorePlayer1) == 1;
    }


}
