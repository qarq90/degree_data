#include <iostream>
#include <vector>

using namespace std;

char checkWinner(const vector<vector<char>> &board)
{
    // Check rows and columns
    for (int i = 0; i < 3; i++)
    {
        if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' ')
            return board[i][0];
        if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != ' ')
            return board[0][i];
    }

    // Check diagonals
    if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ')
        return board[0][0];
    if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' ')
        return board[0][2];

    return ' ';
}

void printBoard(const vector<vector<char>> &board)
{
    for (const auto &row : board)
    {
        for (char cell : row)
        {
            cout << (cell == ' ' ? '-' : cell) << " ";
        }
        cout << endl;
    }
}

int main()
{
    vector<vector<char>> board(3, vector<char>(3, ' '));
    char winner = ' ';
    int moves = 0;
    char currentPlayer = 'X';

    while (winner == ' ' && moves < 9)
    {
        printBoard(board);
        int row, col;
        cout << "Player " << currentPlayer << ", enter row and column (0-2): ";
        cin >> row >> col;

        if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ')
        {
            board[row][col] = currentPlayer;
            winner = checkWinner(board);
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            moves++;
        }
        else
        {
            cout << "Invalid move, try again." << endl;
        }
    }

    printBoard(board);
    if (winner != ' ')
        cout << "Player " << winner << " wins!" << endl;
    else
        cout << "It's a draw!" << endl;

    return 0;
}
