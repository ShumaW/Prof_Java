import java.util.*;

public class Main {

    /*
        Из заданного массива слов заполнить ArrayList( 1000 )
        случайными словами.
        Подсчитать сколько каждое слово встречается раз в ArrayList
        Вывести слово, которое повторяется чаще всего.
        Если таких слов несколько - вывести наименьшее из них.

        Массив слов получить из строки =

        “Не говори мне о толпе безумной
        Она иной раз вдохновение спугнёт
        Избавь меня от этой давки шумной
        Влекущей мощно в свой водоворот
        Нет тишины ищу я многодумный
        Лишь там поэту радость расцветёт
        Там только там божественною властью
        Любовь и дружба нас приводит к счастью”
         */
    public static void main(String[] args) {
        String text = """
                Не говори мне о толпе безумной 
                Она иной раз вдохновение спугнёт
                Избавь меня от этой давки шумной
                Влекущей мощно в свой водоворот
                Нет тишины ищу я многодумный
                Лишь там поэту радость расцветёт
                Там только там божественною властью
                Любовь и дружба нас приводит к счастью""";
        String[] arr = text.split("[\s\n\t\r]+");

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            int random = (int) (Math.random() * arr.length);
            list.add(arr[random].toLowerCase());
        }

        Map<String, Integer> map = new LinkedHashMap<>();

//        for (String s : list) {
//            map.merge(s, 1, Integer::sum);
//        }

        list.forEach((s) -> map.merge(s, 1, Integer::sum));

        List<Map.Entry<String, Integer>> list1 = new ArrayList<>(map.entrySet());

        list1.sort((o1,o2) -> {
            if (o1.getValue() == o2.getValue()) {
                return o1.getKey().compareTo(o2.getKey());
            }
            return o2.getValue() - o1.getValue();
        });

        System.out.println(list1);
        System.out.println(list1.get(0));

    }
}