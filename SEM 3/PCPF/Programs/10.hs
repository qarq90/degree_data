import Data.List (intersperse, transpose)
import Data.Char (digitToInt)
import Text.Read (readMaybe)

type Board = [[Char]]

-- Initialize an empty board
emptyBoard :: Board
emptyBoard = replicate 3 (replicate 3 ' ')

-- Display the board
printBoard :: Board -> IO ()
printBoard b = putStrLn $ unlines $ map (intersperse '|') b

-- Check if a player has won
checkWin :: Board -> Char -> Bool
checkWin board player =
    let rows = board
        cols = transpose board
        diag1 = [board !! i !! i | i <- [0..2]]
        diag2 = [board !! i !! (2 - i) | i <- [0..2]]
    in any (all (== player)) (rows ++ cols ++ [diag1, diag2])

-- Check if the board is full
isFull :: Board -> Bool
isFull = all (all (/= ' '))

-- Make a move on the board
makeMove :: Board -> Int -> Int -> Char -> Board
makeMove board row col player =
    take row board ++ [take col (board !! row) ++ [player] ++ drop (col + 1) (board !! row)] ++ drop (row + 1) board

-- Function to parse user input
parseInput :: String -> Maybe (Int, Int)
parseInput input = 
    case words input of
        [r, c] -> do
            row <- readMaybe r
            col <- readMaybe c
            if row >= 0 && row <= 2 && col >= 0 && col <= 2
                then return (row, col)
                else Nothing
        _ -> Nothing

-- Main function to play the game
main :: IO ()
main = playGame emptyBoard 'X'

-- Recursive function to continue the game
playGame :: Board -> Char -> IO ()
playGame board player = do
    printBoard board
    if checkWin board (if player == 'X' then 'O' else 'X')
        then putStrLn $ "Player " ++ [if player == 'X' then 'O' else 'X'] ++ " wins!"
        else if isFull board
            then putStrLn "It's a draw!"
            else do
                putStrLn $ "Player " ++ [player] ++ ", enter row and column (0-2) separated by a space (e.g., '1 2'):"
                input <- getLine
                case parseInput input of
                    Just (row, col) ->
                        if board !! row !! col /= ' '
                            then putStrLn "Invalid move, try again." >> playGame board player
                            else playGame (makeMove board row col player) (if player == 'X' then 'O' else 'X')
                    Nothing -> putStrLn "Invalid input, try again." >> playGame board player
