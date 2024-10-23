main :: IO ()
main = do
    putStrLn "Increment each element by 1 using map:"
    print (map (+1) [1, 2, 3, 4, 5])
    
    putStrLn "Increment each element by 1 using list comprehension:"
    print [x + 1 | x <- [1, 2, 3, 4, 5]]
    
    putStrLn "Filter elements greater than 3 using filter:"
    print (filter (>3) [1, 2, 3, 4, 5])
    
    putStrLn "Filter elements greater than 3 using list comprehension:"
    print [x | x <- [1, 2, 3, 4, 5], x > 3]
    
    putStrLn "Filter even numbers from the list using filter:"
    print (filter even [1, 2, 3, 4, 5])
    
    putStrLn "Filter even numbers using list comprehension:"
    print [x | x <- [1, 2, 3, 4, 5], even x]
    
    putStrLn "Filter odd numbers from the list using filter:"
    print (filter odd [1, 2, 3, 4, 5])
    
    putStrLn "Filter odd numbers using list comprehension:"
    print [x | x <- [1, 2, 3, 4, 5], odd x]
    
    putStrLn "Get the length of the list:"
    print (length [1, 2, 3, 4, 5])
    
    putStrLn "Get the head of the list:"
    print (head [1, 2, 3, 4, 5])
    
    putStrLn "Get the tail of the list:"
    print (tail [1, 2, 3, 4, 5])
