import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

/**
 * GUI Chess Game with complete functionality
 * Features: All pieces with proper movements, move validation, move history, visual indicators
 */
public class ChessGame extends JFrame {
    private static final int BOARD_SIZE = 8;
    private static final int SQUARE_SIZE = 80;

    private ChessBoard board;
    private JPanel boardPanel;
    private JPanel historyPanel;
    private JTextArea historyTextArea;
    private JLabel statusLabel;
    private Square[][] squares;
    private Square selectedSquare;
    private List<Point> legalMoves;

    public ChessGame() {
        setTitle("Chess Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        board = new ChessBoard();
        squares = new Square[BOARD_SIZE][BOARD_SIZE];
        legalMoves = new ArrayList<>();

        initializeBoardPanel();
        initializeHistoryPanel();
        initializeStatusBar();

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initializeBoardPanel() {
        boardPanel = new JPanel(new GridLayout(BOARD_SIZE, BOARD_SIZE));
        boardPanel.setPreferredSize(new Dimension(BOARD_SIZE * SQUARE_SIZE, BOARD_SIZE * SQUARE_SIZE));

        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                Square square = new Square(row, col);
                squares[row][col] = square;
                boardPanel.add(square);

                final int r = row, c = col;
                square.addActionListener(e -> handleSquareClick(r, c));
            }
        }

        add(boardPanel, BorderLayout.CENTER);
        updateBoardDisplay();
    }

    private void initializeHistoryPanel() {
        historyPanel = new JPanel(new BorderLayout());
        historyPanel.setPreferredSize(new Dimension(250, BOARD_SIZE * SQUARE_SIZE));

        JLabel historyLabel = new JLabel("Move History", SwingConstants.CENTER);
        historyLabel.setFont(new Font("Arial", Font.BOLD, 16));
        historyPanel.add(historyLabel, BorderLayout.NORTH);

        historyTextArea = new JTextArea();
        historyTextArea.setEditable(false);
        historyTextArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(historyTextArea);
        historyPanel.add(scrollPane, BorderLayout.CENTER);

        JButton resetButton = new JButton("New Game");
        resetButton.addActionListener(e -> resetGame());
        historyPanel.add(resetButton, BorderLayout.SOUTH);

        add(historyPanel, BorderLayout.EAST);
    }

    private void initializeStatusBar() {
        statusLabel = new JLabel("White's turn", SwingConstants.CENTER);
        statusLabel.setFont(new Font("Arial", Font.BOLD, 14));
        statusLabel.setPreferredSize(new Dimension(0, 30));
        statusLabel.setOpaque(true);
        statusLabel.setBackground(Color.LIGHT_GRAY);
        add(statusLabel, BorderLayout.SOUTH);
    }

    private void handleSquareClick(int row, int col) {
        if (selectedSquare == null) {
            // Select a piece
            ChessPiece piece = board.getPieceAt(row, col);
            if (piece != null && piece.isWhite() == board.isWhiteTurn()) {
                selectedSquare = squares[row][col];
                selectedSquare.setSelected(true);
                legalMoves = board.getLegalMoves(row, col);
                highlightLegalMoves();
            }
        } else {
            // Try to move the selected piece
            int fromRow = selectedSquare.getRow();
            int fromCol = selectedSquare.getCol();

            if (row == fromRow && col == fromCol) {
                // Deselect
                deselectSquare();
            } else if (board.isLegalMove(fromRow, fromCol, row, col)) {
                // Make the move
                Move move = board.makeMove(fromRow, fromCol, row, col);
                updateHistory(move);
                deselectSquare();
                updateBoardDisplay();
                updateStatusBar();
            } else {
                // Invalid move, try selecting a different piece
                deselectSquare();
                handleSquareClick(row, col);
            }
        }
    }

    private void deselectSquare() {
        if (selectedSquare != null) {
            selectedSquare.setSelected(false);
            selectedSquare = null;
        }
        clearHighlights();
        legalMoves.clear();
    }

    private void highlightLegalMoves() {
        for (Point move : legalMoves) {
            squares[move.x][move.y].setHighlighted(true);
        }
    }

    private void clearHighlights() {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                squares[row][col].setHighlighted(false);
            }
        }
    }

    private void updateBoardDisplay() {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                ChessPiece piece = board.getPieceAt(row, col);
                squares[row][col].setPiece(piece);
            }
        }
    }

    private void updateHistory(Move move) {
        historyTextArea.append(move.toString() + "\n");
        historyTextArea.setCaretPosition(historyTextArea.getDocument().getLength());
    }

    private void updateStatusBar() {
        if (board.isWhiteTurn()) {
            statusLabel.setText("White's turn");
        } else {
            statusLabel.setText("Black's turn");
        }
    }

    private void resetGame() {
        board = new ChessBoard();
        selectedSquare = null;
        legalMoves.clear();
        historyTextArea.setText("");
        updateBoardDisplay();
        updateStatusBar();
        clearHighlights();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ChessGame());
    }
}

/**
 * Represents a square on the chess board
 */
class Square extends JButton {
    private int row, col;
    private ChessPiece piece;
    private boolean isSelected;
    private boolean isHighlighted;
    private Color defaultColor;

    public Square(int row, int col) {
        this.row = row;
        this.col = col;
        this.defaultColor = (row + col) % 2 == 0 ? new Color(240, 217, 181) : new Color(181, 136, 99);
        setBackground(defaultColor);
        setFont(new Font("Serif", Font.BOLD, 48));
        setFocusPainted(false);
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
    }

    public void setPiece(ChessPiece piece) {
        this.piece = piece;
        setText(piece != null ? piece.getSymbol() : "");
        setForeground(piece != null && piece.isWhite() ? Color.WHITE : Color.BLACK);
    }

    public void setSelected(boolean selected) {
        this.isSelected = selected;
        updateBackground();
    }

    public void setHighlighted(boolean highlighted) {
        this.isHighlighted = highlighted;
        updateBackground();
    }

    private void updateBackground() {
        if (isSelected) {
            setBackground(new Color(255, 255, 0, 150));
        } else if (isHighlighted) {
            setBackground(new Color(0, 255, 0, 100));
        } else {
            setBackground(defaultColor);
        }
    }

    public int getRow() { return row; }
    public int getCol() { return col; }
}

/**
 * Chess board state manager
 */
class ChessBoard {
    private ChessPiece[][] board;
    private boolean whiteTurn;
    private List<Move> moveHistory;
    private int moveNumber;

    public ChessBoard() {
        board = new ChessPiece[8][8];
        whiteTurn = true;
        moveHistory = new ArrayList<>();
        moveNumber = 1;
        initializeBoard();
    }

    private void initializeBoard() {
        // Black pieces (top)
        board[0][0] = new Rook(false);
        board[0][1] = new Knight(false);
        board[0][2] = new Bishop(false);
        board[0][3] = new Queen(false);
        board[0][4] = new King(false);
        board[0][5] = new Bishop(false);
        board[0][6] = new Knight(false);
        board[0][7] = new Rook(false);
        for (int i = 0; i < 8; i++) {
            board[1][i] = new Pawn(false);
        }

        // White pieces (bottom)
        board[7][0] = new Rook(true);
        board[7][1] = new Knight(true);
        board[7][2] = new Bishop(true);
        board[7][3] = new Queen(true);
        board[7][4] = new King(true);
        board[7][5] = new Bishop(true);
        board[7][6] = new Knight(true);
        board[7][7] = new Rook(true);
        for (int i = 0; i < 8; i++) {
            board[6][i] = new Pawn(true);
        }
    }

    public ChessPiece getPieceAt(int row, int col) {
        return board[row][col];
    }

    public boolean isWhiteTurn() {
        return whiteTurn;
    }

    public List<Point> getLegalMoves(int row, int col) {
        List<Point> moves = new ArrayList<>();
        ChessPiece piece = board[row][col];
        if (piece == null) return moves;

        for (int toRow = 0; toRow < 8; toRow++) {
            for (int toCol = 0; toCol < 8; toCol++) {
                if (piece.isValidMove(row, col, toRow, toCol, board)) {
                    moves.add(new Point(toRow, toCol));
                }
            }
        }
        return moves;
    }

    public boolean isLegalMove(int fromRow, int fromCol, int toRow, int toCol) {
        ChessPiece piece = board[fromRow][fromCol];
        if (piece == null) return false;
        return piece.isValidMove(fromRow, fromCol, toRow, toCol, board);
    }

    public Move makeMove(int fromRow, int fromCol, int toRow, int toCol) {
        ChessPiece piece = board[fromRow][fromCol];
        ChessPiece captured = board[toRow][toCol];

        board[toRow][toCol] = piece;
        board[fromRow][fromCol] = null;
        piece.setMoved(true);

        Move move = new Move(moveNumber, piece, fromRow, fromCol, toRow, toCol, captured);
        moveHistory.add(move);

        whiteTurn = !whiteTurn;
        if (whiteTurn) moveNumber++;

        return move;
    }

    public List<Move> getMoveHistory() {
        return new ArrayList<>(moveHistory);
    }
}

/**
 * Represents a chess move
 */
class Move {
    private int moveNumber;
    private ChessPiece piece;
    private int fromRow, fromCol, toRow, toCol;
    private ChessPiece capturedPiece;

    public Move(int moveNumber, ChessPiece piece, int fromRow, int fromCol,
                int toRow, int toCol, ChessPiece capturedPiece) {
        this.moveNumber = moveNumber;
        this.piece = piece;
        this.fromRow = fromRow;
        this.fromCol = fromCol;
        this.toRow = toRow;
        this.toCol = toCol;
        this.capturedPiece = capturedPiece;
    }

    @Override
    public String toString() {
        String color = piece.isWhite() ? "W" : "B";
        String from = toChessNotation(fromRow, fromCol);
        String to = toChessNotation(toRow, toCol);
        String capture = capturedPiece != null ? "x" : "-";
        return String.format("%d. %s%s %s%s %s",
            moveNumber, color, piece.getType(), from, capture, to);
    }

    private String toChessNotation(int row, int col) {
        char file = (char)('a' + col);
        int rank = 8 - row;
        return "" + file + rank;
    }
}

/**
 * Base class for all chess pieces
 */
abstract class ChessPiece {
    protected boolean isWhite;
    protected boolean hasMoved;

    public ChessPiece(boolean isWhite) {
        this.isWhite = isWhite;
        this.hasMoved = false;
    }

    public boolean isWhite() { return isWhite; }
    public boolean hasMoved() { return hasMoved; }
    public void setMoved(boolean moved) { this.hasMoved = moved; }

    public abstract String getSymbol();
    public abstract String getType();
    public abstract boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol, ChessPiece[][] board);

    protected boolean isPathClear(int fromRow, int fromCol, int toRow, int toCol, ChessPiece[][] board) {
        int rowDir = Integer.compare(toRow - fromRow, 0);
        int colDir = Integer.compare(toCol - fromCol, 0);

        int currentRow = fromRow + rowDir;
        int currentCol = fromCol + colDir;

        while (currentRow != toRow || currentCol != toCol) {
            if (board[currentRow][currentCol] != null) return false;
            currentRow += rowDir;
            currentCol += colDir;
        }
        return true;
    }

    protected boolean canCapture(int toRow, int toCol, ChessPiece[][] board) {
        ChessPiece target = board[toRow][toCol];
        return target == null || target.isWhite() != this.isWhite;
    }
}

class Pawn extends ChessPiece {
    public Pawn(boolean isWhite) { super(isWhite); }

    @Override
    public String getSymbol() { return "♟"; }

    @Override
    public String getType() { return "P"; }

    @Override
    public boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol, ChessPiece[][] board) {
        int direction = isWhite ? -1 : 1;
        int rowDiff = toRow - fromRow;
        int colDiff = Math.abs(toCol - fromCol);

        // Forward move
        if (colDiff == 0 && board[toRow][toCol] == null) {
            if (rowDiff == direction) return true;
            if (!hasMoved && rowDiff == 2 * direction && board[fromRow + direction][fromCol] == null) {
                return true;
            }
        }

        // Capture
        if (colDiff == 1 && rowDiff == direction && board[toRow][toCol] != null
            && board[toRow][toCol].isWhite() != isWhite) {
            return true;
        }

        return false;
    }
}

class Rook extends ChessPiece {
    public Rook(boolean isWhite) { super(isWhite); }

    @Override
    public String getSymbol() { return "♜"; }

    @Override
    public String getType() { return "R"; }

    @Override
    public boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol, ChessPiece[][] board) {
        if (fromRow != toRow && fromCol != toCol) return false;
        return isPathClear(fromRow, fromCol, toRow, toCol, board) && canCapture(toRow, toCol, board);
    }
}

class Knight extends ChessPiece {
    public Knight(boolean isWhite) { super(isWhite); }

    @Override
    public String getSymbol() { return "♞"; }

    @Override
    public String getType() { return "N"; }

    @Override
    public boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol, ChessPiece[][] board) {
        int rowDiff = Math.abs(toRow - fromRow);
        int colDiff = Math.abs(toCol - fromCol);

        if ((rowDiff == 2 && colDiff == 1) || (rowDiff == 1 && colDiff == 2)) {
            return canCapture(toRow, toCol, board);
        }
        return false;
    }
}

class Bishop extends ChessPiece {
    public Bishop(boolean isWhite) { super(isWhite); }

    @Override
    public String getSymbol() { return "♝"; }

    @Override
    public String getType() { return "B"; }

    @Override
    public boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol, ChessPiece[][] board) {
        if (Math.abs(toRow - fromRow) != Math.abs(toCol - fromCol)) return false;
        return isPathClear(fromRow, fromCol, toRow, toCol, board) && canCapture(toRow, toCol, board);
    }
}

class Queen extends ChessPiece {
    public Queen(boolean isWhite) { super(isWhite); }

    @Override
    public String getSymbol() { return "♛"; }

    @Override
    public String getType() { return "Q"; }

    @Override
    public boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol, ChessPiece[][] board) {
        boolean straightLine = fromRow == toRow || fromCol == toCol;
        boolean diagonal = Math.abs(toRow - fromRow) == Math.abs(toCol - fromCol);

        if (straightLine || diagonal) {
            return isPathClear(fromRow, fromCol, toRow, toCol, board) && canCapture(toRow, toCol, board);
        }
        return false;
    }
}

class King extends ChessPiece {
    public King(boolean isWhite) { super(isWhite); }

    @Override
    public String getSymbol() { return "♚"; }

    @Override
    public String getType() { return "K"; }

    @Override
    public boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol, ChessPiece[][] board) {
        int rowDiff = Math.abs(toRow - fromRow);
        int colDiff = Math.abs(toCol - fromCol);

        if (rowDiff <= 1 && colDiff <= 1 && (rowDiff + colDiff > 0)) {
            return canCapture(toRow, toCol, board);
        }
        return false;
    }
}
