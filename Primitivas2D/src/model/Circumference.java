package model;

public class Circunferencia {
	
	public ArrayList<Point> polar(int h, int k, int r){     //oso polar :^)
        ArrayList<Point> poi = new ArrayList<Point>();
        final double lim = Math.PI/4;
        int x = r, y = 0;
        double ang = 0, inc = 1.0/r;
        Set<Point> p = new HashSet<Point>();
        while(ang < lim){
            p.add(new Point(h+x, k+y)); //1er
            p.add(new Point(h-x, k+y)); //4to
            p.add(new Point(h-x, k-y)); //5to
            p.add(new Point(h+x, k-y)); //8vo
            p.add(new Point(h+y, k+x)); //2do
            p.add(new Point(h-y, k+x)); // 3er
            p.add(new Point(h-y, k-x)); // 6to
            p.add(new Point(h+y, k-x)); // 7mo
            ang = ang + inc;
            x = (int)Math.round(r*Math.cos(ang));
            y = (int)Math.round(r*Math.sin(ang));
        }
        poi.addAll(p);
        return poi;
    }
}
