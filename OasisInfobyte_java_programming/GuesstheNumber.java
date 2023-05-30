

import java.util.Scanner;
import java.util.Random;
//RandomGame class
class RandomGame{
    int computerInput;
    int playerInput;
    int noOfAttempts=0;
    //RandomGame constructor to generate a random number between range 1 to 100
    RandomGame(){
     //creating object for Random class
     Random r=new Random();
     this.computerInput=r.nextInt(100)+1;
    }
    //method for taking player guesses 
    //the max limit of player guesses is 10
    public void takePlayerInput(){
        if(noOfAttempts<10){
            System.out.println("Guess the number: ");
            this.playerInput=GuesstheNumber.takeInput(100);
            noOfAttempts++;
        }
        else{
            System.out.println("Your Max attempts are Finished...Better Luck next time");
            System.exit(0);
         
        }
    }
    //method to check the player number matches with computer generated number  
    //and give score to player according to number of attempts/guesses
    public void isCorrectGuess(){
        if(computerInput==playerInput){
            System.out.println("Congrats,you guess the number "+playerInput+" in "+noOfAttempts+" attempts");
            switch(noOfAttempts){
                case 1:
                System.out.println("Your score is 100");
                break;
                case 2:
                System.out.println("Your score is 90");
                break;
                case 3:
                System.out.println("Your score is 80");
                break;
                case 4:
                System.out.println("Your score is 70");
                break;
                case 5:
                System.out.println("Your score is 60");
                break;
                case 6:
                System.out.println("Your score is 50");
                break;
                case 7:
                System.out.println("Your score is 40");
                break;
                case 8:
                System.out.println("Your score is 30");
                break;
                case 9:
                System.out.println("Your score is 20");
                break;
                case 10:
                System.out.println("Your score is 10");
                break;

            }
            
           System.out.println();
     
        }
        else if(noOfAttempts<10 && playerInput>computerInput){
            if(playerInput-computerInput>25){
                System.out.println("Very High");
            }
            else if(playerInput-computerInput>15){
                System.out.println("High");
            }
            else{
                System.out.println("Little High");
            }
        }
        else if(noOfAttempts<=10 && playerInput<computerInput){
            if(computerInput-playerInput>25){
                System.out.println("Very Low");
              
            }
            else if(computerInput-playerInput>15){
                System.out.println("Low");
            }
            else{
                System.out.println("Little low");
            }


        }
      
    }


}
//main class
public class GuesstheNumber{
    public static int takeInput(int limit){
        int playerInp=0;
        boolean flag=false;
        while(!flag){
            try{
                Scanner s=new Scanner(System.in);
                playerInp=s.nextInt();
                flag=true;
                if(flag && playerInp>limit || playerInp<1){
                    System.out.println("Please choose the number between 1 to "+limit);
                    flag=false;
                }

            }
            catch(Exception e){
                System.out.println("Enter only integer value");
                flag=false;

            }
        };
        return playerInp;

    }
    public static void main(String[] args){
       
    int roundNumber=0;
    while(true){
        roundNumber++;
        System.out.println("****************************");
        System.out.println("1.Start the new Game\n2.Exit");
        System.out.println("Enter your choice: ");
        int choice=takeInput(2);
        switch(choice){
           
            case 1:
            System.out.println("Round "+roundNumber);
            RandomGame g=new RandomGame();
            g.takePlayerInput();
            while(g.computerInput!=g.playerInput){
                g.isCorrectGuess();
                g.takePlayerInput();
                
            }
            if(g.computerInput==g.playerInput){
                g.isCorrectGuess();
            }
            break;
            case 2:System.exit(0);
            
            default:System.out.println("Invalid");
    
        }

    }
  

    }

}