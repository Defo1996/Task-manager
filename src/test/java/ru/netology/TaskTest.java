package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TasksTest {

    @Test
    public void simpleTaskMatchesByTitle() {
        SimpleTask task = new SimpleTask(1, "Купить молоко");
        assertTrue(task.matches("молоко"));
        assertFalse(task.matches("хлеб"));
    }

    @Test
    public void epicMatchesBySubtask() {
        String[] subtasks = {"Купить молоко", "Купить хлеб", "Позвонить маме"};
        Epic epic = new Epic(2, subtasks);

        assertTrue(epic.matches("молоко"));
        assertTrue(epic.matches("хлеб"));
        assertTrue(epic.matches("маме"));

        assertTrue(epic.matches("МОЛОКО"));
        assertTrue(epic.matches("Маме"));
        assertTrue(epic.matches("ХЛЕБ"));

        assertFalse(epic.matches("яблоки"));
        assertFalse(epic.matches("работа"));
    }

    @Test
    public void meetingMatchesByTopic() {
        Meeting meeting = new Meeting(3, "Планерка команды", "Проект Альфа", "Завтра в 10:00");
        assertTrue(meeting.matches("Планерка"));
        assertTrue(meeting.matches("Альфа"));
        assertFalse(meeting.matches("обед"));
    }

    @Test
    public void equalsShouldBeTrueForSameObject() {
        SimpleTask task = new SimpleTask(1, "Задача");
        assertTrue(task.equals(task));
    }

    @Test
    public void equalsShouldBeFalseForNull() {
        SimpleTask task = new SimpleTask(1, "Задача");
        assertFalse(task.equals(null));
    }

    @Test
    public void equalsShouldBeFalseForDifferentClass() {
        SimpleTask task = new SimpleTask(1, "Задача");
        Object other = new Object();
        assertFalse(task.equals(other));
    }

    @Test
    public void equalsShouldBeTrueForSameId() {
        SimpleTask task1 = new SimpleTask(1, "Задача 1");
        SimpleTask task2 = new SimpleTask(1, "Задача 2");
        assertTrue(task1.equals(task2));
    }

    @Test
    public void equalsShouldBeFalseForDifferentId() {
        SimpleTask task1 = new SimpleTask(1, "Задача 1");
        SimpleTask task2 = new SimpleTask(2, "Задача 2");
        assertFalse(task1.equals(task2));
    }

    @Test
    public void hashCodeShouldBeSameForSameId() {
        SimpleTask task1 = new SimpleTask(1, "Задача 1");
        SimpleTask task2 = new SimpleTask(1, "Задача 2");
        assertEquals(task1.hashCode(), task2.hashCode());
    }

    @Test
    public void hashCodeShouldBeDifferentForDifferentId() {
        SimpleTask task1 = new SimpleTask(1, "Задача 1");
        SimpleTask task2 = new SimpleTask(2, "Задача 2");
        assertNotEquals(task1.hashCode(), task2.hashCode());
    }
}
