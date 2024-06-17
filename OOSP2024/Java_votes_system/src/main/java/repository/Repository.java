package repository;

import model.CIK;
import model.Candidate;
import model.user;
import model.Vote;

import java.util.List;

public interface Repository {
    user findUser(int id);
    user findUserByLogin(String login);
    void removeUser(int id);
    void regUser(user user);

    CIK findCIK(int id);
    List<CIK> getCIKList();
    void removeCIK(int id);
    void createNewCIK(CIK cik);

    Candidate findCandidate(int id);
    List<Candidate> getCandidatsList();
    void removeCandidate(int id);
    List <user> getUsers();
    void createNewCandidate(Candidate candidate);
    void toVote(int userId, int candidateId);
    void saveUserStatus(int id);
    List<Vote> getVotesList();
}