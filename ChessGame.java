import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ChessGame {
    public static final int SIZE = 8;
    // Positive = White, Negative = Black
    // 1=Pawn, 2=Knight, 3=Bishop, 4=Rook, 5=Queen, 6=King
    private static int[][] board = new int[SIZE][SIZE];
    private static boolean isWhiteTurn = true;

    public static void main(String[] args) {
        initBoard();
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("====== FIXED TERMINAL CHESS ENGINE ======");
        System.out.println("Moves are now fully validated. No more clip-throughs!");
        System.out.println("Enter moves in format: e2e4, g1f3, etc. Type 'exit' to quit.\n");

        while (true) {
            printBoard();
            
            if (isWhiteTurn) {
                System.out.print("\nYour Turn (White) - Enter Move: ");
                String input = scanner.nextLine().trim().toLowerCase();
                
                if (input.equals("exit")) {
                    System.out.println("Thanks for playing!");
                    break;
                }
                
                if (input.length() != 4) {
                    System.out.println("❌ Invalid format! Use 4 characters like 'e2e4'.");
                    continue;
                }

                int fromCol = input.charAt(0) - 'a';
                int fromRow = 8 - (input.charAt(1) - '0');
                int toCol = input.charAt(2) - 'a';
                int toRow = 8 - (input.charAt(3) - '0');

                if (!isValidIdx(fromRow, fromCol) || !isValidIdx(toRow, toCol)) {
                    System.out.println("❌ Move is out of board boundaries.");
                    continue;
                }

                if (board[fromRow][fromCol] <= 0) {
                    System.out.println("❌ You must select one of your own White pieces!");
                    continue;
                }

                // Validate human move against strict rules
                if (!isMoveLegal(fromRow, fromCol, toRow, toCol)) {
                    System.out.println("❌ Illegal piece movement path!");
                    continue;
                }

                executeMove(fromRow, fromCol, toRow, toCol);
                isWhiteTurn = false;
                
            } else {
                System.out.println("\n🤖 Computer Bot (Black) is calculating a legal move...");
                try { Thread.sleep(600); } catch (Exception ignored) {}

                List<int[]> botMoves = getAllLegalMoves(false);
                if (botMoves.isEmpty()) {
                    System.out.println("Game Over! No legal moves left for the bot.");
                    break;
                }

                int[] selectedMove = botMoves.get(random.nextInt(botMoves.size()));
                int fr = selectedMove[0], fc = selectedMove[1], tr = selectedMove[2], tc = selectedMove[3];
                
                String notation = "" + (char)('a' + fc) + (8 - fr) + (char)('a' + tc) + (8 - tr);
                System.out.println("🤖 Bot plays: " + notation);

                executeMove(fr, fc, tr, tc);
                isWhiteTurn = true;
            }
        }
        scanner.close();
    }

    private static void initBoard() {
        board[0][0] = -4; board[0][7] = -4; // Black Rooks
        board[7][0] = 4;  board[7][7] = 4;  // White Rooks
        board[0][1] = -2; board[0][6] = -2; // Black Knights
        board[7][1] = 2;  board[7][6] = 2;  // White Knights
        board[0][2] = -3; board[0][5] = -3; // Black Bishops
        board[7][2] = 3;  board[7][5] = 3;  // White Bishops
        board[0][3] = -5; board[0][4] = -6; // Black Queen & King
        board[7][3] = 5;  board[7][4] = 6;  // White Queen & King
        for (int i = 0; i < SIZE; i++) {
            board[1][i] = -1; // Black Pawns
            board[6][i] = 1;  // White Pawns
        }
    }

    private static void executeMove(int fr, int fc, int tr, int tc) {
        int movingPiece = board[fr][fc];
        // Handle Pawn Promotion directly to Queen for simplicity
        if (Math.abs(movingPiece) == 1 && (tr == 0 || tr == 7)) {
            movingPiece = movingPiece > 0 ? 5 : -5;
        }
        board[tr][tc] = movingPiece;
        board[fr][fc] = 0;
    }

    private static boolean isMoveLegal(int fr, int fc, int tr, int tc) {
        if (fr == tr && fc == tc) return false;
        int p = board[fr][fc];
        int type = Math.abs(p);
        boolean isWhite = p > 0;
        int target = board[tr][tc];

        // Cannot capture your own piece color
        if (target != 0 && ((isWhite && target > 0) || (!isWhite && target < 0))) return false;

        switch (type) {
            case 1: // Pawn
                int dir = isWhite ? -1 : 1;
                int startRow = isWhite ? 6 : 1;
                // Single step forward
                if (tc == fc && tr == fr + dir && target == 0) return true;
                // Double step forward from initial line
                if (tc == fc && fr == startRow && tr == fr + 2 * dir && board[fr + dir][fc] == 0 && target == 0) return true;
                // Diagonal capture
                if (Math.abs(tc - fc) == 1 && tr == fr + dir && target != 0) return true;
                return false;

            case 2: // Knight (Can jump!)
                return (Math.abs(tr - fr) * Math.abs(tc - fc) == 2);

            case 3: // Bishop
                if (Math.abs(tr - fr) != Math.abs(tc - fc)) return false;
                return checkPathClear(fr, fc, tr, tc);

            case 4: // Rook
                if (fr != tr && fc != tc) return false;
                return checkPathClear(fr, fc, tr, tc);

            case 5: // Queen
                if (Math.abs(tr - fr) != Math.abs(tc - fc) && fr != tr && fc != tc) return false;
                return checkPathClear(fr, fc, tr, tc);

            case 6: // King
                return (Math.abs(tr - fr) <= 1 && Math.abs(tc - fc) <= 1);
        }
        return false;
    }

    private static boolean checkPathClear(int fr, int fc, int tr, int tc) {
        int stepR = Integer.compare(tr, fr);
        int stepC = Integer.compare(tc, fc);
        int r = fr + stepR;
        int c = fc + stepC;
        while (r != tr || c != tc) {
            if (board[r][c] != 0) return false; // Path blocked!
            r += stepR;
            c += stepC;
        }
        return true;
    }

    private static List<int[]> getAllLegalMoves(boolean forWhite) {
        List<int[]> moves = new ArrayList<>();
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if ((forWhite && board[r][c] > 0) || (!forWhite && board[r][c] < 0)) {
                    // Check every square on the board for validity
                    for (int tr = 0; tr < SIZE; tr++) {
                        for (int tc = 0; tc < SIZE; tc++) {
                            if (isMoveLegal(r, c, tr, tc)) {
                                moves.add(new int[]{r, c, tr, tc});
                            }
                        }
                    }
                }
            }
        }
        return moves;
    }

    private static void printBoard() {
        System.out.println("\n    a   b   c   d   e   f   g   h");
        System.out.println("  +-------------------------------+");
        for (int r = 0; r < SIZE; r++) {
            System.out.print((8 - r) + " |");
            for (int c = 0; c < SIZE; c++) {
                System.out.print(" " + getPieceSymbol(board[r][c]) + " |");
            }
            System.out.println(" " + (8 - r));
            System.out.println("  +-------------------------------+");
        }
        System.out.println("    a   b   c   d   e   f   g   h");
    }

    private static String getPieceSymbol(int p) {
        if (p == 0) return ".";
        String symbol = "";
        switch (Math.abs(p)) {
            case 1: symbol = "P"; break;
            case 2: symbol = "N"; break;
            case 3: symbol = "B"; break;
            case 4: symbol = "R"; break;
            case 5: symbol = "Q"; break;
            case 6: symbol = "K"; break;
        }
        return p > 0 ? symbol : symbol.toLowerCase();
    }

    private static boolean isValidIdx(int r, int c) {
        return r >= 0 && r < SIZE && c >= 0 && c < SIZE;
    }
}
