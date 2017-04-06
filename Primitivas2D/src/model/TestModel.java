package model;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.ArrayList;

import org.junit.Test;

public class TestModel {

	@Test
	public void testDDA() {
		Point p1 = new Point(2,3);
		Point p2 = new Point(8,1);
		ArrayList<Point> ans = new ArrayList<Point>();
		ans.add(p1);
		ans.add(new Point(3,3));
		ans.add(new Point(4,2));
		ans.add(new Point(5,2));
		ans.add(new Point(6,2));
		ans.add(new Point(7,1));
		ans.add(p2);
		Line line = new Line(p1,p2);
		ArrayList<Point> act = line.DDA(p1,p2);
		boolean bool = true;
		for(int i=0;i<ans.size();i++){
			bool = bool & (ans.get(i).equals(act.get(i)));
			System.out.println(act.get(i));
		}
		System.out.println(bool);
		assertTrue(bool);
	}

}
