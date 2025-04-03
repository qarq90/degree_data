main :: IO ()
main = do
    putStrLn "Incremented:"
    print (map (+1) [1..5])

    putStrLn "Squared:"
    print (map (^2) [1..5])

    putStrLn "Even numbers:"
    print (filter even [1..5])

    putStrLn "Odd numbers:"
    print (filter odd [1..5])
