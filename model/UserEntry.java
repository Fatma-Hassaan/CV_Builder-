package cvbuilder.model;

public class UserEntry {
    private String name;
    private String title;
    private String email;
    private boolean includeTitle;

    public UserEntry(String name, String title, String email, boolean includeTitle) {
        this.name = name;
        this.title = title;
        this.email = email;
        this.includeTitle = includeTitle;
    }

    // Getters and Setters
}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isIncludeTitle() {
        return includeTitle;
    }

    public void setIncludeTitle(boolean includeTitle) {
        this.includeTitle = includeTitle;
    }
}