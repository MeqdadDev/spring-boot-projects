package com.example.api.services;

import com.example.api.dto.GetAllPokemonResponse;
import com.example.api.dto.PokemonDto;

import java.util.List;

public interface PokemonService {
    GetAllPokemonResponse getAllPokemons(int pageNo, int pageSize);
    PokemonDto createPokemon(PokemonDto pokemonDto);

    PokemonDto getPokemonById(int pokemonId);

    PokemonDto updatePokemon(PokemonDto pokemonDto, int pokemonId);

    void deletePokemon(int pokemonId);
}
