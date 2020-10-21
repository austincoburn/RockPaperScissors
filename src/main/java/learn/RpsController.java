package learn;

import org.springframework.web.bind.annotation.*;

@RestController
public class RpsController {

    Rule rule;

//    public RpsController(Rule rule) {
//        this.rule = rule;
//    }

    @PostMapping("/")
    public void startGame(){
        rule = new Rule();
    }

    @PutMapping("/{userMove}")
    public String performMove(@PathVariable String userMove) {
        String result = rule.compare(userMove);
        return String.format("Round: %s%nComputers move is %s%nUser %s%n", rule.getCurrentRound(), rule.getCompMove(), result);
    }

    @GetMapping("/score")
    public String getScore() {
        return String.format("Total Rounds: %s%nPlayer Score: %s%nComputer Score: %s%n", rule.getCurrentRound(), rule.getUserScore(), rule.getComputerScore());
    }
}
