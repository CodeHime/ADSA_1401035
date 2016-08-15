Problem Statement

Let M be an n×n matrix (think of Microsoft Excel file) with following structure

• Each cell of M is indexed by iσ, where i ∈ N \ {0} and σ is an alphabet
or set of alphabets.

• Every cell iσ is either a constant number or a formula whose variables are
other cells of M.

Design, implement and analyse a space and time efficient algorithm and nec-
essary data structure for the cells of M such that when a particular cell i0σ0
is updated there is least amount of computation required to update the cells
depending on i0σ0 and thus producing an efficient matrix update mechanism.

Clearly list down approach(s), required function(s) with inputs and outputs.
Make necessary assumptions (Size of the matrix: 100,000× 100,000, having at
most 10,000 formulas and every formula has at most 15 variables) for the same.
