import java.awt.*;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by gustavvalentin on 31/10/2016
 */
public class FloodFill {

	private enum Direction {
		NORTH(0, 1), SOUTH(0, -1), EAST(1, 0), WEST(-1, 0);

		private final int x, y;

		Direction(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}
		
		public Point derive(Point point) {
			return new Point(point.x + getX(), point.y + getY());
		}
	}

	private List<Point> flood() {
		final List<Point> points = new ArrayList<Point>();

		flood(points, new Point(5, 5), new Condition() {
			@Override
			public boolean accept() {
				return points.size() > 100;
			}
		}, new Filter<Point>() {
			@Override
			public boolean accept(Point point) {
				return true;
			}
		});

		return points;
	}

	private void flood(List<Point> points, Point start, Condition stopCondition, Filter<Point> filter) {
		if (points.contains(start) || stopCondition.accept()) {
			return;
		}

		points.add(start);
		
		for (Direction direction : Direction.values()) {
			Point derived = direction.derive(start);

			if (points.contains(derived) || !filter.accept(derived)) {
				continue;
			}

			flood(points, derived, stopCondition, filter);
		}
	}

	private interface Condition {
		boolean accept();
	}

	private interface Filter<T> {
		boolean accept(T t);
	}

	public static void main(String[] args) {
		FloodFill floodFill = new FloodFill();
		
		List<Point> test = floodFill.flood();
		
		System.out.println(test);
	}
}
