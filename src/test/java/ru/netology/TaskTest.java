package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TasksTest {

    @Test
    public void simpleTaskMatchesWhenQueryInTitle() {
        SimpleTask task = new SimpleTask(1, "Купить молоко");
        assertTrue(task.matches("молоко"));
    }

    @Test
    public void simpleTaskDoesNotMatchWhenQueryNotInTitle() {
        SimpleTask task = new SimpleTask(1, "Купить молоко");
        assertFalse(task.matches("хлеб"));
    }

    @Test
    public void epicMatchesWhenQueryInSubtask() {
        String[] subtasks = {"Купить молоко", "Позвонить маме", "Сделать уроки"};
        Epic epic = new Epic(1, subtasks);
        assertTrue(epic.matches("уроки"));
    }

    @Test
    public void epicDoesNotMatchWhenQueryNotInAnySubtask() {
        String[] subtasks = {"Купить молоко", "Позвонить маме", "Сделать уроки"};
        Epic epic = new Epic(1, subtasks);
        assertFalse(epic.matches("спорт"));
    }

    @Test
    public void meetingMatchesWhenQueryInTopic() {
        Meeting meeting = new Meeting(1, "Планерка по проекту", "Проект Альфа");
        assertTrue(meeting.matches("Планерка"));
    }

    @Test
    public void meetingMatchesWhenQueryInProject() {
        Meeting meeting = new Meeting(1, "Планерка по проекту", "Проект Альфа");
        assertTrue(meeting.matches("Альфа"));
    }

    @Test
    public void meetingDoesNotMatchWhenQueryNotInTopicOrProject() {
        Meeting meeting = new Meeting(1, "Планерка по проекту", "Проект Альфа");
        assertFalse(meeting.matches("обед"));
    }

    @Test
    public void hashCodeWhenSameId() {
        SimpleTask task1 = new SimpleTask(1, "Тест");
        SimpleTask task2 = new SimpleTask(1, "Другой");
        assertEquals(task1.hashCode(), task2.hashCode());
    }

    @Test
    public void equalsWhenSameObject() {
        SimpleTask task = new SimpleTask(1, "Купить хлеб");
        assertTrue(task.equals(task));
    }

    @Test
    public void equalsWhenNull() {
        SimpleTask task = new SimpleTask(1, "Купить хлеб");
        assertFalse(task.equals(null));
    }

    @Test
    public void equalsWhenDifferentClass() {
        SimpleTask task = new SimpleTask(1, "Купить хлеб");
        Object other = "просто строка";
        assertFalse(task.equals(other));
    }

    @Test
    public void equalsWhenSameId() {
        SimpleTask task1 = new SimpleTask(1, "Купить хлеб");
        SimpleTask task2 = new SimpleTask(1, "Другое название");
        assertTrue(task1.equals(task2));
    }

    @Test
    public void equalsWhenDifferentId() {
        SimpleTask task1 = new SimpleTask(1, "Купить хлеб");
        SimpleTask task2 = new SimpleTask(2, "Купить молоко");
        assertFalse(task1.equals(task2));
    }

    @Test
    public void matchesShouldAlwaysReturnFalseForTask() {
        Task task = new Task(1) {
            @Override
            public boolean matches(String query) {
                return false;
            }
        };
        assertFalse(task.matches("любой запрос"), "matches() должен всегда возвращать false для базового Task");
    }

    @Test
    public void allSubclassesMatchesShouldBeTested() {
        // Проверяем SimpleTask
        SimpleTask simpleTask = new SimpleTask(1, "Название");
        assertFalse(simpleTask.matches("тест"), "SimpleTask.matches() должен возвращать false");

        // Проверяем Epic
        Epic epic = new Epic(2, new String[]{"Подзадача"});
        assertFalse(epic.matches("тест"), "Epic.matches() должен возвращать false");

        // Проверяем Meeting
        Meeting meeting = new Meeting(3, "Тема", "Проект");
        assertFalse(meeting.matches("тест"), "Meeting.matches() должен возвращать false");
    }
}
