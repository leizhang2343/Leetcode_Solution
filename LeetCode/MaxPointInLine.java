package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;

public class MaxPointInLine {
	class Line{
		int k1,k2,b1,b2;
		Line(int k1,int k2,int b1,int b2){
			this.k1 = k1;
			this.k2 = k2;
			this.b1 = b1;
			this.b2 = b2;
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		@Override
		public boolean equals(Object obj) {
			// TODO Auto-generated method stub
			Line l = (Line)obj;
			if(this.k1 !=  l.k1){
				return false;
			}
			if(this.k2 !=  l.k2){
				return false;
			}
			if(this.b1 !=  l.b1){
				return false;
			}
			if(this.b2 !=  l.b2){
				return false;
			}
			
			return true;
		}

		
		
		@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			return k1 + k2 + b1 + b2;
		}
		
		public String toString(){
			return "k1:" + k1+", k2:"+k2+", b1:"+b1+", b2"+b2;
		}
		
	}
	
	public int maxPoints(Point[] points) {
		if(points.length < 2){
			return 0;
		}
        HashMap<Line,HashSet<Point>> allLines = new HashMap<Line,HashSet<Point>>();
        int max = 2;
        for(int i = 0; i < points.length -1;i++){
        	Point a = points[i];
            for(int j = i +1; j < points.length; j++){
            	Point b = points[j];
            	if(a != b){
            		Line line = getLine(a,b);
                    if(!allLines.containsKey(line)){
//                    	System.out.print(line);
                        HashSet<Point> tmp = new HashSet<Point>();
                        tmp.add(a);
                        tmp.add(b);
                        allLines.put(line,tmp);
                    }else{
                        allLines.get(line).add(a);
                        allLines.get(line).add(b);
                        int n = allLines.get(line).size();
                        if(n > max){
                            max = n;
                        }
                    }
                }
            }
        }
        
        return max;
    }
    
    Line getLine(Point a,Point b){
        if(a.x == b.x){
            Line line = new Line(0,0,a.x,0);
            return line;
        }else{
            int k1 = (b.y - a.y);
            int k2 = (b.x - a.x);
            int gcd_K = gcd(k1,k2);
            k1 = k1/gcd_K;
            k2 = k2/gcd_K;
            int b1 = -a.x*(b.y - a.y) + a.y*(b.x - a.x);
            int b2 = b.x - a.x;
            int gcd_B = gcd(b1,b2);
            b1 = b1/gcd_B;
            b2 = b2/gcd_B;
            if(b1 == 0){
            	b2 = 0;
            }
            Line line = new Line(k1,k2,b1,b2);
            return line;
        }
        
    }
    
    int gcd(int a, int b){
    	return b==0 ? a : gcd(b, a%b);
    }
    
    public static void main(String[] args) {
		MaxPointInLine aInLine = new MaxPointInLine();
		Point[] tPoints = {new Point(0,0),new Point(-1,-1),new Point(2,2)};
		System.out.println(aInLine.maxPoints(tPoints));
//		Line a = aInLine.new Line(1,2,3,4);
//		Line b = aInLine.new Line(1,2,3,4);
//		HashMap<Line,HashSet<Point>> allLines = new HashMap<Line,HashSet<Point>>();
//		allLines.put(a, null);
//		System.out.println(a.equals(b));
//		System.out.println(allLines.containsKey(b));
		
		 int deltaX =5;
         int deltaY = 3;
		 String key = deltaY == 0 ? "Horizontal" : String.format("%.5f", ((float) deltaX) / deltaY);
		 System.out.print(key);
		 
	}
}
