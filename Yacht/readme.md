## [Yacht](https://exercism.io/tracks/java/exercises/yacht "link to exercism")
Score a single throw of dice in the game Yacht.  
In the game, five dice are rolled and the result can be entered in any of twelve categories.  
The score of a throw of the dice depends on category chosen.


№   | Category       |	Score                  |	Description                              |	Example
----|--------------  | ---------------------- | ---------------------------------------- | ---------------
 1  |Ones	           | 1 × number of ones	    | Any combination	                         |1 1 1 4 5 scores 3
 2  |Twos	           | 2 × number of twos	    | Any combination	                         |2 2 3 4 5 scores 4
 3  |Threes	         | 3 × number of threes	  | Any combination	                         |3 3 3 3 3 scores 15
 4  |Fours	          | 4 × number of fours	   | Any combination	                         |1 2 3 3 5 scores 0
 5  |Fives	          | 5 × number of fives	   | Any combination	                         |5 1 5 2 5 scores 15
 6  |Sixes	          | 6 × number of sixes	   | Any combination	                         |2 3 4 5 6 scores 6
 7  |Full House      | Total of the dice	     | Three of one number and two of another   |3 3 3 5 5 scores 19
 8  |Four of a Kind  | Total of the four dice | At least four dice showing the same face |4 4 4 4 6 scores 16
 9  |Little Straight | 30 points	             | 1-2-3-4-5	                               |1 2 3 4 5 scores 30
10  |Big Straight    | 30 points          	   | 2-3-4-5-6                                |2 3 4 5 6 scores 30
11  |Choice          | Sum of the dice	       | Any combination	                         |2 3 3 4 6 scores 18
12  |Yacht	          | 50 points	             | All five dice showing the same face	     |4 4 4 4 4 scores 50
***
### Task
Given a list of values for five dice and a category, your solution should return the score of the dice for that category.
If the dice do not satisfy the requirements of the category your solution should return 0. 
You can assume that five values will always be presented, and the value of each will be between one and six inclusively. 
You should not assume that the dice are ordered.
***
<details>
<summary>other (interested for me) solution by kssaurab</summary>

```java
 
import java.util.*;
import java.util.stream.*;

class Yacht {

    private int s = 0;

    Yacht(int[] dice, YachtCategory yachtCategory) {

        HashMap<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        for(int elem: dice) countMap.put(elem, countMap.getOrDefault(elem, 0) + 1);
        List<Integer> keys = countMap.keySet().stream().collect(Collectors.toList());
        switch(yachtCategory){
            case ONES:
                s = countMap.getOrDefault(1, 0);
                break;
            case TWOS:
                s = countMap.getOrDefault(2, 0) * 2;
                break;
            case THREES:
                s = countMap.getOrDefault(3, 0) * 3;
                break;
            case FOURS:
                s = countMap.getOrDefault(4, 0) * 4;
                break;
            case FIVES:
                s = countMap.getOrDefault(5, 0) * 5;
                break;
            case SIXES:
                s = countMap.getOrDefault(6, 0) * 6;
                break;
            case FULL_HOUSE:
                if(countMap.size() == 2 &&
                    countMap.values().stream().filter(x-> x!=2 && x!=3).collect(Collectors.toList()).size()==0)
                  for(int elem: dice) s = s + elem;
                break;
            case FOUR_OF_A_KIND:
                if(countMap.values().stream().filter(x-> x>=4).collect(Collectors.toList()).size()==1){
                    if(countMap.get(keys.get(0)) >= 4) s = 4 * keys.get(0);
                    else s = 4 * keys.get(1);
                }
                break;
            case LITTLE_STRAIGHT:
                List<Integer> keys2 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
                keys2.removeAll(keys);
                if(keys2.size() == 0) s = 30;
                break;
            case BIG_STRAIGHT:
                List<Integer> keys3 = new ArrayList<Integer>(Arrays.asList(2, 3, 4, 5, 6));
                keys3.removeAll(keys);
                if(keys3.size() == 0) s = 30;
                break;
            case CHOICE:
                for(int elem: dice) s+= elem;
                break;
            case YACHT:
                if(keys.size() == 1) s = 50;
                break;
        }
    }

    int score() {
        return s;
    }
}
</details>

