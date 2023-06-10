package todo_list;

import lombok.*;

/**
 * Создайте класс Task, представляющий задачу. У задачи должны быть следующие свойства:
 *  * Заголовок (title) - строковое значение, описывающее задачу.
 *  * Описание (description) - строковое значение, дополнительная информация о задаче.
 *  * Статус выполнения (completed) - логическое значение, указывающее, выполнена ли задача.
 */
@Setter
@Getter
@AllArgsConstructor
@ToString
public class Task {

    private String title;

    private String description;

    private boolean completed;
}
