package ru.snow4dv;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.HashSet;

public class OnlineShop extends JFrame {

    private HashSet<User> users = new HashSet<>();
    public OnlineShop(String title) {
        super(title);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setSize(500,500);
        JLabel titleLabel = new JLabel("Online shop");
        titleLabel.setFont(new Font("Serif", Font.PLAIN, 40));


        JLabel fioFieldLabel = new JLabel("Введите ФИО:");
        JTextField fioField = new JTextField(40);
        fioField.setMaximumSize( fioField.getPreferredSize());

        JLabel innFieldLabel = new JLabel("Введите ИНН:");
        JTextField innField = new JTextField(40);
        innField.setMaximumSize( innField.getPreferredSize());

        JLabel orderFieldLabel = new JLabel("Введите артикулы позиций для заказа через запятую:");
        JTextField orderField = new JTextField(40);
        orderField.setMaximumSize( orderField.getPreferredSize());

        JButton publishOrderButton = new JButton("Отправить заказ");
        JButton registerButton = new JButton("Регистрация");

        publishOrderButton.addActionListener(new Action() {
            @Override
            public Object getValue(String key) {
                return null;
            }

            @Override
            public void putValue(String key, Object value) {

            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    publishOrder(orderField.getText(), new User(fioField.getText(), Long.parseLong(innField.getText())));
                    JOptionPane.showMessageDialog(getContentPane(), "Заказ размещен", "Успех", JOptionPane.INFORMATION_MESSAGE);
                } catch(InnMismatchException exception) {
                    exception.printStackTrace();
                    JOptionPane.showMessageDialog(getContentPane(), "Недействительный ИНН для текущего пользователя", "Ошибка", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        registerButton.addActionListener(new Action() {
            @Override
            public Object getValue(String key) {
                return null;
            }

            @Override
            public void putValue(String key, Object value) {

            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void actionPerformed(ActionEvent e) {
                User newUser = registerDialog();
                if(newUser != null) {
                    users.add(newUser);
                }
            }
        });

        add(titleLabel);
        add(fioFieldLabel);
        add(fioField);
        add(innFieldLabel);
        add(innField);
        add(orderFieldLabel);
        add(orderField);

        add(publishOrderButton);
        add(registerButton);


        setVisible(true);
    }


    private void publishOrder(String order, User user) throws InnMismatchException {
        if(!users.contains(user)) {
            throw new InnMismatchException("FIO is " + user.getFio() + ", inn is " + user.getInn());
        }
        System.out.println("Server-server, here's the data: " + order);
    }
    private static User registerDialog() {
        JTextField fioField = new JTextField(10);
        JTextField innField = new JTextField(10);

        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Введите ФИО:"));
        myPanel.add(fioField);
        myPanel.add(new JLabel("ИНН:"));
        myPanel.add(innField);

        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Регистрация пользователя", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            return new User(fioField.getText(), Long.parseLong(innField.getText()));
        }
        return null;
    }

    public static void main(String[] args) {
        new OnlineShop("Online shop");
    }
}
