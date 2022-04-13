package java2;
import java.util.Random;
import java.awt.*;

public class Background {
    private static Random rnd = new Random();
    private static Color color;

     public static void updateBackground(GameCanvas canvas, int counter){

         if (counter % 60 == 0 || counter == 0){
            color = new Color(rnd.nextInt());
            canvas.setBackground(color);
         }
    }


}
