package ru.maveri.potions.controller.admin.rest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import ru.maveri.potions.model.Potion;
import ru.maveri.potions.service.AdminPotionService;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminPotionControllerTest {

    @Autowired
    private AdminPotionController potionController;

    @MockBean
    private AdminPotionService potionService;

    @Test
    public void addPotion() {
        Potion potion = new Potion();
        potionController.addPotion(potion);
        Mockito.verify(potionService,Mockito.times(1)).addNewPotion(potion);
    }

    @Test(expected = NullPointerException.class)
    public void addPotionNull(){
        potionController.addPotion(null);

    }

    @Test
    public void addImage() {
        MockMultipartHttpServletRequest request = new MockMultipartHttpServletRequest();
        potionController.addImage(1,request);
        Mockito.verify(potionService,Mockito.times(1)).addImages(1,request);
    }

    @Test(expected = NullPointerException.class)
    public void addImageNullRequest(){
        potionController.addImage(1, null);
    }

    @Test(expected = NumberFormatException.class)
    public void addImageIncorrectId(){
        potionController.addImage(-1, new MockMultipartHttpServletRequest());
    }


}