package ru.maveri.potions.service;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import ru.maveri.potions.model.ImageUrl;
import ru.maveri.potions.model.Potion;
import ru.maveri.potions.repo.PotionRepo;
import ru.maveri.potions.service.util.ImageSave;

@Service
public class AdminPotionService {

    private PotionRepo potionRepo;
   private ImageSave imagesSave;




    public AdminPotionService(PotionRepo potionRepo, ImageSave imagesSave) {
        this.potionRepo = potionRepo;
        this.imagesSave = imagesSave;

    }

    public Potion addNewPotion(Potion potion) {
        return potionRepo.save(potion);
    }

    public Potion addImages(long id, MultipartHttpServletRequest request) {

        Potion potion = potionRepo.findById(id).get();
        addNewImageInPotion(potion, request);
        potionRepo.save(potion);
        return potion;

    }

    public Iterable<Potion> getAll() {
        return potionRepo.findAll();
    }

    public void addNewImageInPotion(Potion potion, MultipartHttpServletRequest request) {

        val imageList = request.getFiles("file");

        for (MultipartFile img : imageList) {
            ImageUrl imageUrl = imagesSave.save(img,potion.getName());
            potion.getImages().add(imageUrl);
        }

    }


}
