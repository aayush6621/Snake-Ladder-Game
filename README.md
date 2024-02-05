# Snake-Ladder-Game
This is a simple game developed using java. The game has `Single Player` and `Two Player` modes. In single player mode, one user will play with the computer, where computer will automatically throw the dice according to its turn.

Concept of `multithreading` is used here. When a new game is started, an object of class `Game` is created. A thread is created for for each player. Game object contains a variable `turn`, that specifies which player's turn it is. A thread representing that player is allowed to throw the dice, while the other one waits for its turn to come. This way, no player comes in each other's way.

The details of each move in a game are recorded in a file `demo.txt` using the concept of `File-Handling`. After the game is finished, each player can see their moves made during the game.

## Home-Page
  <br />
  <br />
  <img src="https://github.com/aayush6621/Snake-Ladder-Game/assets/116342742/ac957936-2a86-45f8-9235-74c91cb9a95a" alt="home-page" title="home-page" />
  <br />
  <br />

## Game-Board
  ### Single-Player:
  <br />
  <br />
  <img src="https://github.com/aayush7908/Snake-Ladder-Game/assets/116342742/5ae9be5e-7fbe-4af3-9364-4faa7e84f902" alt="single-player" title="single-player" />
  <br />
  <br />

  ### Two-Player:
  <br />
  <br />
  <img src="https://github.com/aayush7908/Snake-Ladder-Game/assets/116342742/8aa4f73d-df0f-46ef-abe9-13b3da321107" alt="two-player" title="two-player" />
  <br />
  <br />

## Installation
To clone the project, open the git bash terminal in a desired directory and execute the following command:
```
git clone https://github.com/aayush7908/Snake-Ladder-Game.git
```

After this, a new directory with the name `Snake-Ladder-Game` will be created within the current working directory. Open this directory in terminal and execute the below given command:
```
javac -d "./bin" src/main/java/*.java
```

By doing this, `.class` files will be created inside a newly created `bin` directory. Now, move to the `bin` directory using the command:
```
cd bin
```

Then start the application using:
```
java Main
```
