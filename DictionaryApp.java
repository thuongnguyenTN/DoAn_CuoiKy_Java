
package UI;

import DAO.DictionaryDAO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import model.Word;

public class DictionaryApp {
    private JFrame frame;
    private JButton viewDictionaryButton;
    private DictionaryDAO dao;

    public DictionaryApp() {
        dao = new DictionaryDAO();
        frame = new JFrame("Dictionary Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());

        viewDictionaryButton = new JButton("Xem Từ Điển");
        viewDictionaryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showDictionaryWindow();
            }
        });

        frame.add(viewDictionaryButton);
        frame.setVisible(true);
    }

    private void showDictionaryWindow() {
        JFrame dictionaryFrame = new JFrame("Dictionary");
        dictionaryFrame.setSize(300, 400);
        dictionaryFrame.setLayout(new BorderLayout());

        List<Word> words = dao.getAllWords();

        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (Word word : words) {
            listModel.addElement(word.getWord() + ": " + word.getMeaning());
        }
        JList<String> dictionaryList = new JList<>(listModel);

        dictionaryFrame.add(new JScrollPane(dictionaryList), BorderLayout.CENTER);
        dictionaryFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new DictionaryApp();
    }
}
