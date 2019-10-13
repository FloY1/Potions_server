package ru.maveri.potions.service.util;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import ru.maveri.potions.model.ImageUrl;

public interface ImageSave {

    ImageUrl save(MultipartFile image,String potionName);
}
