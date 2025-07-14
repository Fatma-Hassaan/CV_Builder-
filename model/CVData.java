package model;

import java.util.*;

public class CVData {
    private List<String> names;
    private List<String> titles;
    private List<String> emails;

    private Map<Integer, List<Position>> experiences; // key = position number

    public CVData() {
        names = new ArrayList<>();
        titles = new ArrayList<>();
        emails = new ArrayList<>();
        experiences = new HashMap<>();
    }

    // Getters and setters

    public List<String> getNames() { return names; }
    public List<String> getTitles() { return titles; }
    public List<String> getEmails() { return emails; }
    public Map<Integer, List<Position>> getExperiences() { return experiences; }

    public void addName(String name) { names.add(name); }
    public void addTitle(String title) { titles.add(title); }
    public void addEmail(String email) { emails.add(email); }

    public void addExperience(int posNum, Position p) {
        experiences.computeIfAbsent(posNum, k -> new ArrayList<>()).add(p);
    }

    public String getSelectedName() {
        return names.isEmpty() ? "" : names.get(0);
    }

    public String getSelectedTitle() {
        return titles.isEmpty() ? "" : titles.get(0);
    }

    public String getSelectedEmail() {
        return emails.isEmpty() ? "" : emails.get(0);
    }

    public List<Position> getSelectedPositions() {
        List<Position> result = new ArrayList<>();
        for (Map.Entry<Integer, List<Position>> entry : experiences.entrySet()) {
            for (Position p : entry.getValue()) {
                if (entry.getKey() == 1 || p.include) {
                    result.add(p);
                }
            }
        }
        return result;
    }
}