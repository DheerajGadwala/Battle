# PDP_Project_02: Battles

### 1. About
In this project we use the principles of object oriented programming to implement a solution for the implementation of turn-based game. 
My design has many loosely coupled components which can be reused elsewhere. I have used the ADT linked list to represent a list the player's gears. 
The difficult part of this project was testing the various classess ans methods. This was solved by the use of a wrapper class around Java.util.Random, 
along with another pseudoRandom class which takes integer varargs as parameters ans allows simulation of random number generation, 
both these classes extended an interface and had the same methods. This helps with testing the various classes of this module.


### 2. List of features:
##### 1. The user can create players and senf them into battle.
##### 2. The battle pits the players against one another until one of them wins.
##### 3. The third outcome is a draw, where on generation of the gears it is checked if it is possible for anyone to win. If winning is not a possibility, we conclude that it is a draw.
##### 4. The Arena only allows players who do not have any gear on them and have full health.
##### 5. Gear is randomly generated on addition of players to the Arena. We generate a minimum of 40 gear[15 belts, 15 potions, 5 headgear and 5 footgear]. Out of which 20 are given to one and 20 to another.
##### 6. Players might not be able to use all equipment they have been given because they have limitations like: one helmet per player, one footgear per player, etc.
##### 7. After a winner or a draw is declared, a rematch between the players can be requested.
##### 8. In a rematch, the players health is rejuvenated and they are given new gear.

### 3. How to run:
  * To use the JAR file, we have to import it into intelliJ from where it can be run.
  * We can also run the JAR file using a CLI with the command 'java -jar <jar-file-name>.jar'
  * Each run of the program generates different output.

### 4. How to use the program:
  * When you run the program, a welcome message is generated 
  * This is followed by the players bare stats, i.e., stats without gear.
  * Then the first match starts, here the gear is assigned and the new player stats with the gear is displayed.
  * The description of the first round will soon follow.
  * The driver then asks if you want a rematch.
  * If it recieves a positive feedback, it proceeds to the second match with new gear and full healths.

### 5. Description of examples:
    Driver test runs:
    When a winner exists:
    (1) Welcome Message
    (2) Base stats of the players.
    (3) NEW MATCH indication
    (4) Player descriptions with newly added gear and weapon
    (5) Decision of who attacks first
    (6) Round 1: message showing who attacks whom
    (7) Shows if there was any damage or the attack was evaded.
    (8) Shows new healths
    (9) This information is displayed until some wins.
    (10) When someone wins, he is declared as the winner.
    (11) Driver asks if a rematch is wanted.
    (12) Starts again from (3)
    
    When there is a draw on one of the rematches:
    (3) NEW MATCH indication
    (4) Player descriptions with newly added gear and weapon
    (5) If internal calculations indicate that a draw is inevitable, a message is displayed and the match is ended.
    (6) Driver then asks if a rematch is wanted.
    (7) Start again from (3)
    
    Causes for rematch:
    (1) Both players successfully evade each other every single time. [This usually happens when both players have low effective strength and high effective dexterity]
    (2) Both players are not able to break the other's armour/ constitution. [This usually happens when both players have low effective strength and high effective constitution]
    
### 6. Design changes:
###### decided to add ADT linked list Gears for efficient insertion sort.
###### Scrapped separate interfaces for armoury and bag of gears because both had similar functionalities. Hence gave them a single container interface.
###### Scrapped the idea of organs entirely, felt irrelevant to the project's aim. The concept of organs interfered with sorting of gears.
###### Added an extra layer of abstraction for Gears, so that the project is Open for extension and closed for modification for future gears.
###### Added fists instead of noWeapon.

### 7. Assumptions:
###### The number of gears generated in the arena is not exactly 25% because the number of gears in my program is not a multiple of 4. It lies around 25%-27% though. We generate 15-25 potions, 15-25 belts, 5-10 footgear and 5-10 headgear.
###### Player does not choose the gear, he gets it FCFS. If he gets better headgear later, he can not equip it.
###### On rematch players get new gear.

### 8. Limitations:
###### I had to take extreme measures to test some of the parts because of the complexity and randomness.
###### I had to include some internal tests.

### 9. Citations:
###### [Effective Java](https://learning.oreilly.com/library/view/effective-java/9780134686097/)
