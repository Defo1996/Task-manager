package ru.netology;

import org.junit.jupiter.api.Test;

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
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchShouldFindSimpleTask() {
        Todos todos = new Todos();
        SimpleTask task = new SimpleTask(1, "Купить продукты");
        todos.add(task);

        Task[] found = todos.search("продукты");
        assertEquals(1, found.length);
        assertEquals(task, found[0]);
    }

    @Test
    public void searchShouldFindEpicBySubtask() {
        Todos todos = new Todos();
        String[] subtasks = {"Купить молоко", "Оплатить счета"};
        Epic epic = new Epic(2, subtasks);
        todos.add(epic);

        Task[] found = todos.search("молоко");
        assertEquals(1, found.length);
        assertEquals(epic, found[0]);
    }

    @Test
    public void searchShouldFindMeetingByTopic() {
        Todos todos = new Todos();
        Meeting meeting = new Meeting(3, "Совещание по проекту", "Проект Бета", "Сегодня в 15:00");
        todos.add(meeting);

        Task[] found = todos.search("проект");
        assertEquals(1, found.length);
        assertEquals(meeting, found[0]);
    }

    @Test
    public void searchShouldReturnEmptyArrayIfNoMatches() {
        Todos todos = new Todos();
        todos.add(new SimpleTask(1, "Задача 1"));

        Task[] found = todos.search("не существующий запрос");
        assertEquals(0, found.length);
    }
}
