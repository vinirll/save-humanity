# Solution

Problem: https://www.hackerrank.com/challenges/save-humanity

The solution is made upon a well-known algorithm called: Z-Algorithm

I've also considered initially the following well-known Algorithms:
- Boyer-Moore
- KMP
- Aho–Corasick

But the Z-Algorithm has similar complexity and are very simple to build for only one mismatch

# Complexity

It is a linear time and space pattern search Algorithm: O(n + m)
- n being the length of the Text
- m being the length of the Pattern

This problem can be solved in polynomial time, so this problem is in class P

# Tests

## All local tests are written using Spek Framework
## All hackerrank tests are passing


Main References:
- http://www.utdallas.edu/~besp/demo/John2010/z-algorithm.htm
- https://www.quora.com/Find-a-pattern-in-a-string-with-one-or-zero-mismatch-Eg-S-abbbaaabbbabab-P-abab-Matches-are-abbb-index-0-aaab-index-4-abbb-index-6-abab-index-10-I-guess-it-can-be-done-by-some-modification-of-KMP-algorithm