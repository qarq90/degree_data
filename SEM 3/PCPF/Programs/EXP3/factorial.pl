% Base case: factorial of 0 is 1
factorial(0, 1). 

% Recursive case: factorial of N is N multiplied by factorial of N-1
factorial(N, Result) :-
    N > 0, % Ensure N is greater than 0
    X is N - 1, % Decrement N
    factorial(X, Y), % Recursive call to calculate factorial of N-1
    Result is N * Y. % Result is N multiplied by factorial of N-1

% Specify what should be executed at startup
:- initialization(main).

main :-
    factorial(5, Result), % Calculate the factorial of 5
    write('Factorial is: '),
    write(Result),
    nl. % New line for better readability
