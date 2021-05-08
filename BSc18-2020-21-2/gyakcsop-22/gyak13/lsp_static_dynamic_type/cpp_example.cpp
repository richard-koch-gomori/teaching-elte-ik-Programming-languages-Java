

#include <iostream>


class Base
{
public:
    /*virtual*/ void foo()
    {
        std::cout << "Base::foo()" << std::endl;
    }
};

class Derived : public Base
{
public:
    void foo() //override
    {
        std::cout << "Derived::foo()" << std::endl;
    }
};

int main()
{
    Base* base = new Derived();
    base->foo();
}


