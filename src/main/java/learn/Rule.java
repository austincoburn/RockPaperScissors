package learn;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class Rule {
    private int userScore = 0;
    private int computerScore = 0;
    private int currentRound = 0;
    private int maxRounds = 3;
    private Move compMove;

    public int getUserScore() {
        return userScore;
    }

    public int getComputerScore() {
        return computerScore;
    }

    public Move getCompMove() {
        return compMove;
    }

    public int getCurrentRound() {
        return currentRound;
    }

    public Rule() {
    }

    public Move generateComputerMove() {
        Random random = new Random();
        Move move = Move.values()[random.nextInt(3)];
        System.out.println(move);
        return move;
    }

    public String compare(String userMoveStr) {
        currentRound++;
        userMoveStr = userMoveStr.toUpperCase();
        Move userMove;

        userMove = Move.valueOf(userMoveStr);
        compMove = generateComputerMove();


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
