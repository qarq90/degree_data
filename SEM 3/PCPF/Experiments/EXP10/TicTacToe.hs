import Data.List (intercalate, transpose,intersperse)

type Board = [[Char]]
type Position = (Int, Int)

-- Initialize an empty board
initBoard :: Board
initBoard = replicate 3 (replicate 3 ' ')

-- Print the board
printBoard :: Board -> IO ()
printBoard board = putStrLn $ intercalate "\n-----\n" (map (intersperse '|') board)

-- Check if there's a winner
checkWinner :: Board -> Maybe Char
checkWinner board = 
    let rows = board
        cols = transpose board
        diags = [[board !! i !! i | i <- [0..2]], [board !! i !! (2-i) | i <- [0..2]]]
        lines = rows ++ cols ++ diags
    in  case filter (\line -> all (== 'X') line) lines of
            (_:_) -> Just 'X'
            [] -> case filter (\line -> all (== 'O') line) lines of
                (_:_) -> Just 'O'
                [] -> Nothing

-- Make a move
makeMove :: Board -> Position -> Char -> Board
makeMove board (row, col) player = 
    let (r1, r2:r3) = splitAt row board
        (c1, _:c2) = splitAt col r2
    in r1 ++ [c1 ++ [player] ++ c2] ++ r3

-- Check if the board is full
isFull :: Board -> Bool
isFull = all (all (/= ' '))

-- Parse input safely
parseInput :: String -> Maybe Position
parseInput input =
    case reads input :: [((Int, Int), String)] of
        [((x, y), "")] -> Just (x, y)
        _              -> Nothing

-- Main game loop
playGame :: Board -> Char -> IO ()
playGame board player = do
    printBoard board
    case checkWinner board of
        Just winner -> putStrLn $ "Player " ++ [winner] ++ " wins!"
        Nothing -> 
            if isFull board
            then putStrLn "It's a draw!"
            else do
                putStrLn $ "Player " ++ [player] ++ ", enter row and column (format: x,y): "
                input <- getLine
                case parseInput input of
                    Just (row, col) | row >= 0 && row < 3 && col >= 0 && col < 3 && (board !! row !! col) == ' ' -> 
                        playGame (makeMove board (row, col) player) (if player == 'X' then 'O' else 'X')
                    _ -> do
                        putStrLn "Invalid move, try again."
                        playGame board player

main :: IO ()
main = playGame initBoard 'X'
