package src.utils;
import java.util.Random;

public class Dice {
        private static final int sides = 20;
        private static final Random rand = new Random();
       /* public Dice (int sides){
            if(0 < sides && sides < 20){
                this.sides = sides;
            }
            else this.sides = 20;
        }*/

        public static int roll() {
            return rand.nextInt(sides) + 1;
        }
    }


