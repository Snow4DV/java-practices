package ru.snowadv;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FootballGameSimulator extends JFrame {
    /*
    Напишите интерактивную программу с использованием GUI имитирует
    таблицу результатов матчей между командами Милан и Мадрид. Создайте JFrame
    приложение у которого есть следующие компоненты GUI:
    • одна кнопка JButton labeled “AC Milan”
    • другая JButton подписана “Real Madrid”
    • надпись JLabel содержит текст “Result: 0 X 0”
    • надпись JLabel содержит текст “Last Scorer: N/A”
    • надпись Label содержит текст “Winner: DRAW”;
    Всякий раз, когда пользователь нажимает на кнопку AC Milan, результат
    будет увеличиваться для Милана, сначала 1 X 0, затем 2 X 0 и так далее. Last Scorer
    означает последнюю забившую команду. В этом случае: AC Milan. Если
    пользователь нажимает кнопку для команды Мадрид, то счет приписывается ей.
    Победителем становится команда, которая имеет больше кликов кнопку на
    соответствующую, чем другая.
     */

    private int madrid = 0;
    private int milan = 0;
    private final JLabel result;
    private final JLabel lastScorer;
    private final JLabel winner;
    private final JButton madridButton;
    private final JButton milanButton;
    public FootballGameSimulator() throws HeadlessException {
        super("Football Game Simulator");
        BorderLayout layout = new BorderLayout();
        setLayout(layout);
        ((JPanel)getContentPane()).setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        result = new JLabel("Result: 0 X 0");
        lastScorer = new JLabel("Last Scorer: N/A");
        winner = new JLabel("Winner: DRAW");
        madridButton = new JButton("Real Madrid");
        milanButton = new JButton("AC Milan");

        madridButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        milanButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(result, BorderLayout.NORTH);
        add(lastScorer, BorderLayout.WEST);
        add(winner, BorderLayout.EAST);

        JPanel buttonsBox = new JPanel();
        buttonsBox.setLayout(new BoxLayout(buttonsBox, BoxLayout.Y_AXIS));
        buttonsBox.add("madrid", madridButton);
        buttonsBox.add(Box.createRigidArea(new Dimension(0,5)));
        buttonsBox.add("milan", milanButton);
        add(buttonsBox, BorderLayout.SOUTH);

        setSize(300,500);

        MouseListener listener = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(((JButton) e.getSource()).getText().equals("AC Milan")) {
                    milan++;
                    updateLabels("AC Milan");
                } else {
                    madrid++;
                    updateLabels("Real Madrid");
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        };
        madridButton.addMouseListener(listener);
        milanButton.addMouseListener(listener);
    }

    private void updateLabels(String lastScorer) {
        result.setText(String.format("Result: %d X %d", madrid, milan));
        this.lastScorer.setText("Last Scorer: " + lastScorer);
        if(madrid == milan) {
            winner.setText("Winner: DRAW");
        } else {
            winner.setText("Winner: " + ((madrid > milan)? "Real Madrid" : "AC Milan"));
        }
    }
    public static void main(String[] args) {
        new FootballGameSimulator().setVisible(true);
    }
}