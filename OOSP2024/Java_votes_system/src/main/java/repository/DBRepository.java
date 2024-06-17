package repository;

import model.CIK;
import model.Candidate;
import model.user;
import model.Vote;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBRepository implements Repository {
    private Connection connection;

    public DBRepository(Connection connection) {
        this.connection = connection;
    }

    public user findUser(int id) {
        String query = "SELECT * FROM users WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return mapResultSetToUser(rs);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    private user mapResultSetToUser(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String login = rs.getString("login");
        String password = rs.getString("password");
        String snils = rs.getString("snils");
        boolean isVote = rs.getBoolean("isVote");
        return new user(id, login, password, name, snils, isVote);
    }

    @Override
    public user findUserByLogin(String login) {
        String query = "SELECT * FROM users WHERE login = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return mapResultSetToUser(rs);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void removeUser(int id) {
        String query = "DELETE FROM users WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void regUser(user user) {
        String query = "INSERT INTO users (name, login, password, snils, isVote) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getLogin());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getSnils());
            ps.setBoolean(5, user.isVote());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public CIK findCIK(int id) {
        return null;
    }

    @Override
    public List<CIK> getCIKList() {
        return null;
    }

    @Override
    public void removeCIK(int id) {
    }

    @Override
    public void createNewCIK(CIK cik) {
    }

    @Override
    public Candidate findCandidate(int id) {
        return null;
    }

    @Override
    public List<Candidate> getCandidatsList() {
        return null;
    }

    @Override
    public void removeCandidate(int id) {
    }

    @Override
    public List<user> getUsers() {
        return null;
    }

    @Override
    public void createNewCandidate(Candidate candidate) {
    }

    @Override
    public void toVote(int userId, int candidateId) {
    }

    @Override
    public void saveUserStatus(int id) {
    }

    @Override
    public List<Vote> getVotesList() {
        return null;
    }
}
