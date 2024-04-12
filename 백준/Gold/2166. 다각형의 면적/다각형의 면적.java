import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static final int OFFSET = 100_000;
    public static int n;
    public static Point[] points;
    static class Point {
        public double x;
        public double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        points = new Point[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());

            points[i] = new Point(x, y);
        }

        System.out.printf("%.1f",getWidth());


    }

    public static double getWidth() {
        double width = 0;
        double a = 0;
        double b = 0;

        for (int i = 0; i < n-1; i++) {
            a = a + (points[i].x * points[i + 1].y);
        }
        a = a + points[n - 1].x * points[0].y;

        for (int i = 0; i < n-1; i++) {
            b += (points[i].y * points[i + 1].x);
        }
        b += points[0].x * points[n - 1].y;
        width = Math.abs(a - b);

        width *= 0.5;

        return width;
    }

}

