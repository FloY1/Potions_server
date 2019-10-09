package ru.maveri.potions.controller.other;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.maveri.potions.service.UserService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("image")
public class ImageController {

    UserService userService;

    @Autowired
    public ImageController(UserService userService){
        this.userService = userService;
    }

    @GetMapping()
    public List<Long> getIdImage(){
        List<Long> imageId = userService.getImageId((long) 1);
        return imageId;
    }

    @GetMapping(value = "/{id}")
    public void getImageById(@PathVariable long id, HttpServletResponse response) throws IOException {
        response.setContentType("Image");
        userService.getImageById(id,response);
    }







}
