package cis.entity;

import cis.util.CisUtility;

/**
 * Represents a tic-tac-toe game
 * @author Othon Lima
 * @since  Feb 9, 2022
 */
public class Tictactoe 
{
    private int[][] board = new int[BOARD_SIZE][BOARD_SIZE];
    public static final int NOUGHT = 1;
    public static final int CROSS = 100;
    public static final int BOARD_SIZE = 3;

    public static int getNOUGHT()
    {
        return NOUGHT;
    }

    public static int getCROSS()
    {
        return CROSS;
    }

    public static int getBOARD_SIZE()
    {
        return BOARD_SIZE;
    }
       
    public void choosePosition(int playerTurn)
    {
        int selectedRow = 0;
        int selectedColumn = 0;
        boolean validSpot = false;
        
        while(!validSpot)
        {
            do
            {
                selectedRow = CisUtility.getInputInt("Select row (1-" + BOARD_SIZE + ")") - 1;
            }while(selectedRow < 0 || selectedRow > BOARD_SIZE);

            do
            {
                selectedColumn = CisUtility.getInputInt("Select column (1-" + BOARD_SIZE + ")") - 1;
            }while(selectedColumn < 0 || selectedColumn > BOARD_SIZE);

            if (board[selectedRow][selectedColumn] > 0)
            {
                System.out.println("This spot is already taken, choose again");
            }
            else
            {
                validSpot = true;
            }
        }
        
        board[selectedRow][selectedColumn] = playerTurn;
    }
    
    public void showBoard()
    {
        for (int rowIndex = 0; rowIndex < BOARD_SIZE; rowIndex++)
        {
            String boardRow = "";
            
            for (int columnIndex = 0; columnIndex < BOARD_SIZE; columnIndex++)
            {
                switch(board[rowIndex][columnIndex])
                {
                    case 0:
                        boardRow += " ";
                        break;
                    case NOUGHT:
                        boardRow += "O";
                        break;
                    case CROSS:
                        boardRow += "X";
                        break;
                }
                
                if (columnIndex != (BOARD_SIZE - 1))
                {
                    boardRow += " | ";
                }
            }
            
            System.out.println(boardRow);
            
            if (rowIndex != (BOARD_SIZE - 1))
            {
                System.out.println("---------");
            }
        }
    }
    
    public int winnerChecker()
    {
        for (int rowIndex = 0; rowIndex < BOARD_SIZE; rowIndex++)
        {
            int rowSum = 0;
            
            for (int columnIndex = 0; columnIndex < BOARD_SIZE; columnIndex++)
            {
                rowSum += board[rowIndex][columnIndex];
            }
            
            if (rowSum == (NOUGHT * BOARD_SIZE))
            {
                return NOUGHT;
            }    
            else if(rowSum == (CROSS * BOARD_SIZE))
            {
                return CROSS;
            }
        }
        
        for (int columnIndex = 0; columnIndex < BOARD_SIZE; columnIndex++)
        {
            int columnSum = 0;
            
            for (int rowIndex = 0; rowIndex < BOARD_SIZE; rowIndex++)
            {
                columnSum += board[rowIndex][columnIndex];
            }
            
            if (columnSum == (NOUGHT * BOARD_SIZE))
            {
                return NOUGHT;
            }    
            else if(columnSum == (CROSS * BOARD_SIZE))
            {
                return CROSS;
            }
        }
        
        int diagonalSum1 = 0;
        int diagonalSum2 = 0;
        for (int diagonalIndex = 0; diagonalIndex < BOARD_SIZE; diagonalIndex++)
        {            
            diagonalSum1 += board[diagonalIndex][diagonalIndex];
            diagonalSum2 += board[diagonalIndex][BOARD_SIZE - 1 - diagonalIndex];
        }
        
        if (diagonalSum1 == (NOUGHT * BOARD_SIZE) || diagonalSum2 == (NOUGHT * BOARD_SIZE))
        {
            return NOUGHT;
        }
        
        if (diagonalSum1 == (CROSS * BOARD_SIZE) || diagonalSum2 == (CROSS * BOARD_SIZE))
        {
            return CROSS;
        }
        
        return 0;
    }
    
}
