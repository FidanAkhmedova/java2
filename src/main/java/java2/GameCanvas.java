package java2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameCanvas extends JPanel{
    private long lastFrameTime;
    private MainCircles controller;
    private int counter;
    private JButton deletebtn;
    private JButton addbtn;

    GameCanvas(MainCircles controller) {
        lastFrameTime = System.nanoTime();
        this.controller = controller;


        deletebtn = new JButton("delete");
        addbtn = new JButton("add");

        deletebtn.setSize(40, 40);
        deletebtn.setText("delete");
        deletebtn.setVisible(true);

        addbtn.setSize(80, 80);
        addbtn.setText("add");

        addbtn.setVisible(true);

        this.add(addbtn);
        this.add(deletebtn);
        ActionListener actionListener = controller;
        addbtn.addActionListener(actionListener);
        deletebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if (MainCircles.count != 0) {
                       MainCircles.ballsCount--;
                       System.out.println(MainCircles.ballsCount);
                       Ball[] newBalls = new Ball[MainCircles.ballsCount];
                       System.arraycopy(MainCircles.balls, 0, newBalls, 0, MainCircles.balls.length - 1);
                       MainCircles.balls = newBalls;
                       MainCircles.count--;
                       System.out.println("-- = " + MainCircles.balls.length);
               }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) { // do
        super.paintComponent(g); // {
        // no payload = 250fps
        long currentTime = System.nanoTime();
        float deltaTime = (currentTime - lastFrameTime) * 0.000000001f;
        lastFrameTime = currentTime;
        controller.onDrawCanvas(this, g, deltaTime);
        counter++;
        if ( counter == Integer.MAX_VALUE){
            counter = 0;
        }
        Background.updateBackground(this, counter);
        try {
            Thread.sleep(16); // 1 / 60 frames = 16.(6) fps
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        repaint(); // } while (true);

    }

    public int getLeft() { return 0; }
    public int getRight() { return getWidth() - 1; }
    public int getTop() { return 0; }
    public int getBottom() { return getHeight() - 1; }
}