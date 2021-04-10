package com.bitbucket.painter_balls;

import com.bitbucket.painter_balls.view.BallsFrame;
import com.bitbucket.painter_balls.view.BallsPanel;
import com.bitbucket.painter_balls.view.BallsPanelMerge;

public class PainterBallRun {
    public static void main(String[] args) {
        BallsFrame ballsFrame = new BallsFrame(new BallsPanelMerge());
    }
}
