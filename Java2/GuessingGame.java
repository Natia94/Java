import java.lang.Math;

import java.util.Random;

import java.util.Scanner;

import java.util.InputMismatchException;

import java.util.TreeSet;

import java.util.Set;



public class GuessGameHomework {

public static void main(String[] args) {

/*

        if (args.length != 2) {

            System.out.println("Usage: java GuessGame MAX_INT MAX_GUESS");

            return;

        }

*/



// This is how you convert a string to an integer:

int maxInteger = 16; // Integer.parseInt(args[0]);



// This is the number of guesses the user gets.

int limit = 4; // Integer.parseInt(args[1]);



Random rand = new Random();



// This generates a random integer.

int target = rand.nextInt(maxInteger);





Scanner input = new Scanner(System.in);



try {

//This is how you print to stdout.

System.out.printf("Guess a number between 1 and %d.\n", maxInteger);



Set<Integer> guesses = new TreeSet<>();





// Loop while the number of attempts is less than the number of allowed guesses

int attempts = 1;

while (attempts <= limit) {

System.out.printf("Attempt %d of %d: ", attempts, limit);



// This is how you get an integer from stdin.

// (This is like `int guess << cin` in C++.)

try {

int guess = input.nextInt();

System.out.printf("You guessed %d\n", guess);


                    if( guess > maxInteger || guess<1)

                    {

                    System.out.println("This number is out of range!");

                    continue;

                    }

                    


if (guesses.contains(guess)) {

System.out.println("This a duplicate number, try one more time :) ");

continue;

}           



else if(guess>target){

System.out.printf("Too High! ");

guesses.add(guess);

}

else if(guess<target){

System.out.printf("Too low! ");

guesses.add(guess);

}

else if(guess==target){

System.out.printf("You Win! ");

guesses.add(guess);

return;

}



attempts+=1;





} catch(InputMismatchException k){



System.out.printf("Enter Only Numbers!  ");

input.nextLine();





}



System.out.println("You lose!  "); 

}



} finally {

input.close();

}

}

}
