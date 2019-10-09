package ru.maveri.potions.controller.admin.rest;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import ru.maveri.potions.model.Potion;
import ru.maveri.potions.service.AdminPotionService;


@RestController
@RequestMapping("admin/potion")
@CrossOrigin(origins = "http://localhost:8081")
public class AdminPotionController {


    private AdminPotionService potionService;

    @Autowired
    public AdminPotionController(AdminPotionService potionService) {
        this.potionService = potionService;
    }


    @GetMapping
    public Iterable<Potion> getAllPotion(){
        return potionService.getAll();
    }


    @PostMapping
    public Potion addPotion(@RequestBody Potion potion){
        return potionService.addNewPotion(potion);

    }

    @PostMapping("{id}/image")
    public void addImage(@PathVariable long id, MultipartHttpServletRequest request) {

        potionService.addImages(id,request);

    }
}
