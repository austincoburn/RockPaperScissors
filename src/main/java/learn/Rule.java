package learn;

import java.util.Random;

public class Rule {
    private int userScore = 0;
    private int computerScore = 0;
    private int currentRound = 0;
    private int maxRounds = 3;

    public int getUserScore() {
        return userScore;
    }

    public int getComputerScore() {
        return computerScore;
    }

    public Move generateComputerMove() {
        Random random = new Random();
        return Move.values()[random.nextInt(3) + 1];
    }

    public String compare(String userMoveStr) {
        currentRound++;
        userMoveStr = userMoveStr.toUpperCase();
        Move userMove;

        userMove = Move.valueOf(userMoveStr);
        Move compMove = generateComputerMove();

        switch(userMove) {
            case ROCK:
                if(compMove == Move.PAPER) {
                    computerScore++;
                    return "Lost";
                } else if (compMove == Move.SCISSORS) {
                    userScore++;
                    return "Win";
                }
                break;
            case PAPER:
                if(compMove == Move.SCISSORS) {
                    computerScore++;
                    return "Lost";
                } else if (compMove == Move.ROCK) {
                    userScore++;
                    return "Win";
                }
                break;
            case SCISSORS:
                if(compMove == Move.ROCK) {
                    computerScore++;
                    return "Lost";
                } else if (compMove == Move.PAPER) {
                    userScore++;
                    return "Win";
                }
                break;
            default:
                return "Not a valid move";
        }
    return "Tie";
    }

}
