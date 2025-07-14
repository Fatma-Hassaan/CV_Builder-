package model;

public class Position {
    public String title;
    public String company;
    public String duration;
    public String description;
    public boolean include;

    public Position(String title, String company, String duration, String description, boolean include) {
        this.title = title;
        this.company = company;
        this.duration = duration;
        this.description = description;
        this.include = include;
    }

    @Override
    public String toString() {
        return title + ", " + company + " (" + duration + ")";
    }
}