% Define the maze as a series of connections.
path(a, b).
path(a, c).
path(b, d).
path(c, d).
path(d, e).
path(e, f).

% Define the rule for finding a path.
find_path(Start, End, Path) :-
    travel(Start, End, [Start], Path).

% Travel from one point to another.
travel(End, End, Visited, Path) :-
    reverse(Visited, Path).  % Reverse the path to show the correct order.

travel(Start, End, Visited, Path) :-
    path(Start, Next),  % Move to the next point.
    \+ member(Next, Visited),  % Avoid cycles.
    travel(Next, End, [Next|Visited], Path).  % Continue the journey.

% Example query to find a path from a to f:
% ?- find_path(a, f, Path).
