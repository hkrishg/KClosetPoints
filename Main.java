import java.util.*;

// Given an array of points in the a 
// 2
// D
// 2D plane, find ‘K’ closest points to the origin.

// Example 1:

// Input: points = [[1,2],[1,3]], K = 1
// Output: [[1,2]]
// Explanation: The Euclidean distance between (1, 2) and the origin is sqrt(5).
// The Euclidean distance between (1, 3) and the origin is sqrt(10).
// Since sqrt(5) < sqrt(10), therefore (1, 2) is closer to the origin.

class Point {
  int x;
  int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int disFromOrigin() {
    return (x * x) + (y * y);
  }
  
}

class Main {

  public static List<Point> KClosestPoints(Point[] points, int k) {
    PriorityQueue<Point> maxHeap = new PriorityQueue<Point>((p1, p2) -> p2.disFromOrigin() - p1.disFromOrigin());

    // put first 'k' numbers in min heap
    for (int i = 0; i < k; i++)
      maxHeap.add(points[i]);

    for (int i = k; i < points.length; i++) {
      if (points[i].disFromOrigin() < maxHeap.peek().disFromOrigin()) {
        maxHeap.poll();
        maxHeap.add(points[i]);
      }
    }
    return new ArrayList<>(maxHeap);
  }

  public static void main(String[] args) {
    Point[] points = new Point[] { new Point(1, 3), new Point(3, 4), new Point(2, -1) };
    List<Point> result = Main.KClosestPoints(points, 2);
    for (Point p : result)
      System.out.println("[" + p.x + " , " + p.y + "] ");

  }
}