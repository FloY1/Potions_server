package ru.maveri.potions.service.util;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import ru.maveri.potions.model.ImageUrl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
@Component
public class FileDirectory implements ImageSave {


    @Value("${file.path}")
    private String staticImagePath;



    @Override
    public ImageUrl save(MultipartFile image,String potionName) {

        String fileName;
        Path imagePath = null;
        do {
            fileName = generateFileName(potionName,image.getOriginalFilename());
            imagePath = Path.of(staticImagePath).resolve(Paths.get(fileName));

        } while (new File(imagePath.toUri()).isFile());

        try {
            Files.copy(image.getInputStream(), imagePath);
        } catch (IOException e) {
            log.error("image input stream:  " +e.getMessage());
            return null;
        }

        return new ImageUrl(fileName);
    }


    private String generateFileName(String potionName,String fileNmae){
        return  potionName + "_" + ((int) (Math.random() * 100)) + fileNmae;
    }
}
