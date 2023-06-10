package todo_list;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Создайте класс TaskManager, который будет представлять менеджер задач. У TaskManager
 * должны быть следующие методы:
 *  * addTask(Task task): добавляет задачу в список задач.
 *  * removeTask(Task task): удаляет задачу из списка задач.
 *  * getAllTasks(): возвращает список всех задач.
 *  * getCompletedTasks(): возвращает список выполненных задач.
 *  * getIncompleteTasks(): возвращает список невыполненных задач.
 */

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TaskManager {

    private List<Task> taskList = new ArrayList<>();



    public void addTask(Task task){
        taskList.add(task);
    }

    public void removeTask(int index){
        taskList.remove(index);
    }

    public void getAllTasks(){
        taskList.forEach(System.out::println);
    }

    public void getCompletedTasks(){
        for (Task task : taskList) {
            if (task.isCompleted()){
                System.out.println(task);
            }
        }
    }

    public void getIncompleteTasks(){
        for (Task task : taskList) {
            if (!task.isCompleted()){
                System.out.println(task);
            }
        }
    }

}
