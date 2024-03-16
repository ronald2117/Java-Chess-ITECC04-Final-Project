import javax.swing.*;
import java.awt.*;

public class ChessGameGUI {
    private final JFrame frame;
    private final JPanel boardPanel;
    private final JButton[][] squares;

    public ChessGameGUI() {
        frame = new JFrame("Chess Game");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        boardPanel = new JPanel(new GridLayout(8, 8));
        squares = new JButton[8][8];

        initializeBoard();

        frame.add(boardPanel);
        frame.setVisible(true);
    }

    private void initializeBoard() {
        boolean isWhite = true;
        Color lightColor = new Color(255, 206, 158);
        Color darkColor = new Color(209, 139, 71);

        for (int i = 0; i < 8; i++) {
            isWhite = !isWhite; // toggle color for each row
            for (int j = 0; j < 8; j++) {
                squares[i][j] = new JButton();
                squares[i][j].setPreferredSize(new Dimension(75, 75));

                if (isWhite) {
                    squares[i][j].setBackground(lightColor);
                } else {
                    squares[i][j].setBackground(darkColor);
                }

                boardPanel.add(squares[i][j]);
                isWhite = !isWhite; // toggle color for each square
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ChessGameGUI::new);
    }
}
