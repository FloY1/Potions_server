package ru.maveri.potions.service;

import javassist.NotFoundException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.mock.web.MockMultipartHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.request.MockMultipartHttpServletRequestBuilder;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import ru.maveri.potions.model.Potion;
import ru.maveri.potions.repo.PotionRepo;

import javax.persistence.Access;
import javax.print.attribute.standard.PDLOverrideSupported;

import java.io.File;
import java.io.InputStream;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.postgresql.hostchooser.HostRequirement.any;


@RunWith(SpringRunner.class)
@SpringBootTest

public class AdminPotionServiceTest {


    @Autowired
    private AdminPotionService potionService;


    @MockBean
    private PotionRepo potionRepo;

  

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
}