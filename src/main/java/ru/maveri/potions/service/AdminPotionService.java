package ru.maveri.potions.service;

import javassist.NotFoundException;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import ru.maveri.potions.model.ImageUrl;
import ru.maveri.potions.model.Potion;
import ru.maveri.potions.repo.ImageRepo;
import ru.maveri.potions.repo.PotionRepo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@Slf4j
public class AdminPotionService {

    @Autowired
    private PotionRepo potionRepo;


    @Value("${file.path}")
    private String staticImagePath;

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

    private void addNewImageInPotion(Potion potion, MultipartHttpServletRequest request) {

        val imageList = request.getFiles("file");
        val pathDerictory = Path.of(staticImagePath);
        for (MultipartFile img : imageList) {
            String fileName;
            Path imagePath = null;
            do {
                fileName = potion.getName() + "_" + ((int) (Math.random() * 100)) + img.getOriginalFilename();
                imagePath = pathDerictory.resolve(Paths.get(fileName));
            } while (new File(imagePath.toUri()).isFile());
            try {
                Files.copy(img.getInputStream(), imagePath);
            } catch (IOException e) {
                log.error(e.getMessage());
            }
            potion.getImages().add(new ImageUrl(fileName));
        }
    }
}
