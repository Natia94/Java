package edu.cuny.brooklyn.cisc3120;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class Gui {
    private static int maxInteger = 16;
    private static int limit = 4);
    private static Random rand = new Random();
    private static int target = rand.nextInt(maxInteger)+1;
    private static int guess = 0, attempts = 0;
    private static String prevGuessesStr = "";
    public static int[] prevGuesses = new int [limit];
    
    private static JLabel label2 = new JLabel("Previous Guesses (" + attempts + " of " + limit + "): " + prevGuessesStr);
    private static JLabel guessResult = new JLabel(" ");
    
    static class ButtonListener implements ActionListener {
        private int val;
        public void actionPerformed(ActionEvent e) {
            if (attempts < limit && guess != target) { //Game Continues if attempts != Limit
                guess=this.val;
                prevGuesses[attempts]=guess;
                
                if (attempts == 0)
                {prevGuessesStr = Integer.toString(guess);}
                else{prevGuessesStr = prevGuessesStr + ", " + Integer.toString(guess);}
                attempts++;
                
                label2.setText("Previous Guesses (" + attempts + " of " + limit + "): " + prevGuessesStr);
                
                if(guess==target) {guessResult.setText("You Win :)");}
                else if (attempts == limit) {guessResult.setText("You Lose :(");}
                else {if(guess>target)
                {guessResult.setText("Too High! ops!try again! ");}
                else{guessResult.setText("Too Low! ops! try again! ");}
                }
            }
        }
        public ButtonListener (int val){
            this.val = val;
        }
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Guessing Game ^_^");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        
        JLabel label = new JLabel("Guess a number between 1 and " + Integer.toString(maxInteger));
        label.setFont(new Font(Font.TIMES, Font.ITALIC, 40));
        topPanel.add(label);
        topPanel.add(label2);
        guessResult.setFont(new Font(Font.TIMES, Font.BOLD, 40));
        topPanel.add(guessResult);
        JPanel buttonPanel = new JPanel(new GridLayout(5, 5));
        Button b;
        for (int i=1; i<=16; i++){
            b = new Button(Integer.toString(i));
            b.addActionListener(new ButtonListener(i));
            buttonPanel.add(b);
            
            
            topPanel.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
            frame.add(topPanel, BorderLayout.NORTH);
            buttonPanel.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
            frame.add(buttonPanel, BorderLayout.SOUTH);
            
            frame.setLocation(800, 600);
            frame.pack();
            frame.setVisible(true);
        }
    }
