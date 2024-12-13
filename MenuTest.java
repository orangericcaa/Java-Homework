package ExperimentFour;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuTest extends JFrame {
    private Color faceColor = Color.YELLOW;
    private String faceExpression = "Smiling...";
    private int faceSize = 100;

    public MenuTest() {
        setTitle("MenuTest");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JMenuBar menuBar = new JMenuBar();
        JMenu faceMenu = new JMenu("Face");
        JMenu smileMenu = new JMenu("Smile");
        JMenu helpMenu = new JMenu("Help");

        ButtonGroup colorGroup = new ButtonGroup();
        JMenu colorMenu = new JMenu("Color");
        JRadioButtonMenuItem yellowMenuItem = new JRadioButtonMenuItem("Yellow", true);
        JRadioButtonMenuItem pinkMenuItem = new JRadioButtonMenuItem("Pink");
        colorMenu.add(yellowMenuItem);
        colorMenu.add(pinkMenuItem);
        colorGroup.add(yellowMenuItem);
        colorGroup.add(pinkMenuItem);
        faceMenu.add(colorMenu);

        ButtonGroup sizeGroup = new ButtonGroup();
        JMenu sizeMenu = new JMenu("Size");
        JRadioButtonMenuItem smallMenuItem = new JRadioButtonMenuItem("Small", true);
        JRadioButtonMenuItem bigMenuItem = new JRadioButtonMenuItem("Big");
        sizeMenu.add(smallMenuItem);
        sizeMenu.add(bigMenuItem);
        sizeGroup.add(smallMenuItem);
        sizeGroup.add(bigMenuItem);
        faceMenu.add(sizeMenu);

        ButtonGroup expressionGroup = new ButtonGroup();
        JRadioButtonMenuItem smileMenuItem = new JRadioButtonMenuItem("Smile", true);
        JRadioButtonMenuItem bigSmileMenuItem = new JRadioButtonMenuItem("BigSmile");
        smileMenu.add(smileMenuItem);
        smileMenu.add(bigSmileMenuItem);
        expressionGroup.add(smileMenuItem);
        expressionGroup.add(bigSmileMenuItem);
        smileMenu.add(smileMenu);

        JMenuItem indexMenuItem = new JMenuItem("Index");
        JMenuItem aboutMenuItem = new JMenuItem("About");
        helpMenu.add(indexMenuItem);
        helpMenu.add(aboutMenuItem);

        menuBar.add(faceMenu);
        menuBar.add(smileMenu);
        menuBar.add(helpMenu);
        setJMenuBar(menuBar);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    showPopup(e);
                }
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    showPopup(e);
                }
            }

            private void showPopup(MouseEvent e) {
                ButtonGroup popupExpressionGroup = new ButtonGroup();
                JPopupMenu popupMenu = new JPopupMenu();
                popupMenu.add(smileMenuItem);
                popupMenu.add(bigSmileMenuItem);
                popupExpressionGroup.add(smileMenuItem);
                popupExpressionGroup.add(bigSmileMenuItem);

                popupMenu.show(e.getComponent(), e.getX(), e.getY());
            }
        });

        yellowMenuItem.addActionListener(e -> {
            faceColor = Color.YELLOW;
            repaint();
        });
        pinkMenuItem.addActionListener(e -> {
            faceColor = Color.PINK;
            repaint();
        });

        smallMenuItem.addActionListener(e -> {
            faceSize = 100;
            repaint();
        });
        bigMenuItem.addActionListener(e -> {
            faceSize = 150;
            repaint();
        });

        smileMenuItem.addActionListener(e -> {
            faceExpression = "Smiling...";
            repaint();
        });
        bigSmileMenuItem.addActionListener(e -> {
            faceExpression = "BigSmiling...";
            repaint();
        });

        indexMenuItem.addActionListener(e -> JOptionPane.showMessageDialog(this, "Index Help"));
        aboutMenuItem.addActionListener(e -> JOptionPane.showMessageDialog(this, "About MenuTest"));
        setVisible(true);
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(faceColor);
        int x = (getWidth() - faceSize) / 2;
        int y = (getHeight() - faceSize) / 2;
        g.fillOval(x, y, faceSize, faceSize);

        g.setColor(Color.BLACK);
        if(faceExpression.equals("Smiling...")){
            g.drawArc(x + faceSize / 6, y + faceSize / 4, 2 * faceSize / 3, 2 * faceSize / 3, 0, -180);
        }
        else if(faceExpression.equals("BigSmiling...")){
            g.fillOval(x + faceSize / 6, y + faceSize / 4, 4 * faceSize / 6, 4 * faceSize / 6);
            g.setColor(faceColor);
            g.fillOval(x + faceSize / 6, y + faceSize / 4, 4 * faceSize / 6, 4 * faceSize / 7);
        }

        g.setColor(Color.BLACK);
        g.fillOval(x + faceSize / 5, y + faceSize / 3, faceSize / 6, faceSize / 6);
        g.fillOval(x + 4 * faceSize / 5 - faceSize / 6, y + faceSize / 3, faceSize / 6, faceSize / 6);

        g.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 24));
        g.setColor(Color.BLUE);
        g.drawString(faceExpression, (getWidth() - g.getFontMetrics().stringWidth(faceExpression)) / 2, getHeight() - 50);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MenuTest::new);
    }
}
