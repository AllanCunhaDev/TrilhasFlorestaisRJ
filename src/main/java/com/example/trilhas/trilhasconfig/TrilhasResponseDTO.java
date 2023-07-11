package com.example.trilhas.trilhasconfig;

public record TrilhasResponseDTO(Long id, String title, String description, String image, Integer price) {
    
    public TrilhasResponseDTO(TrilhasConfig trilhas){
        this (trilhas.getId(), trilhas.getTitle(), trilhas.getDescription(), trilhas.getImage(), trilhas.getPrice());
    }
}
