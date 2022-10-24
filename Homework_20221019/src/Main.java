public class Main {
    public static void main(String[] args) {

        /*
        Допустим, у нас есть магазин. В нашем магазине есть товары трёх
        категорий: продукты, электроника(мобильные телефоны и ноутбуки),
        одежда. У каждого товара есть цена и наименование . Каждый товар
        можно купить (покупателю выставляется счет).
        при покупки продуктов выставляется дополнительная цена за срочность
        доставки.
        при покупке электроники, покупателю оформляют гарантию (т.е. при
        покупке должен выполнятся метод “Оформить гарантию”)
        телефоны продаются только с контрактом оператора (т.е. при покупке
        должен выполнятся метод “Оформить контракт”)
        Необходимо создать соответствующую структуру классов метод покупки товара
         */

        Goods p1 = new Produkts("Orange",4.5,10);
        Goods p2 = new Produkts("Banane",5.5,10);
        Goods e1 = new Electronics("Samsung TV",560,10,0);
        Goods m1 =new Electronics("iPhone 15",300,0,100);
        Goods cl1 = new Clothes("T-shirt",15);
        Goods cl2 =new Clothes("Trouthers",25);

        p1.getGoods();
        p2.getGoods();
        e1.getGoods();
        m1.getMobile();
        cl1.getGoods();
        cl2.getGoods();



    }
}