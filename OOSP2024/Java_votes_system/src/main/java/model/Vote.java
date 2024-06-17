package model;

class baseentity {
    protected int id;

    public baseentity(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

class User extends baseentity {
    private String login;
    private String password;
    private String snils;
    private boolean isVote;

    public User(int id, String login, String password, String snils, boolean isVote) {
        super(id);
        this.login = login;
        this.password = password;
        this.snils = snils;
        this.isVote = isVote;
    }

    // Остальные методы остаются без изменений

    @Override
    public String toString() {
        return "User{" +
                "id=" + getId() +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", snils='" + snils + '\'' +
                ", isVote=" + isVote +
                '}';
    }
}

public class Vote extends baseentity {
    private int candidateId;
    private int userId;

    public Vote(int id, int candidateId, int userId) {
        super(id);
        this.candidateId = candidateId;
        this.userId = userId;
    }

    public int getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(int candidateId) {
        this.candidateId = candidateId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "id=" + getId() +
                ", candidateId=" + candidateId +
                ", userId=" + userId +
                '}';
    }
}