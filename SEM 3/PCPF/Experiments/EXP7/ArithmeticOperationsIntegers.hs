main :: IO ()
main = do
    putStrLn "Enter the first integer:"
    xStr <- getLine
    putStrLn "Enter the second integer:"
    yStr <- getLine

    let x = read xStr :: Int
    let y = read yStr :: Int

    if y /= 0
        then putStrLn $ "Division: " ++ show (x `div` y)
        else putStrLn "Division: Cannot divide by zero."
    
    putStrLn $ "Addition: " ++ show (x + y)
    putStrLn $ "Subtraction: " ++ show (x - y)
    putStrLn $ "Multiplication: " ++ show (x * y)
    
    
