package com.example.demo.controller.game.dice;

import com.example.demo.entity.game.dice.Dice;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@Log
@RestController
// RequestMapping을 맨 위에 걸어서
// 아래의 /diceTest는 실제로 /game/diceTest 형식의 URL로 요청해야 한다.
// 앞에 /game 이 반복적으로 온다면 귀찮은 작업을 피하기 위해 이와 같이 작업을 하는 편이다.
@RequestMapping("/game")
public class DiceGameQuizController {

    static final Random rand = new Random();

    @GetMapping("/diceTest")
    public Dice getDiceTest() {
        log.info("getDiceTest()");

        Dice d = new Dice();
        d.setRandNum(rand.nextInt(3) + 1);  // 0 ~ 2 -> 1 ~ 3
        d.playDiceGame();

        return d;
    }
}
