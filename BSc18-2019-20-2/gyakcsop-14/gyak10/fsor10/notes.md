## változó statikus/dinamikus típusa

~~~{.java}
Book book;

book = new Book();
// book statikus típusa Book, dinamikus típusa Book
System.out.println(book.toString()); // Book toString()-je

book = new PrintedBook("author", "Printed: Title", 100, CoverType.Softcover);
// book statikus típusa Book, dinamikus típusa PrintedBook
System.out.println(book.toString()); // PrintedBook toString()-je
~~~


statikus típus: a változó deklarált típusa, ez egy változó esetén nem változhat meg
dinamikus típus: bármikor megváltozhat, lényegében az az osztály, amelyre éppen mutat a referencia


## virtuális metódusok

C++-ban `virtual` kulcsszó, Java-ban minden metódus virtuális

ha egy metódus virtuális, akkor a leszármazott osztályokban felüldefiniáható  
ekkor futási időben dől el, hogy a metódus mely változatát kell meghívni (a dinamikus típus alapján)

