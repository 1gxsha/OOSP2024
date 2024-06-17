package model;

class baseEntity {
    protected int id;
    protected String name;

    public baseEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public baseEntity(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class user {
    private model.baseEntity baseEntity;
    private String login;
    private String password;
    private String snils;
    private boolean isVote;

    public user(int id, String login, String password, String name, String snils, boolean isVote) {
        this.baseEntity = new baseEntity(id, name);
        this.login = login;
        this.password = password;
        this.snils = snils;
        this.isVote = isVote;
    }

    public user(String login, String password, String name, String snils, boolean isVote) {
        this.baseEntity = new baseEntity(name);
        this.login = login;
        this.password = password;
        this.snils = snils;
        this.isVote = isVote;
    }

    // Остальные методы остаются без изменений

    @Override
    public String toString() {
        return "User{" +
                "id=" + baseEntity.getId() +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + baseEntity.getName() + '\'' +
                ", snils='" + snils + '\'' +
                ", isVote=" + isVote +
                '}';
    }

    public String getName() {
        return null;
    }

    public String getLogin() {
        return null;
    }

    public String getPassword() {
        return null;
    }

    public String getSnils() {
        return null;
    }

    public boolean isVote() {
        return false;
    }
}

