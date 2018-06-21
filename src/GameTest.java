/*
this class tests the possibilities of mistakes and makes it work.
it also sets the marks on the hash and sets the players turn on each round
*/
public class GameTest {
    
    char[][] hash = new char[3][3];
    String player;
    char mark;
    
    void setHash(){
        for(int i = 0; i <hash.length; i++){
            for(int j = 0; j < hash[i].length; j++){
                hash[i][j] = ' ';
            }
        }
    }
    void showHash(){
        for(int i = 0; i <hash.length; i++){
            System.out.print("|");
            for(int j = 0; j < hash[i].length; j++){
                System.out.print(hash[i][j] + "|");
            }
            System.out.println();
        }
    }
    char setMark(int round){//this adds marks to players
        if(round % 2 == 0){//if its pair that means it is player 1
            return mark = 'X';
        }else{
            return mark = 'O';
        }
    }
    String setPlayer(int round){//this just changes the players
        if(round % 2 == 0){//if its pair that means it is player 1
            return player = "Player 1";
        }else{
            return player = "Player 2";
        }
    }
    boolean validateRound(int i, int j){//check if the position is available
        if(hash[i][j] == 'X'|| hash[i][j] == 'O'){
            return false;
        }else{
            hash[i][j] = mark;
            return true;
        }
    }
    boolean validatePosition(int i, int j){//to make sure the player will choose a real position
        if(i < 0 || i > 2 || j < 0 || j > 2){
            System.out.println("Invalid position, try again!");
            return false;
        }else{
            return true;
        }
    }
    boolean checkWinner(char mark) {//if a line or a column or a diagonal is complete, we have a winner
        if (hash[0][0] == mark && hash[0][1] == mark && hash[0][2] == mark
                || hash[1][0] == mark && hash[1][1] == mark && hash[1][2] == mark
                || hash[2][0] == mark && hash[2][1] == mark && hash[2][2] == mark
                || hash[0][0] == mark && hash[1][0] == mark && hash[2][0] == mark
                || hash[0][1] == mark && hash[1][1] == mark && hash[2][1] == mark
                || hash[0][2] == mark && hash[1][2] == mark && hash[2][2] == mark
                || hash[0][0] == mark && hash[1][1] == mark && hash[2][2] == mark
                || hash[2][0] == mark && hash[1][1] == mark && hash[0][2] == mark) {
            return true;
        }else{
            return false;
        }
    }
}
