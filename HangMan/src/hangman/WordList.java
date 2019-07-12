
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;
import java.util.*;
/**
 *
 * @author nath
 */
public class WordList extends HangMan {
    
    private  static final String [] WORD_LIST = {"java", "java", "java"};
    /**
     * Picks a random word from WORD_LIST.
     * @return 
     */
    private static int Random(){
        
       Random rand = new Random();
       int indexGen;
       indexGen = rand.nextInt(WORD_LIST.length);
       return indexGen;
    }

    /**
     * Returns the random word picked from WORD_LIST to the receiver.
     * @return
     */
    public static String getPickedWord(){
        
        int index = Random();
       
        return WORD_LIST[index];
    }
}
