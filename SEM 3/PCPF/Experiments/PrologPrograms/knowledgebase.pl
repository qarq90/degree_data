% Facts
parent(john, mary).
parent(john, tom).
parent(susan, mary).
parent(susan, tom).
parent(mary, alice).
parent(mary, bob).
parent(tom, charlie).

% Rules
mother(X, Y) :- parent(X, Y), female(X).
father(X, Y) :- parent(X, Y), male(X).
sibling(X, Y) :- parent(Z, X), parent(Z, Y), X \= Y.
grandparent(X, Y) :- parent(X, Z), parent(Z, Y).
aunt(X, Y) :- sibling(X, Z), parent(Z, Y), female(X).
uncle(X, Y) :- sibling(X, Z), parent(Z, Y), male(X).

% Facts about genders
female(mary).
female(susan).
female(alice).
female(charlie).  % Assuming Charlie is not gender-specific, but can represent for context
male(john).
male(tom).
male(bob).

% Additional rules can be defined as needed
