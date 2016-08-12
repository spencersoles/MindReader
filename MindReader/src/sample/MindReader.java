package sample;

import java.util.HashMap;

/**
 * Created by Spencer on 11/23/2015.
 */
public class MindReader {
    private int size;
     HashMap<String, Character> fun;
    private ResponseBuffer list;

    /**
     * constructor that sets size of linked list
     * linked list holds last "size" amount of chosen flips
     * HashMap stores string of choices from linked list as keys using the next human chose as the value
     * @param size
     */
    public MindReader(int size){
        this.size = size;
        list = new ResponseBuffer(size);
        fun = new HashMap<String, Character>();
    }

    /**
     * makes best guess by checking map to see if it has any matches stored from the previous choices
     * if no match then randomizes guess between h and t
     * @return
     */
    public char MakeGuess(){
        String key = list.toString().toUpperCase();//last 4
        char guess;

        if(fun.containsKey(key)){
            guess= fun.get(key).charValue();//logical guess based off of match found
        }else{//cannot find a matching key in the map so randomizes guess
            if(Math.random()>.5){
                guess='t';
            }else{
                guess = 'h';
            }

        }
        return guess;
    }

    /**
     * updates the linked list along with the hashmap using insert and put
     * @param response
     */
    public void update(char response){

        fun.put(list.toString(), response);
        list.insert(response);

    }
}
