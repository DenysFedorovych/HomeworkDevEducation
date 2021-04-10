package com.bitbucket.painter_balls.view;

import java.util.List;

public class BallsController implements Runnable {

    private List<Ball> balls;

    private BallsPanelMerge panelMerge;

    public BallsController(List<Ball> balls, BallsPanelMerge panel) {
        this.balls = balls;
        this.panelMerge = panel;
    }

    @Override
    public void run() {
        try {
            while (true) {
                for (short i = 0; i < balls.size(); i++) {
                    for (int j = i + 1; j < balls.size(); j++) {
                        if (balls.get(i).intersect(balls.get(j))) {
                            panelMerge.mergeBalls(balls.get(i), balls.get(j));
                        }
                    }
                }
                Thread.sleep(15);
            }
        } catch (InterruptedException ignore) {
        }
    }

}
