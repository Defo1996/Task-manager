package ru.netology;

public class Meeting extends Task {
    private final String topic;
    private final String project;

    public Meeting(int id, String topic, String project) {
        super(id);
        this.topic = topic;
        this.project = project;
    }

    @Override
    public boolean matches(String query) {
        String lowerQuery = query.toLowerCase();
        return topic.toLowerCase().contains(lowerQuery) ||
                project.toLowerCase().contains(lowerQuery);
    }
}