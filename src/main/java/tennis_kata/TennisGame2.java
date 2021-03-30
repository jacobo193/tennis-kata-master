package tennis_kata;

public class TennisGame2 implements TennisGame {

    public static final String FIFTEEN = "Fifteen";
    public static final String THIRTY = "Thirty";
    public static final String FORTY = "Forty";
    public static final String LOVE = "Love";

    private int player1Points = 0;
    private int player2Points = 0;

    private final String player1Name;
    private final String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    @Override
    public void wonPoint(String player) {
        if (player1Name.equals(player))
            addScorePlayer1();
        else
            addScorePlayer2();
    }

    private void addScorePlayer1() {
        player1Points++;
    }

    private void addScorePlayer2() {
        player2Points++;
    }

    @Override
    public String getScore() {
        String score = "";

        if (player1Points == player2Points)  {
            score = getScoreWhenDraw();
        }

        if (hasOnePlayer0Points(player1Points, player2Points)) {
            final String player1result = getScorePlayer(player1Points);
            score = player1result + "-" + LOVE;
        }

        if (hasOnePlayer0Points(player2Points, player1Points)) {
            final String player2result = getScorePlayer(player2Points);
            score = LOVE + "-" + player2result;
        }

        if (isOnePlayerAhead()) {
            final String player1result = getScorePlayer(player1Points);
            final String player2result = getScorePlayer(player2Points);
            score = player1result + "-" + player2result;
        }

        if (isAdvantageForPlayer(player1Points, player2Points)) {
            score = "Advantage player1";
        }

        if (isAdvantageForPlayer(player2Points, player1Points)) {
            score = "Advantage player2";
        }

        if (isWinForPlayer(player1Points, player2Points)) {
            score = "Win for player1";
        }

        if (isWinForPlayer(player2Points, player1Points)) {
            score = "Win for player2";
        }

        return score;
    }

    private String getScoreWhenDraw() {
        String score = "";
        if (player1Points < 4) {
            score = getScorePlayer(player1Points);
            score += "-All";
        }

        if (player1Points >= 3)
            score = "Deuce";

        return score;
    }

    private boolean hasOnePlayer0Points(int playerAPoints, int playerBPoints) {
        return playerAPoints > 0 && playerBPoints == 0;
    }

    private boolean isOnePlayerAhead() {
        return (player1Points > player2Points && player1Points < 4)
                || (player2Points > player1Points && player2Points < 4);
    }

    private boolean isAdvantageForPlayer(int playerAPoints, int playerBPoints) {
        return playerAPoints > playerBPoints && playerBPoints >= 3;
    }

    private boolean isWinForPlayer(int playerAPoints, int playerBPoints) {
        int pointsDifference = (playerAPoints - playerBPoints);
        return playerAPoints >= 4 && playerBPoints >= 0 && pointsDifference >= 2;
    }

    private String getScorePlayer(int playerPoints) {
        final String playerResults;

        switch (playerPoints) {
            case 0:
                playerResults = LOVE;
                break;

            case 1:
                playerResults = FIFTEEN;
                break;

            case 2:
                playerResults = THIRTY;
                break;

            case 3:
                playerResults = FORTY;
                break;

            default:
                playerResults = "";
                break;
        }

        return playerResults;
    }
}