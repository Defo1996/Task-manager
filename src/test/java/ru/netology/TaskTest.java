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
}
