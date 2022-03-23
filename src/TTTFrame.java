import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TTTFrame extends JFrame {
    JPanel mainPnl, boardPnl, quitPnl;
    static TicTacToeTile[][] guiTiles = new TicTacToeTile[3][3];
    JButton quitBtn;

    private static String[][] board = new String[3][3];
    private String player = "X";
    private int moveCnt = 0;
    private final int MOVES_FOR_WIN = 5;
    private final int MOVES_FOR_TIE = 7;

    public TTTFrame() {
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        clearBoard();
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());

        boardPnl = new JPanel();
        boardPnl.setLayout(new GridLayout(3, 3));

        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 3; col++) {
                guiTiles[row][col] = new TicTacToeTile(row, col);
                guiTiles[row][col].setText(" ");
                int finalCol = col;
                int finalRow = row;
                guiTiles[row][col].addActionListener((ActionEvent ae) ->
                    {
                        TTTGame.getBoard(board);
                        if(TTTGame.isValidMove(finalRow,finalCol)){
                            board[finalRow][finalCol] = player;
                            guiTiles[finalRow][finalCol].setText(player);
                            moveCnt++;
                            TTTGame.getMoveCount(moveCnt);
                            if(moveCnt >= MOVES_FOR_WIN) {
                                if (TTTGame.isWin(player)){
                                    if(player.equals("X")){
                                        JOptionPane.showMessageDialog(null, "Player 1 Wins!");
                                        int input = JOptionPane.showConfirmDialog(null, "Would you like to play again?");
                                        if(input == 0){
                                            clearBoard();
                                            player = "O";
                                            moveCnt = 0;
                                            for(int row2=0; row2 < 3; row2++) {
                                                for(int col2=0; col2 < 3; col2++) {
                                                    guiTiles[row2][col2].setText(" ");
                                                }
                                            }
                                        }
                                        else if(input == 1 || input == 2)
                                            System.exit(0);
                                    }
                                    else if(player.equals("O")){
                                        JOptionPane.showMessageDialog(null, "Player 2 Wins!");
                                        int input = JOptionPane.showConfirmDialog(null, "Would you like to play again?");
                                        if(input == 0){
                                            clearBoard();
                                            player = "O";
                                            moveCnt = 0;
                                            for(int row2=0; row2 < 3; row2++) {
                                                for(int col2=0; col2 < 3; col2++) {
                                                    guiTiles[row2][col2].setText(" ");
                                                }
                                            }
                                        }
                                        else if(input == 1 || input == 2)
                                            System.exit(0);
                                    }
                                }
                            }
                            if(moveCnt >= MOVES_FOR_TIE) {
                                if(TTTGame.isTie()){
                                        JOptionPane.showMessageDialog(null, "Its a tie!");
                                        int input = JOptionPane.showConfirmDialog(null, "Would you like to play again?");
                                        if(input == 0){
                                            clearBoard();
                                            player = "O";
                                            moveCnt = 0;
                                            for(int row2=0; row2 < 3; row2++) {
                                                for(int col2=0; col2 < 3; col2++) {
                                                    guiTiles[row2][col2].setText(" ");
                                                }
                                            }
                                        }
                                        else if(input == 1 || input == 2)
                                            System.exit(0);
                                }
                            }
                            if(player.equals("X"))
                                player = "O";
                            else
                                player = "X";
                        }
                        else
                            JOptionPane.showMessageDialog(null, "Invalid Move!, Please try again.");
                    }
                );
                boardPnl.add(guiTiles[row][col]);
            }

        mainPnl.add(boardPnl, BorderLayout.CENTER);
        add(mainPnl);

        quitPnl = new JPanel();
        quitBtn = new JButton("Quit the TTT Game!");
        quitBtn.addActionListener((ActionEvent ae) ->
        {
            System.exit(0);
        });

        quitPnl.add(quitBtn);
        mainPnl.add(quitPnl, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void clearBoard() {
        for(int row=0; row < 3; row++) {
            for(int col=0; col < 3; col++) {
                board[row][col] = " ";
            }
        }
    }
}
