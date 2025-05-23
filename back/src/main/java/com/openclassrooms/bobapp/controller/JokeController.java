package com.openclassrooms.bobapp.controller;

import java.util.Random;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openclassrooms.bobapp.service.JokeService;

@RestController
@RequestMapping("api/joke")
public class JokeController {

    private final JokeService jokeService;

    JokeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @GetMapping()
    public ResponseEntity<?> getRandomJoke() throws InterruptedException {
        Random generator = new Random();
        Thread.sleep((long) (generator.nextDouble() * 1000));
        return ResponseEntity.ok(this.jokeService.getRandomJoke());
    }
}
