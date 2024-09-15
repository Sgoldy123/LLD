package chess;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Piece {
    private PieceType pieceType;
    private String pieceName;
//    private int x;
//    private int y;

}
