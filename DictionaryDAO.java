package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Word;
import util.SQLConnect;

public class DictionaryDAO {
    private Connection conn;

    public DictionaryDAO() {
        conn = SQLConnect.getSQL();
    }

    public boolean addWord(Word word) {
        String query = "INSERT INTO dictionary (word, pronunciation, pos, meaning) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, word.getWord());
            stmt.setString(2, word.getPronunciation());
            stmt.setString(3, word.getPos());
            stmt.setString(4, word.getMeaning());
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error adding word: " + e.getMessage());
            return false;
        }
    }

    public boolean updateWord(Word word) {
        String query = "UPDATE dictionary SET pronunciation = ?, pos = ?, meaning = ? WHERE word = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, word.getPronunciation());
            stmt.setString(2, word.getPos());
            stmt.setString(3, word.getMeaning());
            stmt.setString(4, word.getWord());
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error updating word: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteWord(String word) {
        String query = "DELETE FROM dictionary WHERE word = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, word);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error deleting word: " + e.getMessage());
            return false;
        }
    }

    public Word searchWord(String word) {
        String query = "SELECT * FROM dictionary WHERE word = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, word);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Word(
                    rs.getString("word"),
                    rs.getString("pronunciation"),
                    rs.getString("pos"),
                    rs.getString("meaning")
                );
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.err.println("Error searching word: " + e.getMessage());
            return null;
        }
    }
    
    public List<Word> getAllWords() {
        List<Word> words = new ArrayList<>();
        String sql = "SELECT * FROM dictionary";
        try (PreparedStatement statement = conn.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Word word = new Word(
                    resultSet.getString("word"),
                    resultSet.getString("pronunciation"),
                    resultSet.getString("pos"),
                    resultSet.getString("meaning")
                );
                words.add(word);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return words;
    }
}
