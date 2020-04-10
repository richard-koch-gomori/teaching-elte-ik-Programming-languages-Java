public enum TelevisionShop{
    SAMSUNG(3, 60, 80),
    LG(4, 20, 125),
    SKYWORTH(5, 40, 100),
    SONY(10, 70, 120),
    SHARP(2, 80, 150);

    private int inStock;
    private final int diagMin;
    private final int diagMax;

    TelevisionShop(int inStock, int diagMin, int diagMax){		//Nem lehet public.
        this.inStock=inStock;									//Ki KELL írni a this-eket.
        this.diagMin=diagMin;
        this.diagMax=diagMax;
    }

    public int getDiagMin(){
        return diagMin;
    }

    public int getDiagMax(){
        return diagMax;
    }

    //Összes közül a legkisebb és legnyagyobb kapható tv.
    public static TelevisionShop smallestTV(){
        TelevisionShop smallestTV=null;
        for(TelevisionShop currentTV : TelevisionShop.values()){
            if(currentTV.ordinal() == 0){
                smallestTV = currentTV;
                } else if(currentTV.diagMin < smallestTV.diagMin){
                smallestTV = currentTV;
            }
        }
        return smallestTV;
    }

    public static TelevisionShop biggestTV(){
        TelevisionShop biggestTV=null;
        for(TelevisionShop currentTV : TelevisionShop.values()){
            if(currentTV.ordinal() == 0){
                biggestTV = currentTV;
            } else if(currentTV.diagMax > biggestTV.diagMax){
                biggestTV = currentTV;
            }
        }
        return biggestTV;
    }

    //Adott márkából mekkora mérető TV-k vannak.
    public static void sizesOfThisBrand(String brand){
        System.out.println( "TV-s from " + TelevisionShop.valueOf(brand) + " are available in " + TelevisionShop.valueOf(brand).diagMin + "-" + TelevisionShop.valueOf(brand).diagMax + " inch sizes.");
    }

    //Kiírja az jelenlegi teljes készletet.
    public static void listAllInvertory(){
        for(TelevisionShop currentTV : TelevisionShop.values()){
            System.out.println( currentTV.name() + ": " + currentTV.inStock + " available between " + currentTV.diagMin + "-" + currentTV.diagMax + " inches of size.");
        }
    }

    //Main függvény
    public static void main(String[] args){
        TelevisionShop smallestTV = TelevisionShop.smallestTV();
        System.out.println("The smallest TV available is a " + smallestTV.getDiagMin() + "inch from " + smallestTV.name());
        System.out.println();

        TelevisionShop biggestTV = TelevisionShop.biggestTV();
        System.out.println("The biggest TV available is a " + biggestTV.getDiagMax() + "inch from " + biggestTV.name());
        System.out.println();

        TelevisionShop.sizesOfThisBrand("SAMSUNG");
        TelevisionShop.sizesOfThisBrand("LG");
        TelevisionShop.sizesOfThisBrand("SKYWORTH");
        TelevisionShop.sizesOfThisBrand("SONY");
        TelevisionShop.sizesOfThisBrand("SHARP");
        System.out.println();

        TelevisionShop.listAllInvertory();
    }
}