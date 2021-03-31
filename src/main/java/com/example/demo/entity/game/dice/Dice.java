package com.example.demo.entity.game.dice;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
public class Dice {
    // 사용자 주사위
    private Integer userDiceNum = 0;
    // 컴퓨터 주사위
    private Integer compDiceNum = 0;
    // 몇번 굴릴까
    private Integer randNum;

    private static final Random rand = new Random();

    public void playDiceGame() {
        for(int i = 0; i < randNum; i++) {
            userDiceNum += rand.nextInt(6) + 1; // 1 ~ 6
            compDiceNum += rand.nextInt(6) + 1;
        }
    }
}
