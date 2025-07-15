# [Gold V] Number Matrix - 6881 

[문제 링크](https://www.acmicpc.net/problem/6881) 

### 성능 요약

메모리: 33416 KB, 시간: 360 ms

### 분류

그래프 이론, 브루트포스 알고리즘, 그래프 탐색, 너비 우선 탐색, 깊이 우선 탐색

### 제출 일자

2025년 7월 15일 14:58:45

### 문제 설명

<p>Johnny Cannook has been trapped in the matrix: no, not that matrix. This matrix is a grid of width N (1 ≤ N ≤ 100) numbers (in the range 0 to 9) in each row, and M rows (1 ≤ M ≤ 100).</p>

<p>Johnny can pick any position on the first row to begin at. He must make it to row M of the matrix in order to escape.</p>

<p>However, there is a restriction. Johnny can only choose a trinity of numbers (from the range 0 to 9), and he can only step on those positions which are one of these three chosen numbers. That is just the way it is.</p>

<p>The path may begin at any position in row 1, and can move left, right, up, or down (no diagonal movement allowed) to any number, so long as that number is in the set of the chosen three.</p>

### 입력 

 <p>The first line of input contains the two integers N and M. On the next M lines, there are N numbers (each separated by a space).</p>

### 출력 

 <p>The output is one line long, containing three integers: the trinity of numbers that Johnny should chose in order to escape the matrix. If there is no path from row 1 to row M (that is, Johnny is stuck in the matrix FOREVER), the output should be three −1. If there is a path, then the lexicographically first three numbers should be outputted. (Notice that 0, 0, 0 comes before 0, 0, 1, which comes before 0, 0, 2, ..., which comes before 9, 9, 8 which comes before 9, 9, 9). You should notice that the three chosen numbers need not be distinct.</p>

