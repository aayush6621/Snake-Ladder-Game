# Snake-Ladder-Game
This is a simple game developed using java. The game has `Single Player` and `Two Player` modes. In single player mode, one user will play with the computer, where computer will automatically throw the dice according to its turn.

Concept of `multithreading` is used here. When a new game is started, an object of class `Game` is created. A thread is created for for each player. Game object contains a variable `turn`, that specifies which player's turn it is. A thread representing that player is allowed to throw the dice, while the other one waits for its turn to come. This way, no player comes in each other's way.

The details of each move in a game are recorded in a file `demo.txt` using the concept of `File-Handling`. After the game is finished, each player can see their moves made during the game.

## Home-Page

![Screenshot (74)](https://github.com/aayush6621/Snake-Ladder-Game/assets/116342742/ac957936-2a86-45f8-9235-74c91cb9a95a)

## Game-Board

![Screenshot (75)](https://github.com/aayush6621/Snake-Ladder-Game/assets/116342742/fb2dc0fd-c6bf-49d4-9f66-449338c6acc8)
