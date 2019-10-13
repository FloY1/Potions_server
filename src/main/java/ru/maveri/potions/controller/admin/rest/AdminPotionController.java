package ru.maveri.potions.controller.admin.rest;

import com.fasterxml.jackson.annotation.JsonView;
import javassist.NotFoundException;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import ru.maveri.potions.model.Potion;
import ru.maveri.potions.model.jsonViev.PotionView;
import ru.maveri.potions.service.AdminPotionService;


@RestController
@RequestMapping("admin/potion")
@CrossOrigin(origins = "http://localhost:8081")
public class AdminPotionController  {


    private AdminPotionService potionService;

    @Autowired
    public AdminPotionController (@NonNull AdminPotionService potionService) {
        this.potionService = potionService;
    }


    @GetMapping
    public Iterable<Potion> getAllPotion(){
        return potionService.getAll();
    }


    @PostMapping
    @JsonView(PotionView.PropId.class)
    public Potion addPotion(@RequestBody  @NonNull Potion potion){
        return potionService.addNewPotion(potion);

    }

    @PostMapping("{id}/image")
    public Potion addImage(@PathVariable long id, @NonNull  MultipartHttpServletRequest request) {
        if(id <0) throw new NumberFormatException("id < 0");


        return potionService.addImages(id,request);

    }
}
