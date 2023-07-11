package com.example.trilhas.trilhasconfig;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Table(name = "trilha")
@Entity(name = "trilha")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class TrilhasConfig {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    private Integer price;
    
    private String description;

    private String image;

    public TrilhasConfig(TrilhasRequestDTO data){
        this.image = data.image();
        this.title = data.title();
        this.description = data.description();
        this.price = data.price();

    }

}
