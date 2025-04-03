factorial :: Int -> Int
factorial 0 = 1
factorial n | n > 0 = n * factorial (n - 1)

main :: IO ()
main = do
    putStrLn "Enter a number to calculate its factorial:"
    input <- getLine
    let number = read input :: Int
    putStrLn "Calculating..."
    print (factorial number)
