/*
this is a game for two. one has 'X' and one 'O'. they have to fill a line or a column
or a diagonal with those marks.
whoever fills it first wins the game.
*/
import java.util.Random;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        GameTest game = new GameTest();
        Random random = new Random();//this chooses randomly the player to start the game
        Scanner scan = new Scanner(System.in);
        int round = 1;//when it reaches 9 means there is no more available positions to choose
        int player = random.nextInt(10);//if it`s a pair player 1 will play
        int line = 0;
        int column = 0;
        boolean end = false;

        System.out.println("***HASH GAME***");
        System.out.println("Player 1 = X\nPlayer 2 = 'X");
        game.setHash();
        game.showHash();

        while (!end) {

            //too much repeated code. I`ll try to fix it later 
            //th game starts with a player choosing a position
            game.setMark(player);
            System.out.print(game.setPlayer(player) + " select the line position: ");
            line = scan.nextInt() - 1;
            System.out.print("select the column position: ");
            column = scan.nextInt() - 1;
            while (game.validatePosition(line, column) == false) {//let`s make sure the position exists
                System.out.print(game.setPlayer(player) + " select the line position: ");
                line = scan.nextInt() - 1;
                System.out.print("select the column position: ");
                column = scan.nextInt() - 1;
            }
            while (game.validateRound(line, column) == false) {//is it an available spot?
                System.out.println("This place has been taken!");
                System.out.print(game.setPlayer(player) + " select the line position: ");
                line = scan.nextInt() - 1;
                System.out.print("select the column position: ");
                column = scan.nextInt() - 1;
            }
            if (game.checkWinner(game.setMark(player)) == true) {//does anyone fill a line, column or a diagonal?
                System.out.println("Congratulations!!!");
                System.out.println(game.setPlayer(player) + " wins!!!");
                game.showHash();
                end = true;
            } else if (round > 8) {//once again, this game can have only 9 spots.
                System.out.println("No winners in this round!");
                game.showHash();
                end = true;
            } else {//everything is fine! let`s change the players and increase one more round to the count
                game.validateRound(line, column);
                round++;
                player++;
                game.showHash();//you can see the progress here 
            }
        }
    }
}