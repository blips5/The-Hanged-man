/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;
/**
 * HangMan 1.0
 * @author nath Date 18/11/2017
 */
public class HangMan {

    /**
     * @param args the command line arguments
     */
    private static final int WELCOME_PIC = 0;
    private static int failedAttempts = 1;
    private static boolean gameOver;
    private static boolean gameState = true;
    private static boolean startGame = false;
    
    public static void main(String[] args) {
        // TODO code application logic here
         
        System.out.printf(HangManFunctions.newGame());
        
        System.out.printf(HangManFunctions.drawHangMan(WELCOME_PIC));
        
        while(gameState == true){   
        startGame = HangManFunctions.StartGame();
        gameOver = false;     
        failedAttempts = 1;
        if(startGame == false){
            gameState = false;
        }
        else{
            
            String wordPicked = WordList.getPickedWord();
            char[] guessWord = new char[wordPicked.length()];
            
            while(gameOver == false){
            char guess = HangManFunctions.Guess();
            boolean correctGuess = false;
            
            for(int i =0; i < wordPicked.length(); i++){
                if(guess == wordPicked.charAt(i)){
                    
                    guessWord[i] = guess;
                    correctGuess = true;
                }
                
                
            }
            if(correctGuess == true){
                    System.out.println("Your guess was correct");
                    System.out.printf(HangManFunctions.drawHangMan(failedAttempts));
                }
                else{
                    failedAttempts++;
                    System.out.printf(HangManFunctions.drawHangMan(failedAttempts));
                    System.out.println("Choose another letter. failed Attempts:= "
                            + (failedAttempts -1));
                    
                }
            
            
            System.out.println(guessWord);
            String testWord = String.valueOf(guessWord);
            if(testWord.equals(wordPicked)){
                
                System.out.println("***Congrats***");
                gameOver = true;
                
            }
            else if(failedAttempts > 4){
                System.out.println("Better luck next time. "
                        + "The word picked:= " + wordPicked);
                gameOver = true;
            }
            
            } 
            }  
        }    
    } 
}
