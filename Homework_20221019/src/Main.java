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

        Goods[] goods = {
                new Produkts("Orange", 4.5, 10),
                new Produkts("Banane", 5.5, 10),
                new Electronics("Samsung TV", 560, 10, 0),
                new Mobile("iPhone 15", 300, 10, 100),
                new Clothes("T-shirt", 15),
                new Clothes("Trouthers", 25)
        };

        print(goods);


    }

    private static void print(Goods[] goods) {
        for (Goods g : goods) {
            g.getGoods();
        }
    }
}