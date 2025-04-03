main :: IO ()
main = do
    putStrLn "Enter the number of terms:"
    n <- readLn
    print (take n (fibonacci 0 1))

fibonacci :: Int -> Int -> [Int]
fibonacci a b = a : fibonacci b (a + b)