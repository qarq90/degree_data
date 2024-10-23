a :: IO ()
a = putStrLn "Custom Function A"

b :: IO ()
b = putStrLn "Custom Function B"

main :: IO ()
main = do
    a
    b
    putStrLn "Built-in function (map) Increment each element by 1:"
    print (map (+1) [1, 2, 3, 4, 5])

    putStrLn "Built-in function (map) Square each element:"
    print (map (^2) [1, 2, 3, 4, 5])

    putStrLn "Built-in function (filter) Filter elements greater than 3:"
    print (filter (>3) [1, 2, 3, 4, 5])

    putStrLn "Built-in function (filter) Filter even numbers from the list:"
    print (filter even [1, 2, 3, 4, 5])

    putStrLn "Built-in function (filter) Filter odd numbers from the list:"
    print (filter odd [1, 2, 3, 4, 5])

    putStrLn "Built-in function (length) Get the length of the list:"
    print (length [1, 2, 3, 4, 5])

    putStrLn "Built-in function (length) Get the head of the list:"
    print (head [1, 2, 3, 4, 5])

    putStrLn "Built-in function (length) Get the tail of the list:"
    print (tail [1, 2, 3, 4, 5])
