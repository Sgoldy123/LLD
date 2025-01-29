package chess;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class User {
    private String userId;
    private String pieceColor;

    public User(String b, String black) {
        this.userId = b;
        this.pieceColor = black;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

//    public void setPieceColor(String pieceColor) {
//        this.pieceColor = pieceColor;
//    }

    public String getPieceColor() {
        return this.pieceColor;
    }
}
