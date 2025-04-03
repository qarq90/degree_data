main :: IO ()
main = do
    putStrLn "List comprehension: Increment each element by 1:"
    print [x + 1 | x <- [1, 2, 3, 4, 5]]

    putStrLn "List comprehension: Square each element:"
    print [x ^ 2 | x <- [1, 2, 3, 4, 5]]

    putStrLn "List comprehension: Filter elements greater than 3:"
    print [x | x <- [1, 2, 3, 4, 5], x > 3]

    putStrLn "List comprehension: Filter even numbers:"
    print [x | x <- [1, 2, 3, 4, 5], even x]

    putStrLn "List comprehension: Filter odd numbers:"
    print [x | x <- [1, 2, 3, 4, 5], odd x]
