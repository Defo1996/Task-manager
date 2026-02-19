package ru.netology;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка");

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        assertArrayEquals(expected, actual, "Все задачи должны быть найдены в правильном порядке");
    }

    @Test
    public void searchShouldFindMultipleTasks() {
        Todos todos = new Todos();

        SimpleTask task1 = new SimpleTask(1, "Купить хлеб");
        SimpleTask task2 = new SimpleTask(2, "Купить молоко и хлеб");
        Epic epic = new Epic(3, new String[]{"Хлеб", "Сыр"});
        Meeting meeting = new Meeting(4, "Совещание по хлебу", "Проект Хлебный");

        todos.add(task1);
        todos.add(task2);
        todos.add(epic);
        todos.add(meeting);

        Task[] result = todos.search("хлеб");

        // Отладочная печать
        System.out.println("Найдено задач: " + result.length);
        for (int i = 0; i < result.length; i++) {
            System.out.println("Задача " + i + ": " + result[i]);
        }
        System.out.println("Ожидаемый порядок: " + Arrays.toString(new Task[]{task1, task2, epic, meeting}));

        Task[] expected = {task1, task2, epic, meeting};
        assertArrayEquals(expected, result, "Должны найтись все 4 задачи с 'хлеб' в точном порядке добавления");
    }

    @Test
    public void searchShouldFindExactlyOneTask() {
        Todos todos = new Todos();

        SimpleTask task1 = new SimpleTask(1, "Купить хлеб");
        SimpleTask task2 = new SimpleTask(2, "Позвонить мама");
        Meeting meeting = new Meeting(3, "Совещание по проекту", "Проект Бета");

        todos.add(task1);
        todos.add(task2);
        todos.add(meeting);

        Task[] result = todos.search("мама");

        Task[] expected = {task2};
        assertArrayEquals(expected, result, "Должна найтись 1 задача с 'мама'");
    }

    @Test
    public void searchShouldFindZeroTasks() {
        Todos todos = new Todos();

        SimpleTask task1 = new SimpleTask(1, "Купить хлеб");
        Epic epic = new Epic(2, new String[]{"Молоко", "Сыр"});

        todos.add(task1);
        todos.add(epic);

        Task[] result = todos.search("яблоки");

        Task[] expected = {};
        assertArrayEquals(expected, result, "Не должно быть найдено ни одной задачи с 'яблоки'");
    }
}

