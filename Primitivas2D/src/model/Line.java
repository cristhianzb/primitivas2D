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
	
	public ArrayList<Point> bresenham(){	//(int x0, int y0, int x1, int y1)
	x0= p1.x;   y0 = p1.y;    x1 = p2.x;     y1 = p2.y;
        ArrayList<Point> arr = new ArrayList<Point>();        
        int  ix, iy, x, y, dx, dy, p, deltaA, deltaB;
        dx = Math.abs(x1 - x0);
        dy = Math.abs(y1 - y0);
        x = x0; y = y0;
        
        if (x1 >= x0) ix = 1;
        else ix = -1;
        
        if(y1 >= y0) iy = 1;
        else iy = -1;
        
        /*1er/4to / 5to/8vo octante] */
        if(dx >= dy){                   
            p = 2*dy - dx;            
            deltaA = 2*dy;
            deltaB = 2*(dy-dx);
            while ((x >= x1 && ix== -1 )|| (x <= x1 && ix == 1 ))
            {
                arr.add(new Point(x,y));
                System.out.println(x+" "+y);
                x = x + ix;
                if (p >= 0){
                    y = y + iy;
                    p = p + deltaB;
                }
                else {
                    p = p + deltaA;
                }
            }
        }
        /*2do/3ro / 6to/7mo octante] */
        else{      
            p = 2*dx - dy;            
            deltaA = 2*dx;
            deltaB = 2*(dx-dy);
            while ((y >= y1 && iy== -1 )|| (y <= y1 && iy == 1 ))
            {
                arr.add(new Point(x,y));
                System.out.println(x+" "+y);
                y = y + iy;
                if (p >= 0){
                    x = x + ix;
                    p = p + deltaB;
                }
                else {
                    p = p + deltaA;
                }
            }
        }
        return arr;
        }
	
	public ArrayList<Point> DDA(){		//(Point p1,Point p2)
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
