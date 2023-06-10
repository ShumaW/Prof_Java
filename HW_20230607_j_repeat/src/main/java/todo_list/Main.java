package todo_list;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


/**
 * Запустите программу и убедитесь, что вывод содержит правильные данные и отражает состояние задач (выполнена
 * или невыполнена).
 */

public class Main {
    public static void main(String[] args) {

        // Напишите код, чтобы создать несколько экземпляров класса Task и добавить их в TaskManager.

        TaskManager taskManager = new TaskManager();
        taskManager.addTask(new Task("Task 1","this is task one", false));
        taskManager.addTask(new Task("Task 2","this is task two", true));
        taskManager.addTask(new Task("Task 3","this is task three", true));
        taskManager.addTask(new Task("Task 4","this is task four", false));

        // Используя циклы (например, цикл for-each), переберите список задач в TaskManager и выведите информацию о каждой
        // задаче, включая заголовок, описание и статус выполнения.

        taskManager.getAllTasks();

        System.out.println("-".repeat(50));
        taskManager.getCompletedTasks();
        System.out.println("-".repeat(50));
        taskManager.getIncompleteTasks();
        System.out.println("-".repeat(50));

        // Создайте новый список (List) и перенесите некоторые задачи из TaskManager в этот список. Убедитесь, что задачи
        // успешно перенесены и отображаются в новом списке.

        List<Task> list = new LinkedList<>();
        list.add(taskManager.getTaskList().get(0));
        list.add(taskManager.getTaskList().get(1));
        System.out.println(list);
        System.out.println("-".repeat(50));

        // Создайте новый массив (Array) и перенесите некоторые задачи из нового списка в этот массив. Убедитесь, что задачи
        // успешно перенесены и отображаются в новом массиве.

        Task[] tasks = {taskManager.getTaskList().get(2),taskManager.getTaskList().get(3)};
        System.out.println(Arrays.toString(tasks));
        System.out.println("-".repeat(50));

        // Выведите информацию о задачах в новом массиве, используя циклы.
        for (Task task : tasks) {
            System.out.println(task.getTitle() + ":" + task.isCompleted());
        }
        System.out.println("-".repeat(50));

        taskManager.removeTask(2);
        taskManager.getAllTasks();
    }
}