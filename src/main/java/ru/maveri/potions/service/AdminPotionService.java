package ru.maveri.potions.service;

import javassist.NotFoundException;
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
public class AdminPotionService {

    @Autowired
    private PotionRepo potionRepo;


    @Value( "${file.path}" )
    private String staticImagePath;

    public Potion addNewPotion(Potion potion) {
        return potionRepo.save(potion);
    }

    public Potion addImages(long id, MultipartHttpServletRequest request)  {

        Potion potion = potionRepo.findById(id).get();


        request.getRequestHeaders();
        List<MultipartFile> imageList=request.getFiles("file");



        try {


            Path pathDerictory = Path.of(staticImagePath);
            for (MultipartFile img:imageList ) {
                String fileName;
                Path imagePath = null;
                do{
                    fileName = potion.getName()+"_"+((int)(Math.random()*100))+img.getOriginalFilename() ;
                    imagePath = pathDerictory.resolve(Paths.get(fileName));
                }while (new File(imagePath.toUri()).isFile());
                Files.copy(img.getInputStream(),imagePath);

                potion.getImages().add( new ImageUrl(fileName));

            }

            potionRepo.save(potion);
            return potion;
        }catch (IOException e){
            e.printStackTrace();
        }

        return null;
    }

    public Iterable<Potion> getAll() {
        return potionRepo.findAll();
    }
}
