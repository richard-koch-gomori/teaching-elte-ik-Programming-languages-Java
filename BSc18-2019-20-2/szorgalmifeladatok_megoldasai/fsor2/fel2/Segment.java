class Segment {
    double x1, y1, x2, y2;

    Line line(){
        Line line = new Line();
        if( x1 == x2 ){
            line.b = 1.0;
            line.a = (y2 - y1) / (x1 - x2);
        } else
            line.a = 1.0;
            line.b = (x1 - x2) / (y2 - y1);
        }
        line.c = line.a * x1 + line.b * y1;
        return line;
    }

    boolean contains( Point p ){
        return line().contains(p) && 
               ((x1 <= p.x && p.x <= x2) || (x1 >= p.x && p.x >= x2) ) &&
               ((y1 <= p.y && p.y <= y2) || (y1 >= p.y && p.y >= y2) ) ;
    }

    double orientation( Point p ){
        return (y2 - y1)*(p.x - x2) - (p.y - y2)*(x2 - x1);
    }

    boolean intersects( Segment that ){
        Line thisLine = this.line();
        Line thatLine = that.line();
        if( thisLine.isParallelWith( thatLine ) ){
            return false;
        } else {
            Point intersection = thisLine.intersectionWith(thatLine);
            return this.contains(intersection) && that.contains(intersection);
        }
    }
}
