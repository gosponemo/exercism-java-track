## [Yacht](https://exercism.io/tracks/java/exercises/yacht "link to exercism")
Score a single throw of dice in the game Yacht.  
In the game, five dice are rolled and the result can be entered in any of twelve categories.  
The score of a throw of the dice depends on category chosen.


№   | Category       |	Score               |	Description                            |	Example
----|-------------- | ---------------------- | ---------------------------------------- | ---------------
 1  |Ones	       | 1 × number of ones	    | Any combination	                       |1 1 1 4 5 scores 3
 2  |Twos	       | 2 × number of twos	    | Any combination	                       |2 2 3 4 5 scores 4
 3  |Threes	       | 3 × number of threes	| Any combination	                       |3 3 3 3 3 scores 15
 4  |Fours	       | 4 × number of fours	| Any combination	                       |1 2 3 3 5 scores 0
 5  |Fives	       | 5 × number of fives	| Any combination	                       |5 1 5 2 5 scores 15
 6  |Sixes	       | 6 × number of sixes	| Any combination	                       |2 3 4 5 6 scores 6
 7  |Full House     | Total of the dice	    | Three of one number and two of another   |3 3 3 5 5 scores 19
 8  |Four of a Kind | Total of the four dice | At least four dice showing the same face |4 4 4 4 6 scores 16
 9  |Little Straight| 30 points	            | 1-2-3-4-5	                               |1 2 3 4 5 scores 30
10  |Big Straight   | 30 points          	| 2-3-4-5-6                                |2 3 4 5 6 scores 30
11  |Choice         | Sum of the dice	    | Any combination	                       |2 3 3 4 6 scores 18
12  |Yacht	       | 50 points	            | All five dice showing the same face	   |4 4 4 4 4 scores 50
***
### Task
Given a list of values for five dice and a category, your solution should return the score of the dice for that category.
If the dice do not satisfy the requirements of the category your solution should return 0. 
You can assume that five values will always be presented, and the value of each will be between one and six inclusively. 
You should not assume that the dice are ordered.
***
