Score Board
--------------------------------------

•	Score Board application shows matches,score and summary of the matches. 

•	Java Module contains FootballScoreBoard class which works as a Sports score board which have options to Record live football matches and summary of all matches completed.

•	Java swing library is used to create the UI for this application


The Score Board supports the following operations:

1. Start a new game, assuming initial score 0 – 0 and adding it the scoreboard. This
   will capture following parameters:
    a. Home team
    b. Away team

2. Finish game currently in progress. This removes a match from the scoreboard.

3. Update score. This will receive a pair of absolute scores: home team score and
   away team score.

4. Get a summary of games in progress ordered by their total score. The games with the same total score will be returned ordered by the most recently started match in the scoreboard.

How to run the module
--------------------------------------

Run the main class in ScoreBoardApplication.java , It will load the UI.

User can enter the details through the UI.

1. To start the game :- Click the 'Start Game' button
2. To update the score of the game :- Click the 'Update Game' button
3. To finish the game :- Click the 'Finish Game' button
4. To get the summary of game :- Click the 'Match Summary' button
5. To quit the game :- Click the 'Quit Game' button

Implementation Details
--------------------------------------

Implementation consist of 4 methods for starting a game, update the game,finish the game and get the summary of the game with a UI.


Method Details
--------------------------------------

	startGame
	---------
	1. Method accepts home team and away team names.
	2. Set the values of team name and team score(initially 0-0) to the DTO class.
	3. Show the live match score in score board.
	
	updateGame
	----------
	1. Method accepts home team and away team updated scores.
	2. Set the values of team updated score to the DTO class.
	3. Show the live match score in score board.
	
	finishGame
	----------
	1. Game will finish
	2. Add all the finished match details to a list.
	
	getMatchSummary
	---------------
	1. Get the match list which holds the details of matches which is completed.
	2. Reverse the list, since we need last completed match should come in the list first.
	3. Sort the list based on the total goal scored in the match
	4. Show the match summary with the sorted list.
	
	checkTeamScore
	---------------
	1. To check the score value is valid or not.
	  
	For Example:
	Input:-
		 a. Mexico 0 - Canada 5
	    b. Spain 10 - Brazil 2
	    c. Germany 2 - France 2
	    d. Uruguay 6 - Italy 6
	    e. Argentina 3 - Australia 1
    
    Output:-    
		1. Uruguay 6 - Italy 6
		2. Spain 10 - Brazil 2
		3. Mexico 0 - Canada 5
		4. Argentina 3 - Australia 1
		5. Germany 2 - France 2
   
  

