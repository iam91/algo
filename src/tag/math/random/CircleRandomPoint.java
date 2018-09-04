package tag.math.random;

import java.util.Random;

public class CircleRandomPoint {
    // https://leetcode.com/problems/generate-random-point-in-a-circle/description/
    private double radius;
    private double x_center;
    private double y_center;
    private Random rnd;

    public CircleRandomPoint(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
        this.rnd = new Random();
    }

    public double[] randPoint() {
        double[] res = new double[2];
        double x, y;
        do {

            x = (this.rnd.nextDouble() - 0.5) * 2 * this.radius;
            y = (this.rnd.nextDouble() - 0.5) * 2 * this.radius;

            res[0] = x + this.x_center;
            res[1] = y + this.y_center;
        } while(x * x + y * y > this.radius * this.radius);
        return res;
    }

}
