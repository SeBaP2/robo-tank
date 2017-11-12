package pl.seba;

import robocode.*;
import robocode.Robot;

import java.awt.*;
import java.util.Random;

public class SebasFirstRobot extends Robot {

    private static final Random RND = new Random();

    @Override
    public void run() {
        setupRobot();
        while (true) {
            takeTurn();
        }
    }

    private void takeTurn() {
        if (RND.nextBoolean()) {
            turnGunRight(360);
        } else {
            turnGunLeft(360);
        }
    }

    @Override
    public void onScannedRobot(ScannedRobotEvent e) {
        fire(3);
        turnGunLeft(0);

        if (RND.nextBoolean()) {
            turnRight(45);
        } else {
            turnLeft(45);
        }

        if (RND.nextBoolean()) {
            ahead(70);
        } else {
            back(70);
        }
    }

    @Override
    public void onHitByBullet(HitByBulletEvent e) {
        turnRight(90);
        back(100);
    }

    @Override
    public void onHitWall(HitWallEvent e) {
        turnLeft(30);
        back(200);
    }

    private void setupRobot() {
        final Color darkGreen = Color.getColor("397F00");
        final Color violet = Color.getColor("8300E8");
        setColors(darkGreen, Color.cyan, violet, Color.orange, Color.white);
        setGunColor(Color.pink);
    }
}
