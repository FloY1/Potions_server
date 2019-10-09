package ru.maveri.potions.service;

import org.springframework.beans.factory.annotation.Autowired;
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


    public Potion addNewPotion(Potion potion) {
        return potionRepo.save(potion);
    }

    public void addImages(long id, MultipartHttpServletRequest request){




        request.getRequestHeaders();
        List<MultipartFile> imageList=request.getFiles("file");

        Potion potion = potionRepo.findById(id).get();

        try {


            Path pathDerictory = Path.of("/home/floy/imgs/");
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

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public Iterable<Potion> getAll() {
        return potionRepo.findAll();
    }
}
