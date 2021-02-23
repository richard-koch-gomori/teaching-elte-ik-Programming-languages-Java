// fordítási egység: önállóan lefordítható forrásfájl


class Point
{
    int x;
    int y;

    void move(int dx, int dy)
    {
        x += dx;
        y += dy;
    }

    void mirror(Point center)
    {
        x = 2*center.x - x;
        y = 2*center.y - y;
    }

    double distance(Point p)
    {
        return Math.sqrt(Math.pow(x - p.x, 2) + Math.pow(y - p.y, 2));
    }
};

