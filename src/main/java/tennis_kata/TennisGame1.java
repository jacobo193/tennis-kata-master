package tennis_kata;

public class TennisGame1 implements TennisGame {

    private int scorePlayer1 = 0;
    private int scorePlayer2 = 0;

    private final String player1Name;
    private final String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    @Override
    public void wonPoint(String playerName) {
        if (player1Name.equals(playerName))
            scorePlayer1 += 1;
        else
            scorePlayer2 += 1;
    }

    @Override
    public String getScore() {
        String score;

        if (scorePlayer1 == scorePlayer2) {
            score = getScoreWhenDraw();
        } else if (scorePlayer1 >= 4 || scorePlayer2 >= 4) {
            score = getScoreWhen4Points();
        } else {
            score = getScoreOtherCase();
        }

        return score;
    }

    private String getScoreOtherCase() {
        final String scorePlayer1 = getScoreText(this.scorePlayer1);
        final String scorePlayer2 = getScoreText(this.scorePlayer2);

        return scorePlayer1 + "-" + scorePlayer2;
    }

    private String getScoreText(int score) {
        final String scoreText;

        switch (score) {
            case 0:
                scoreText = "Love";
                break;
            case 1:
                scoreText = "Fifteen";
                break;
            case 2:
                scoreText = "Thirty";
                break;
            case 3:
                scoreText = "Forty";
                break;
            default:
                scoreText = "";
                break;
        }

        return scoreText;
    }

    private String getScoreWhen4Points() {
        final int minusResult = scorePlayer1 - scorePlayer2;
        String score;

        if (minusResult == 1)
            score = "Advantage player1";
        else if (minusResult == -1)
            score =  "Advantage player2";
        else if (minusResult >= 2)
            score =  "Win for player1";
        else
            score = "Win for player2";

        return score;

    }

    private String getScoreWhenDraw() {
        switch (scorePlayer1) {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            default:
                return "Deuce";
        }
    }
}
