package cis;

import cis.entity.Tictactoe;
import cis.util.CisUtility;
import java.util.Scanner;

/**
 * Tic-tac-toe game
 * @author Othon Lima
 * @since 20220209
 */
public class Controller
{
    public static void main(String[] args)
    {
        Tictactoe tictactoe = new Tictactoe();
        
        int winner = 0;
        int playerTurn = Tictactoe.CROSS;
        int roundsPlayed = 0;
        int maxRounds = Tictactoe.getBOARD_SIZE() * Tictactoe.getBOARD_SIZE();
        
        tictactoe.showBoard();
        
        while (winner == 0 && roundsPlayed < maxRounds)
        {
            tictactoe.choosePosition(playerTurn);
            tictactoe.showBoard();
            winner = tictactoe.winnerChecker();
            
            if (winner == Tictactoe.CROSS)
            {
                System.out.println("X is the winner!!!");
            }
            else if (winner == Tictactoe.NOUGHT)
            {
                System.out.println("O is the winner!!!");
            }
            
            if (playerTurn == Tictactoe.NOUGHT)
            {
                playerTurn = Tictactoe.CROSS;
            }
            else
            {
                playerTurn = Tictactoe.NOUGHT;
            }
            
            roundsPlayed++;
        }
        
        if (roundsPlayed == maxRounds)
        {
            System.out.println("It's a tie :/");
        }
    }
}
