% Base case: Move 1 disk from X to Y
move(1, X, Y, _) :-
    write('Move top disk from '),
    write(X), write(' to '), write(Y), nl.

% Recursive case: Move N disks
move(N, X, Y, Z) :-
    N > 1,
    M is N - 1,
    move(M, X, Z, Y),  % Move M disks from X to Z using Y as auxiliary
    move(1, X, Y, _),  % Move the remaining disk from X to Y
    move(M, Z, Y, X).  % Move M disks from Z to Y using X as auxiliary

% Specify what should be executed at startup
:- initialization(main).

% Main predicate to run Tower of Hanoi
main :-
    write('Solving Tower of Hanoi for 3 disks'), nl,
    move(3, 'Left', 'Right', 'Center'),  % Solve for 3 disks
    halt.  % Terminate the program
