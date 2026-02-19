package ru.netology;

public class Epic extends Task {
    private final String[] subtasks;

    public Epic(int id, String[] subtasks) {
        super(id);
        this.subtasks = subtasks;
    }

    @Override
    public boolean matches(String query) {
        String lowerQuery = query.toLowerCase();
        for (String subtask : subtasks) {
            if (subtask.toLowerCase().contains(lowerQuery)) {
                return true;
            }
        }
        return false;
    }
}