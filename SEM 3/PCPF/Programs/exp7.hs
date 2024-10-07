divisibleByThree :: [Int]
divisibleByThree = filter (\x -> x `mod` 3 == 0) [1..20]

main :: IO ()
main = print divisibleByThree
