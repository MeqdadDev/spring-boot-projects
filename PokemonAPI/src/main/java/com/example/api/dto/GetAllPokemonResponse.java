package com.example.api.dto;

import lombok.Data;

import java.util.List;

@Data
public class GetAllPokemonResponse {
    private List<PokemonDto> content;
    private int pageNo;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean last;
}
