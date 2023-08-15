# Programming-Assignment-Percolation
This repository contains the code that I developed to address the first programming assignment of the course "Algorithms, Part I"

* Link to the course [algorithms-part1](https://www.coursera.org/learn/algorithms-part1)
* Assignment specifications: [percolation specifications](https://coursera.cs.princeton.edu/algs4/assignments/percolation/specification.php)


## Assignment description
Write a program to estimate the value of the percolation threshold via Monte Carlo simulation.

#### What is percolation?
Percolation is a concept often encountered in the fields of physics, mathematics, and computer science, particularly in the study of networks, materials, and random processes. It refers to the movement or flow of a substance (usually a fluid or particles) through a porous medium or a network of interconnected nodes. The central idea is to investigate how substances spread or percolate through the interconnected pathways within a structure.
  
#### What is Monte Carlo simulation? 
Monte Carlo simulation is a computational technique used to estimate the outcome of complex processes or systems through random sampling. It involves generating a large number of random inputs and using these inputs to simulate the behavior of a system or model. By running the simulation many times, it provides insights into the possible range of outcomes and their probabilities.

#### About my solution? 
* The assignment is solved using the weighted quick union algorithm, I created my own simplified implementation of it represented by the class UnionFind.
* An initial project is provided containing initial packages that can be used to solve the assignment, you can find it in the specifications.
* The Percolation class contains the percolation system following the API provided
* The PercolationStats class contains the second part of the assignment where I perform the Monte Carlo simulation
