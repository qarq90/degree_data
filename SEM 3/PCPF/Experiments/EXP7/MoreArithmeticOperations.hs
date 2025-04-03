main :: IO ()
main = do
    putStrLn "Enter the first number for multiplication:"
    xStr <- getLine
    putStrLn "Enter the second number for multiplication:"
    yStr <- getLine
    putStrLn "Multiplication result:"
    print (read xStr * read yStr)

    putStrLn "Enter a number to double:"
    numStr <- getLine
    putStrLn "Doubled number:"
    print (read numStr * 2)

    putStrLn "Numbers in range 1 to 20 that are divisible by 3:"
    print (filter (\x -> x `mod` 3 == 0) [1..20])
