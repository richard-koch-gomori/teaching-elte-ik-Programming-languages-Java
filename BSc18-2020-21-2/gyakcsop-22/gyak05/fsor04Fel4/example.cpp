

#include <iostream>


class Foo
{
public:
    Foo() { std::cout << "Foo ctor" << std::endl; }
};


int main()
{
    Foo obj; // C++-ban a példányosított Foo objektum a stack-en tárolódik
}


