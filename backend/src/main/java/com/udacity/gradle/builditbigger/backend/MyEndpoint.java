package com.udacity.gradle.builditbigger.backend;

import com.example.jokesjavalib.JokesProvider;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

/** An endpoint class we are exposing */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)
public class MyEndpoint {
    JokesProvider jokesProvider = new JokesProvider();
    /** A simple endpoint method that takes a name and says Hi back */
    /*
    @ApiMethod(name = "sayHi")
    public MyBean sayHi(@Named("name") String name) {
        MyBean response = new MyBean();
        response.setData("Hi, " + name);

        return response;
    }
       */

    /** A simple endpoint method that gets a joke */
    @ApiMethod(name = "getRandomJoke")
    public MyBean getRandomJoke() {
        MyBean response = new MyBean();
        System.out.println("Joke Random is: " + jokesProvider.getRandomJoke());
        response.setData(jokesProvider.getRandomJoke());
        return response;
    }
}
