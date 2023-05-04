package com.telran.employeeweb.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "employee")
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    /**
     * 1. Добавить возможность выбора типа сортировки на странице вывода поиска по
     * возрасту http://localhost:8080/employees/findByAge?age=0
     * (см. код в репозитории employeeWeb)
     * Пример URL:
     * Сортировка по возрастанию: http://localhost:8080/employees/findByAge?age=0&page=0&sort=age,asc
     * Сортировка по убыванию http://localhost:8080/employees/findByAge?age=0&page=0&sort=age,desc
     * Создать рабочие ссылки для сортировки по Name, Surname, Age ("Z->A", "Z->A", "9->0")
     * Сделать возможной постраничную навигацию по ссылкам "Previous page" "Next page" с
     * учетом типа сортировки
     *
     * В класс Employee добавить текстовое поле additionalInfo. Переработать форму
     * редактирования Employee.
     * Необходимо добавить дополнительную страницу редактирования по URL
     * /employees/editEmployeePage2 так, чтобы:
     *
     * по нажатии edit со страницы /employees пользователь попадал на страницу
     * /employees/editEmployeePage
     *
     * на странице /employees/editEmployeePage мог редактировать только поля Name, Surname, Age
     *
     * далее переходил на страницу /employees/editEmployeePage2 где мог бы редактировать
     * только поле additionalInfo
     *
     * далее переходил на страницу /employees/confirmPage где мог бы просмотреть все
     * поля Employee и подтвердить изменения
     *
     * Для сокрытия данных полей можно использовать тег
     */

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    //    @Column(name = "name_in_database")
    @NotBlank(message = "Put a valid name, please")
    @Length(max = 20, message = "Max length is 20")
    private String name;

    @NotBlank(message = "Put a valid surname, please")
    @Length(max = 20, message = "Max length is 20")
    private String surname;

    @Min(value = 18, message = "Age cannot be under 18")
    private Integer age;

    @Length(max = 255, message = "Max length is 255")
    private String additionalInfo;

    @Email(regexp = "[a-z]+@[a-z]+.[a-z]+", message = "Enter a valid email")
//    @Pattern(regexp = "[a-z]+@[a-z]+.[a-z]+")
    private String email;



}
