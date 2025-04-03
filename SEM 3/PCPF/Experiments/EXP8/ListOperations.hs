main :: IO ()
main = do
    putStrLn "Increment each element by 1:"
    print (map (+1) [1, 2, 3, 4, 5])

    putStrLn "Square each element:"
    print (map (^2) [1, 2, 3, 4, 5])

    putStrLn "Filter elements greater than 3:"
    print (filter (>3) [1, 2, 3, 4, 5])

    putStrLn "Filter even numbers from the list:"
    print (filter even [1, 2, 3, 4, 5])

    putStrLn "Filter odd numbers from the list:"
    print (filter odd [1, 2, 3, 4, 5])

    putStrLn "Get the length of the list:"
    print (length [1, 2, 3, 4, 5])

    putStrLn "Get the head of the list:"
    print (head [1, 2, 3, 4, 5])

    putStrLn "Get the tail of the list:"
    print (tail [1, 2, 3, 4, 5])


