package ru.maveri.potions.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.mock.web.MockMultipartHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.maveri.potions.model.Potion;
import ru.maveri.potions.repo.PotionRepo;
import ru.maveri.potions.service.util.ImageSave;

import java.util.ArrayList;
import java.util.Optional;

import static junit.framework.TestCase.*;
import static org.mockito.ArgumentMatchers.any;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminPotionServiceTest {


    @Autowired
    private AdminPotionService potionService;


    @MockBean
    private PotionRepo potionRepo;

    @MockBean
    private ImageSave imageSave;




    @Test
    public void addNewPotion() {

        Potion newPotion = new Potion();
       potionService.addNewPotion(newPotion);
       Mockito.verify(potionRepo,Mockito.times(1)).save(newPotion);

    }



    @Test
    public void getAll() {
        potionService.getAll();
        Mockito.verify(potionRepo,Mockito.times(1)).findAll();
    }

    @Test
    public void addImage() {


        MockMultipartHttpServletRequest request = new MockMultipartHttpServletRequest();
        request.addFile(new MockMultipartFile("file",new byte[2]));
        request.addFile(new MockMultipartFile("file",new byte[2]));

        Potion potion = new Potion();
        potion.setImages(new ArrayList<>());

        Mockito.when(potionRepo.findById(any())).thenReturn(Optional.of(potion));
        potionService.addImages(1,request);
        Mockito.verify(potionRepo,Mockito.times(1)).findById(any());
        Mockito.verify(imageSave,Mockito.times(2)).save(any(),any());
        Mockito.verify(potionRepo,Mockito.times(1)).save(any(Potion.class));



        assertEquals(potion.getImages().size(),2);

    }
}