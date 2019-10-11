package ru.maveri.potions.model;


import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import ru.maveri.potions.model.jsonViev.PotionView;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table
public class Potion {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(PotionView.Id.class)
    private long id;


//    @OneToMany(mappedBy = "potion")
//    private Set<UserPotion> potionImages;

    @JsonView(PotionView.Properties.class)
    private String name;

    @JsonView(PotionView.Properties.class)
    private String description;

    //Параметры не именованы переименовать!!!!!
    @JsonView(PotionView.Properties.class)
    private double p1;

    @JsonView(PotionView.Properties.class)
    private double p2;

    @JsonView(PotionView.Properties.class)
    private double p3;

    @JsonView(PotionView.Properties.class)
    private double p4;


    @JsonIgnore
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name = "potion_id")
    private List<ImageUrl> images;

    @JsonGetter("firstImg")
    @JsonView(PotionView.ImageUrl.class)
    private long getFirsImg(){
        if(!images.isEmpty()){
            return images.get(0).getId();
        }
        return 1;
    }





}
