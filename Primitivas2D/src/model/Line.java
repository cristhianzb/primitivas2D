package model;

import java.awt.Point;
import java.util.ArrayList;

public class Line {
	private Point p1;
	private Point p2;
	
	public Line(Point p1, Point p2){
		this.p1=p1;
		this.p2=p2;
	}
	
	public ArrayList<Point> DDA(Point p1,Point p2){
		ArrayList<Point> list = new ArrayList<Point>();
		int dx = p2.x-p1.x;
		int dy = p2.y-p1.y;
		double m = (1.0*dy)/dx;
		int inc,x,y;
		x = p1.x;
		y = p1.y;
		list.add(p1);
		if(Math.abs(dx)>Math.abs(dy)){
			if(dx>0){
				inc = 1;
			}else{
				inc = -1;
			}
			int times = 1;
			while(x!=p2.x && y!=p2.y){
				x = x + inc;
				y = (int) Math.round(p1.y + times*m);
				times++;
				list.add(new Point(x,y));
			}
		}else{
			if(dy>0){
				inc = 1;
			}else{
				inc = -1;
			}
			int times = 1;
			while(x!=p2.x && y!=p2.y){
				y = y + inc;
				x = (int) Math.round(p1.x + times*(1/m));
				times++;
				list.add(new Point(x,y));
			}		
		}
		list.add(p2);
		return list;
	}
	
}
