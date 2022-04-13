package java2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainCircles extends JFrame implements ActionListener {
    private static final int POS_X = 280;
    private static final int POS_Y = 100;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;
    protected static int count = 10;
    protected static int ballsCount = 10;
    protected static Ball[] balls = new Ball[ballsCount];
   // private Ball[] sprites = new Ball[10];

    private void update(GameCanvas canvas, float deltaTime, Ball balls[]) {
        for (int i = 0; i < balls.length; i++) {
            if (balls[i] != null){
                balls[i].update(canvas, deltaTime);
            }
        }
    }

    private void render(GameCanvas canvas, Graphics g) {
        for (int i = 0; i < balls.length; i++) {
            if (balls[i] != null)
                balls[i].render(canvas, g);
        }
    }
    void onDrawCanvas(GameCanvas c, Graphics g, float deltaTime) {
        update(c, deltaTime, balls);
        render(c, g);
    }

    private void initApplication() {
        for (int i = 0; i < balls.length; i++) {
            balls[i] = new Ball();
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        ballsCount ++;
        int oldCount = balls.length;
        Ball[] newBalls = new Ball[ballsCount];
        System.arraycopy(this.balls, 0, newBalls, 0, this.balls.length);
        newBalls[oldCount] = new Ball();
        this.balls = newBalls;
        count++;
        //System.out.println("++ = " + balls.length);
    }


    private MainCircles() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Circles");
        GameCanvas canvas = new GameCanvas(this);
        add(canvas);
        initApplication();
        setVisible(true);

    }

    public static void main(String[] args) {
        new MainCircles();

    }

}