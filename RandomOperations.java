package com.company;

import java.util.Random;

public class RandomOperations {

    public static String randomDecission(int x, int y) {
        String output = "";
        Random random = new Random();
        int male = 0;
        int female = 0;
        while (male != x || female != y) {
            int randomNumber = random.nextInt(2);
            switch (randomNumber) {
                case 0:
                    if (male < x) {
                        output = output.concat("M");
                        male++;
                    }
                    break;
                case 1:
                    if (female < y) {
                        output  = output.concat("F");
                        female++;
                    }
                    break;
            }
        }
        return output;
    }


        public static void RandomSleep(int max) {
        Random random = new Random();
        int x = 1 + random.nextInt(2);
        try {
            Thread.sleep((int) (x * max));
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}
