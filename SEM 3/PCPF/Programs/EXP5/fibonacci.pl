% Base case: Fibonacci of 0 is 0, and Fibonacci of 1 is 1
fibonacci(0, 0).
fibonacci(1, 1).

% Recursive case: Fibonacci(N) = Fibonacci(N-1) + Fibonacci(N-2)
fibonacci(N, Result) :-
    N > 1, % Ensure N is greater than 1
    N1 is N - 1, % Decrement N by 1
    N2 is N - 2, % Decrement N by 2
    fibonacci(N1, Res1), % Calculate Fibonacci of N-1
    fibonacci(N2, Res2), % Calculate Fibonacci of N-2
    Result is Res1 + Res2. % Result is the sum of Fibonacci(N-1) and Fibonacci(N-2)

% Specify what should be executed at startup
:- initialization(main).

% Main predicate to run Fibonacci calculation
main :-
    write('Fibonacci of 10 is: '), nl,
    fibonacci(10, Result), % Calculate Fibonacci of 10
    write(Result), nl, % Output the result
    halt. % Terminate the program
