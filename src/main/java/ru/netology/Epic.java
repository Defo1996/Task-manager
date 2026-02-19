package ru.netology;

public class Epic extends Task {
    protected String[] subtasks;

    public Epic(int id, String[] subtasks) {
        super(id);
        this.subtasks = subtasks;
    }

    public String[] getSubtasks() {
        return subtasks;
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
