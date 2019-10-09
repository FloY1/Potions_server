package ru.maveri.potions.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table
public class Potion {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


//    @OneToMany(mappedBy = "potion")
//    private Set<UserPotion> potionImages;


    private String name;


    private String description;

    //Параметры не именованы переименовать!!!!!
    private double p1;

    private double p2;

    private double p3;

    private double p4;

    @JsonIgnore
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name = "potion_id")
    private List<ImageUrl> images;

    @JsonUnwrapped
    private long getImageUrl(){
        if(!images.isEmpty()){
            return images.get(0).getId();
        }
        return 1;
    }

}
