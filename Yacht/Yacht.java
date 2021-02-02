import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Yacht{
    private final int[] dice;
    private final YachtCategory category;
    private HashMap<Integer, Integer> hashMap = new HashMap<>();

    Yacht(int[] dice, YachtCategory category){
        this.dice = dice;
        this.category = category;
    }

    public static void main(String[] args){

    }

    private int oneToSixScore(int value){
        int score = 0;
        for(int i : dice){
            if (i == value) score = score + value;
        }
        return score;
    }

    private void hashMapOccurrencer(){
        for (int value : dice){
            hashMap.put(value, hashMap.getOrDefault(value, 0)+1);
        }
    }

    public int score(){
        int score = 0;

        switch (category){
            case ONES:
                score = oneToSixScore(1);
                break;
            case TWOS:
                score = oneToSixScore(2);
                break;
            case THREES:
                score = oneToSixScore(3);
                break;
            case FOURS:
                score = oneToSixScore(4);
                break;
            case FIVES:
                score = oneToSixScore(5);
                break;
            case SIXES:
                score = oneToSixScore(6);
                break;

            //Desc: Three of one number and two of another
            //Score: Total of the dice
            case FULL_HOUSE:
                hashMapOccurrencer();
                if (hashMap.size()==2){
                    if (hashMap.containsValue(3) && hashMap.containsValue(2)){
                        for (int value : dice) score+=value;
                    }
                }
                break;

            //Desc: At least four dice showing the same face
            //Score: Total of the four dice
            case FOUR_OF_A_KIND:
                hashMapOccurrencer();
                if (hashMap.size()<=2){
                    for (Integer key : hashMap.keySet()){
                        if (hashMap.get(key)>=4){
                            score = 4*key;
                        }
                    }
                }
                break;

            //1-2-3-4-5
            case LITTLE_STRAIGHT:
                hashMapOccurrencer();
                if (hashMap.size()==5){
                    Arrays.sort(dice);
                    if (dice[0]!=1) break;
                    score=6;
                    for (int i = 0; i<dice.length-1; i++){
                        if (dice[i]+1==dice[i+1]){
                            score=score+6;
                        }
                    }
                }
                if (score!=30) score=0;
                break;

            case BIG_STRAIGHT:
                hashMapOccurrencer();
                if (hashMap.size()==5){
                    Arrays.sort(dice);
                    if (dice[0]!=2) break;
                    score=6;
                    for (int i = 0; i<dice.length-1; i++){
                        if (dice[i]+1==dice[i+1]){
                            score=score+6;
                        }
                    }
                }
                if (score!=30) score=0;
                break;

            //Score: Sum of the dice
            case CHOICE:
                for (int value : dice){
                    score = score + value;
                }
                break;

            //Desc: All five dice showing the same face
            case YACHT:
                hashMapOccurrencer();
                if (hashMap.size()==1) score=50;
                break;
        }
    return score;
    }
}