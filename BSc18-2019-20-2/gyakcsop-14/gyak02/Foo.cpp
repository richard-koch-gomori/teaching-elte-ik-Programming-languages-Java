// g++ class.cpp


#include <iostream>


class Foo
{
    public:
        // adattagok
        int x;
        int y;

        // tagfüggvények; elérik az adattagokat
        int add() { return x + y; }
};


int main()
{
    //int x = 2;
    //int* p = &x;

    //int* p = new int;

    // a Foo objektum a stack-en jön létre
    Foo f;

    // mezőhivatkozás: ponttal (.)
    f.x = 6;
    f.y = 10;

    // a Foo objektum a heap-en jön létre (mert new-al hoztuk létre)
    Foo* p = new Foo;
    //(*p).x = 12;
    p->x = 12;
    p->y = 10;

    std::cout << "p->x = " << p->x << std::endl;
    std::cout << "add: " << p->add() << std::endl;

    // a Foo objektum felszabadítása
    delete p;

    return 0;
}
