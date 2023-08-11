package com.example.api.controllers;

import com.example.api.dto.PokemonDto;
import com.example.api.models.Pokemon;
import com.example.api.services.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PokemonController {

    private final PokemonService pokemonService;

    @Autowired
    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/pokemon")
    public ResponseEntity<List<PokemonDto>> getAllPokemons(){
        return new ResponseEntity<>(pokemonService.getAllPokemons(), HttpStatus.OK);
    }
//    OR....
    /*@GetMapping("pokemon")
    public ArrayList<Pokemon> getPokemonById(){
        ArrayList<Pokemon> pokemons = new ArrayList<>();
        pokemons.add(new Pokemon(1, "Picatchu", "Electric"));
        return pokemons;
    }*/

    @GetMapping("/pokemon/{pokemonId}")
    public ResponseEntity<PokemonDto> getPokemon(@PathVariable int pokemonId){
        return ResponseEntity.ok(pokemonService.getPokemonById(pokemonId));
    }

    @PostMapping("/pokemon")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PokemonDto> createPokemon(@RequestBody PokemonDto pokemonDto){
        return new ResponseEntity<>(pokemonService.createPokemon(pokemonDto), HttpStatus.CREATED);
//        OR...
        /*PokemonDto pokemonDto = new PokemonDto();
        pokemonDto.setName(pokemon.getName());
        pokemonDto.setType(pokemon.getType());
        pokemonService.createPokemon(pokemonDto);
        return  ResponseEntity.ok(pokemon);*/
    }

    @PutMapping("/pokemon/{pokemonId}")
    public ResponseEntity<PokemonDto> updatePokemon(@PathVariable("pokemonId") int pokemonId, @RequestBody PokemonDto pokemonDto){
        PokemonDto response = pokemonService.updatePokemon(pokemonDto, pokemonId);
        return new  ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/pokemon/{pokemonId}")
    public ResponseEntity<String> deletePokemon(@PathVariable("pokemonId") int pokemonId){
         pokemonService.deletePokemon(pokemonId);
        return ResponseEntity.ok("Pokemon with ID " + pokemonId + " deleted.");
    }
}
