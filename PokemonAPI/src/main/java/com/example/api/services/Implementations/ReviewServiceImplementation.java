package com.example.api.services.Implementations;

import com.example.api.dto.ReviewDto;
import com.example.api.exceptions.PokemonNotFoundException;
import com.example.api.exceptions.ReviewNotFoundException;
import com.example.api.models.Pokemon;
import com.example.api.models.Review;
import com.example.api.repository.PokemonRepository;
import com.example.api.repository.ReviewRepository;
import com.example.api.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImplementation implements ReviewService {

    private ReviewRepository reviewRepository;
    private PokemonRepository pokemonRepository;

    @Autowired
    public ReviewServiceImplementation(ReviewRepository reviewRepository, PokemonRepository pokemonRepository){
        this.reviewRepository = reviewRepository;
        this.pokemonRepository = pokemonRepository;
    }
    @Override
    public ReviewDto createReview(int pokemonId, ReviewDto reviewDto) {
        Review review = dtoToReviewMapper(reviewDto);

        Pokemon pokemon = pokemonRepository.findById(pokemonId)
                .orElseThrow(() -> new PokemonNotFoundException("Pokemon with associated review not found"));
        review.setPokemon(pokemon);

        Review newReview = reviewRepository.save(review);

        return reviewToDtoMapper(newReview);
    }

    @Override
    public List<ReviewDto> getReviewsByPokemonId(int id) {
        List<Review> reviews = reviewRepository.findByPokemonId(id);

        return  reviews.stream().map(review -> reviewToDtoMapper(review)).collect(Collectors.toList());
    }

    @Override
    public ReviewDto getReviewById(int reviewId, int pokemonId) {
        Pokemon pokemon = pokemonRepository.findById(pokemonId)
                .orElseThrow(() -> new PokemonNotFoundException("Pokemon with associated review not found"));

        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new ReviewNotFoundException("Review not found"));

        if(review.getPokemon().getId() != pokemon.getId()){
            throw new ReviewNotFoundException("This review doesn't belong to a pokemon");
        }

        return reviewToDtoMapper(review);
    }

    private ReviewDto reviewToDtoMapper(Review review){
        ReviewDto reviewDto = new ReviewDto();
        reviewDto.setId(review.getId());
        reviewDto.setTitle(review.getTitle());
        reviewDto.setContent(review.getContent());
        reviewDto.setStars(review.getStars());
        return reviewDto;
    }

    private Review dtoToReviewMapper(ReviewDto reviewDto) {
        Review review = new Review();
        review.setId(reviewDto.getId());
        review.setTitle(reviewDto.getTitle());
        review.setContent(reviewDto.getContent());
        review.setStars(reviewDto.getStars());
        return review;
    }

}
