package com.example.api.controllers;

import com.example.api.dto.ReviewDto;
import com.example.api.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class ReviewController {
    private ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/pokemon/{pokemonId}/review")
    public ResponseEntity<ReviewDto> createReview(@PathVariable(value = "pokemonId") int pokemonId,
                                                  @RequestBody ReviewDto reviewDto){
        return new ResponseEntity<>(reviewService.createReview(pokemonId, reviewDto), HttpStatus.CREATED);
    }

    @GetMapping("/pokemon/{pokemonId}/reviews")
    public List<ReviewDto> getReviewsByPokemonId(@PathVariable(value = "pokemonId") int pokemonId){
        return reviewService.getReviewsByPokemonId(pokemonId);
    }

    @GetMapping("/pokemon/{pokemonId}/reviews/{reviewId}")
    public ResponseEntity<ReviewDto> getReviewById(@PathVariable(value = "pokemonId") int pokemonId,
                                                   @PathVariable(value = "reviewId") int reviewId){
        ReviewDto reviewDto = reviewService.getReviewById(pokemonId, reviewId);

        return  new ResponseEntity<>(reviewDto, HttpStatus.OK);
    }

    @PutMapping("/pokemon/{pokemonId}/reviews/{reviewId}")
    public ResponseEntity<ReviewDto> updateReviewById(@PathVariable(value = "pokemonId") int pokemonId,
                                                      @PathVariable(value = "reviewId") int reviewId,
                                                      @RequestBody ReviewDto reviewDto){
        ReviewDto updatedReview = reviewService.updateReview(pokemonId, reviewId, reviewDto);

        return new ResponseEntity<>(updatedReview, HttpStatus.OK);
    }

    @DeleteMapping("/pokemon/{pokemonId}/reviews/{reviewId}")
    public ResponseEntity<String> deleteReviewById(@PathVariable(value = "pokemonId") int pokemonId,
                                                   @PathVariable(value = "reviewId") int reviewId){
        reviewService.deleteReview(pokemonId, reviewId);

        return ResponseEntity.ok("Review with ID " + reviewId + " deleted successfully.");
    }

}
