package com.example.api.services;

import com.example.api.dto.PokemonDto;
import com.example.api.exceptions.PokemonNotFoundException;
import com.example.api.models.Pokemon;
import com.example.api.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PokemonServiceImplementation implements PokemonService{

    private final PokemonRepository pokemonRepository;

    @Autowired
    public PokemonServiceImplementation(PokemonRepository pokemonRepository){
        this.pokemonRepository = pokemonRepository;
    }

    @Override
    public List<PokemonDto> getAllPokemons() {
        List<Pokemon> pokemon = pokemonRepository.findAll();
//        return pokemon.stream().map(this::pokemonToDtoMapper).collect(Collectors.toList());
//        OR...
        return pokemon.stream().map(p -> pokemonToDtoMapper(p)).collect(Collectors.toList());
    }

    @Override
    public PokemonDto createPokemon(PokemonDto pokemonDto) {
        Pokemon pokemon = new Pokemon();
        pokemon.setName(pokemonDto.getName());
        pokemon.setType(pokemonDto.getType());

        Pokemon newPokemon = pokemonRepository.save(pokemon);

        PokemonDto pokemonResponse = new PokemonDto();

        pokemonResponse.setId(newPokemon.getId());
        pokemonResponse.setName(newPokemon.getName());
        pokemonResponse.setType(newPokemon.getType());

        return pokemonResponse;
    }

    @Override
    public PokemonDto getPokemonById(int pokemonId) {
        Pokemon pokemon = pokemonRepository.findById(pokemonId)
                .orElseThrow(() -> new PokemonNotFoundException("Pokemon is not found"));
        return pokemonToDtoMapper(pokemon);
    }

    @Override
    public PokemonDto updatePokemon(PokemonDto pokemonDto, int pokemonId) {
        Pokemon pokemon = pokemonRepository.findById(pokemonId)
                .orElseThrow(() -> new PokemonNotFoundException("Pokemon could not be updated"));
        pokemon.setName(pokemonDto.getName());
        pokemon.setType(pokemonDto.getType());

        Pokemon updatedPokemon = pokemonRepository.save(pokemon);
        return pokemonToDtoMapper(updatedPokemon);
    }

    @Override
    public void deletePokemon(int pokemonId) {
        Pokemon pokemon = pokemonRepository.findById(pokemonId)
                .orElseThrow(() -> new PokemonNotFoundException("Pokemon is not found"));
        pokemonRepository.delete(pokemon);
    }

    public PokemonDto pokemonToDtoMapper(Pokemon pokemon){
        PokemonDto pokemonDto = new PokemonDto();
        pokemonDto.setId(pokemon.getId());
        pokemonDto.setName(pokemon.getName());
        pokemonDto.setType(pokemon.getType());
        return pokemonDto;
    }

    public Pokemon dtoToPokemonMapper(PokemonDto pokemonDto){
        Pokemon pokemon = new Pokemon();
        pokemon.setName(pokemonDto.getName());
        pokemon.setType(pokemon.getType());
        return pokemon;
    }
}
