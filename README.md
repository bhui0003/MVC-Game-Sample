MVC-Game-Sample
===============

Screenshot
----------
![Screenshot](/screenshot.png)

A simple game written in Java demonstrating the MVC pattern. The goal of this game is to trap the cats by pushing the blocks.
Compile with Java 1.6 or higher.

Creating new levels
-------------------
You can create .txt files and set the program to parse it, example configuration:
  XXXXXXXXXXXXXXXXXXXXXX
  X                    X
  X                    X
  X    bbbbbbbbbbbb    X
  X   bbbbbbbbbbbbbb   X
  X   bbb        bbb   X
  X   bbb        bbb   X
  X   bbb   m    bbb   X
  X   bbb        bbb   X
  X   bbb        bbb   X
  X   bbbbbbbbbbbbbb   X
  X    bbbbbbbbbbbb    X
  X                    X
  X          c         X
  XXXXXXXXXXXXXXXXXXXXXX

where 
*x* or *X* = UnmovableBlock
*b* or *B* = MovableBlock
*m* or *M* = Mouse
*c* or *C* = Cat
*t* or *T* = Trap
*h* or *H* = Cheese

