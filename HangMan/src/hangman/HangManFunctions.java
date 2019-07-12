/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

import java.util.*;

/**
 *
 * @author nath8
 */
public class HangManFunctions extends HangMan{
    /**
     * Returns the welcome string on program start up.
     * @return 
     */
    public static String newGame(){
        String welcome = "Welcome to A game of HangMan have fun! %n ";
                
        return welcome;
    }
    
    /**
     * Selecting to start a new  game of HangMan.
     * @return 
     */
    public static boolean StartGame(){
        boolean invalidInput = true;
        boolean gameStart = false;
        while(invalidInput == true){
        System.out.printf("Start a new Game, Y for yes N for no.%n");
        Scanner input = new Scanner(System.in);
        String startGame = input.next();
        String start = "Y";
        String end = "N";   
        if(end.equals(startGame.toUpperCase())){
            
            System.out.printf("GoodBye %n");
            gameStart = false;
            invalidInput = false;
        }
        else if(start.equals(startGame.toUpperCase())){
            
            System.out.printf("Game started! Word has been picked." + "%n" + 
                    "Guess the word by inputting one character at a time.%n");
            gameStart = true;
            invalidInput = false;
        }
        else{
            System.out.println("invalid input try again");
            
        }
        }
            return gameStart;
        
    }
    /**
     * Collects and returns character input.
     * @return 
     */
    public static char Guess(){
 
        char guessedInput = '0';
        boolean correctInput = false;
        while(correctInput == false){
            
        System.out.println("Enter a letter!");
        Scanner input = new Scanner(System.in);
        String guess = input.next();
        guessedInput = guess.charAt(0);
        
        if(guess.length() == 1 && Character.isLetter(guessedInput)){
               
                correctInput = true;
                
            }
        else{
               System.out.println("Invalid Input");
                correctInput = false;
               
            }
        }
               return guessedInput;
    }
    /**
     * Returns the picture of HangMan
     * @param attempts
     * @return 
     */
    public static String drawHangMan(int attempts){
        // hangManPic array
        // " _ __ __ __"    0
        // "|          |"   1 
        // "|""       xxx " 2/7
        // "|""      (- -)" 3/8
        // "|""       \-/"  4/9
        // "|""      -(@)-" 5/10
        // "|""       | |"  6/11
        
        String[] hangManPic = {"%n _ __ __ __","|         |","|","|","|","|",
            "|","        xxx ","       (- -)","        \\-/",
            "       -(@)-", "        | |"};
        String complete = hangManPic[0] + "%n" + hangManPic[1] + "%n";
        String rack = "";
        switch (attempts) {   
            case 1:
                for(int i = 0; i <= 6; i++){
                    
                   rack = rack + hangManPic[i] + "%n";
                   
                }  
                complete = rack;
                break;
            case 2:
                complete = complete + hangManPic[2] + hangManPic[7] + "%n";
                for(int i = 2; i <= hangManPic.length / 2; i++){
                    complete = complete + hangManPic[i] + "%n";
                }
                break;
            case 3:
                for (int i = 2; i <= 4; i++){
                    complete = complete + hangManPic[i] + hangManPic[i+5] + "%n";
                } 
                for(int i = 4; i <= hangManPic.length / 2; i++){
                    complete = complete + hangManPic[i] + "%n";
                }
                break;
            case 4:
                for (int i = 2; i <= 5; i++){
                    complete = complete + hangManPic[i] + hangManPic[i+5] + "%n";
                } 
                for(int i = 6; i <= hangManPic.length / 2; i++){
                    complete = complete + hangManPic[i] + "%n";
                }
                break;
            default:
                for(int i = 2; i <= hangManPic.length / 2; i++){
                    
                    complete = complete + hangManPic[i] + hangManPic[i+5] + "%n";
                    
                }    break; 
        }
        
        return(complete);
    }
            
}
