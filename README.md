MVC-Game-Sample
===============

Screenshot
----------
![Screenshot](/screenshot.png)

A simple game written in Java demonstrating the MVC pattern. The goal of this game is to trap the cats by pushing the blocks. Compile with Java 1.6 or higher.

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

<table>
  <tr> 
    <td><b>x</b> or <b>X</b></td>
    <td><i>UnmovableBlock</i></td>
  </tr>
  <tr>
    <td><b>b</b> or <b>B</b></td>
    <td><i>MovableBlock</i></td>
  </tr>
    <td><b>m</b> or <b>M</b></td>
    <td><i>Mouse</i></td>
  <tr>
    <td><b>c</b> or <b>C</b></td>
    <td><i>Cat</i></td>
  </tr>
  <tr>
    <td><b>t</b> or <b>T</b></td>
    <td><i>Trap</i></td>
  </tr>
  <tr>
    <td><b>h</b> or <b>H</b></td>
    <td><i>Cheese</i></td>
  </tr>
  
</table>

License
--------
    Copyright (C) 2014  Nima Ghafoori
    
    This program is free software; you can redistribute it and/or
    modify it under the terms of the GNU General Public License
    as published by the Free Software Foundation; either version 2
    of the License, or (at your option) any later version.
    
    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.
    
    You should have received a copy of the GNU General Public License
    along with this program; if not, write to the Free Software
    Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
