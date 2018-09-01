package com.example.jokesjavalib;

import java.util.ArrayList;
import java.util.Random;

public class JokesProvider {

    private Random random = new Random();
    private ArrayList<String> jokesList = new ArrayList<String>();
    private int size = 0;

    /**
     * constructor
     */
    public JokesProvider() {
        setJokesList();
        size = jokesList.size();
    }

    /**
     * function called to get a random joke from the jokes list
     * @return
     */
    public String getRandomJoke() {
        int index = random.nextInt();
        return jokesList.get(index);
    }

    /**
     * function to set the jokes list
     */
    private void setJokesList() {
        jokesList.add("Question: Why do we tell actors to break a leg? Answer: Because every play has a cast.");
        jokesList.add("Helvetica and Times New Roman walk into a bar. Get out of here! shouts the bartender. We do not serve your type.");
        jokesList.add("Question: Did you hear about the actor who fell through the floorboards? Answer: He was just going through a stage.");
        jokesList.add("Question: Did you hear about the claustrophobic astronaut? Answer: He just needed a little space.");
        jokesList.add("Question: Why do not scientists trust atoms? Answer: Because they make up everything.");
        jokesList.add("Question: Where are average things manufactured? Answer: The satisfactory.");
        jokesList.add("Question: What sits at the bottom of the sea and twitches? Answer: A nervous wreck.");
        jokesList.add("Question: What does a nosy pepper do? Answer: Gets jalapeno business!");
        jokesList.add("A man tells his doctor, Doc, help me. I am addicted to Twitter! The doctor replies, Sorry, I do not follow you.");
    }
}
