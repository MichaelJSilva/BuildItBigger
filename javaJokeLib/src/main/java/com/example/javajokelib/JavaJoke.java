package com.example.javajokelib;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JavaJoke {

    ArrayList<String> jokes;

    public String tellJoke(){

        createJokes();

        Random randomNumber = new Random();

        int jokeNumber = randomNumber.nextInt(jokes.size());

        String joke = jokes.get(jokeNumber);


        return joke;


    };

    private void createJokes(){

        jokes = new ArrayList<>();

        jokes.add("People say nothing is impossible, but I do nothing every day.");
        jokes.add("Light travels faster than sound. This is why some people appear bright until you hear them speak");
        jokes.add("At every party there are two kinds of people – those who want to go home and those who don’t. The trouble is, they are usually married to each other.");
        jokes.add("Q: Why did Johnny throw the clock out of the window? \n" +
                  "A: Because he wanted to see time fly! ");
        jokes.add("Q: What happens when you play Beethoven backwards? \n" +
                   "A: He decomposes. ");
        jokes.add("Q: Why did the pianist keep banging his head against the keys? \n" +
                  "A: He was playing by ear ");
        jokes.add("Q: Why are pirates great singers? \n" +
                  "A: They can hit the high C's! ");
        jokes.add("Q: How do you make a band stand? \n" +
                  "A: Take their chairs away!");




    }


}
