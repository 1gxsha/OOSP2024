package service;

import repository.Repository;
import model.user;

public class UserService {
    private final Repository repository;


    public UserService(Repository repository) {
        this.repository = repository;
    }

    public user authByLogin(String login) {
        return repository.findUserByLogin(login);
    }
    public void createNewUser(user user) {
        repository.regUser(user);
    }

    public void toVote(int userId, int candidateId) {
        repository.toVote(userId, candidateId);
    }

}
