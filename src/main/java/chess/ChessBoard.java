//package chess;
//
//public class ChessBoard {
//    private Piece board[][];
//    private static ChessBoard chessBoard=new ChessBoard();
//    private int n=8;
//    private ChessBoard(){
//        board=new Piece[8][8];
//        Piece blackPawn=new Piece("BP",(PieceType.PAWN));
//        Piece blackRookie=Piece.builder().pieceName("BR").pieceType(PieceType.ROOKIE).build();
//        Piece blackBishop=Piece.builder().pieceName("BB").pieceType(PieceType.BISHOP).build();
//        Piece blackKnight=Piece.builder().pieceName("BN").pieceType(PieceType.KNIGHT).build();
//        Piece blackQueen=Piece.builder().pieceName("BQ").pieceType(PieceType.QUEEN).build();
//        Piece blackKing=Piece.builder().pieceName("BK").pieceType(PieceType.KING).build();
//
//        for(int i=0;i<8;i++)board[1][i]=blackPawn;
//        board[0][0]=board[0][7]=blackRookie;
//        board[0][1]=board[0][6]=blackKnight;
//        board[0][2]=board[0][5]=blackBishop;
//        board[0][3]=blackQueen;
//        board[0][4]=blackKing;
//
//
//        Piece whitePawn=Piece.builder().pieceName("WP").pieceType(PieceType.PAWN).build();
//        Piece whiteRookie=Piece.builder().pieceName("WR").pieceType(PieceType.ROOKIE).build();
//        Piece whiteBishop=Piece.builder().pieceName("WB").pieceType(PieceType.BISHOP).build();
//        Piece whiteKnight=Piece.builder().pieceName("WN").pieceType(PieceType.KNIGHT).build();
//        Piece whiteQueen=Piece.builder().pieceName("WQ").pieceType(PieceType.QUEEN).build();
//        Piece whiteKing=Piece.builder().pieceName("WK").pieceType(PieceType.KING).build();
//
//        for(int i=0;i<8;i++)board[6][i]=whitePawn;
//        board[7][0]=board[7][7]=whiteRookie;
//        board[7][1]=board[7][6]=whiteKnight;
//        board[7][2]=board[7][5]=whiteBishop;
//        board[7][3]=whiteQueen;
//        board[7][4]=whiteKing;
//    }
//
//
//    public static ChessBoard getInstance(){
//        return new ChessBoard();
//    }
//
//    public boolean isValidate(String prev,String curr,User user){
//
//        int y=prev.charAt(0)-'a';
//        int x=prev.charAt(1)-'1';
//
//        int ny=curr.charAt(0)-'a';
//        int nx=curr.charAt(1)-'1';
//
//        Piece piece=board[x][y];
//        if(user.getPieceColor().charAt(0)!=piece.getPieceName().charAt(0)) return false;
//
//        // check for pawn
//        if(piece.getPieceType()==PieceType.PAWN){
//            if(!pawnMovementIsCorrect(x,y,nx,ny,piece.getPieceName()))return false;
//        }
//
//
//
//        return true;
//    }
//
//    private boolean pawnMovementIsCorrect(int x,int y,int nx,int ny,String color){
//        if(color=="WP"){
//            if(y!=ny)return false;
//            if(nx-x==-1 || (x==6 && nx-x==-2)){return true;}
//            else return false;
//        }
//        else{
//            if(y!=ny)return false;
//            if(nx-x==1 || (x==1 && nx-x==2)){return true;}
//            else return false;
//        }
//    }
//
//    public void update(String prev,String curr){
//
//        int y=prev.charAt(0)-'a';
//        int x=prev.charAt(1)-'1';
////        System.out.println(x+" "+y);
//        Piece piece=board[x][y];
//        board[x][y]=null;
//
//        y=curr.charAt(0)-'a';
//        x=curr.charAt(1)-'1';
////        piece.setX(x);
////        piece.setY(y);
////        System.out.println(x+" "+y);
//        board[x][y]=piece;
//    }
//
//
//    void printChessBoard(){
//        for(int i=0;i<8;i++){
//            for(int j=0;j<8;j++){
//                if(board[i][j]==null){
//                    System.out.print("-- ");
//                }
//                else{
//                    System.out.print(board[i][j].getPieceName()+" ");
//                }
//            }
//            System.out.println();
//        }
//        System.out.println(" ************************* ");
//        System.out.println();
//    }
//
//
//    public  boolean isWin(String pieceColor){
//        boolean flag=true;
//        for(int i=0;i<n;i++){
//            for(int j=0;j<n;j++){
//                Piece piece=board[i][j];
//                if(piece!=null){
//
//                    if(pieceColor=="White" && piece.getPieceName().charAt(0)=='B'){
//                        if(piece.getPieceType()==PieceType.KING){
//                            flag=false;
//                        }
//                    }
//                    if(pieceColor=="Black" && piece.getPieceName().charAt(0)=='W'){
//                        if(piece.getPieceType()==PieceType.KING){
//                            flag=false;
//                        }
//                    }
//                }
//            }
//        }
//
//        return flag;
//    }
//
//}
