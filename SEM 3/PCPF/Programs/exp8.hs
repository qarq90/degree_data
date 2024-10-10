main :: IO()
main = do
    putStrLn "Double elements greater than 2:"
    print ([x * 2 | x <- [1..5], x > 2])
