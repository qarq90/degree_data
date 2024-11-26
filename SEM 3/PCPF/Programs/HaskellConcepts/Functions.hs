-- Defining the 'addUs' function that adds two numbers
addUs :: Int -> Int -> Int
addUs x y = x + y

-- Defining the 'multiplyUs' function that multiplies two numbers using recursion and guard expressions
multiplyUs :: Int -> Int -> Int
multiplyUs x y
  | y == 0    = 0                              -- Base case: If second number is 0, the result is 0
  | y < 0     = -(multiplyUs x (negate y))     -- If second number is negative, negate the result
  | otherwise = addUs x (multiplyUs x (y - 1)) -- Recursive case: Add the first number repeatedly

-- Main function to test the addUs and multiplyUs functions
main :: IO ()
main = do
  let resultAdd = addUs 2 3  -- Example of addition
  putStrLn ("Result of addition: " ++ show resultAdd)
  
  let resultMultiply = multiplyUs (-2) 3  -- Example of multiplication with negative numbers
  putStrLn ("Result of multiplication: " ++ show resultMultiply)
  print([1..])
