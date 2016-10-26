package com.msnishan.lab;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

/**
 * Created by ksaleh on 10/1/16.
 */

/*
*       8  *0123456789*
*       7  *          *
*       6  * w        *
*       5  * i        *
*       4  * n        *
*       3  * 1      0 *
*       2  * 1      0 *
*       1  * 1      0 *
*       0  ************
*/
public class Game {

    private int rows;
    private int columns;

    public enum Player {
        EIGHT(8), NINE(9);
        private int value;
        Player(int value) {
            this.value = value;
        }
    }

    //private int[][] bucket = new int[rows][columns];

    public void submit(Player player, int[][] bucket) {
        Player opponent = getOpponent(player);
        if (isFirstMove(bucket)) {
            int pos = ThreadLocalRandom.current().nextInt(0, bucket[0].length + 1);
            bucket[0][pos] = player.value;
            return;
        }


    }

    private boolean isFirstMove(int[][] bucket) {
        OptionalInt optionalInt = Arrays.stream(bucket[0])
                .filter( i -> i == Player.EIGHT.value || i == Player.NINE.value)
                .findFirst();
        return !optionalInt.isPresent();
    }

    private Player getOpponent(Player player) {
        return Arrays.stream(Player.values())
                .filter(p -> !p.equals(player))
                .findFirst().get();
    }

    private int[][] move(Player player, int column, int[][] bucket) {

        int emptyPos = IntStream.range(0, bucket[0].length)
                    .filter(i -> bucket[i][column - 1] == 0)
                    .findFirst()
                    .getAsInt();

        bucket[emptyPos][column - 1] = player.value;
        return bucket;
    }

    private int findBestColumn(Player player, int[][] bucket) {
        return 0;//To-do...
    }

}
