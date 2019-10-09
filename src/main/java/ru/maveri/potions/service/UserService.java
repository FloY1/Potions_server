package ru.maveri.potions.service;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.beans.factory.annotation.Value;
        import org.springframework.stereotype.Service;
        import ru.maveri.potions.model.Coordinate;
        import ru.maveri.potions.model.join.table.UserPotion;
        import ru.maveri.potions.repo.CoordinateRepo;
        import ru.maveri.potions.repo.ImageRepo;
        import ru.maveri.potions.repo.UserRepo;

        import javax.servlet.http.HttpServletResponse;
        import java.io.IOException;
        import java.nio.file.Files;
        import java.nio.file.Path;
        import java.util.ArrayList;
        import java.util.List;

@Service
public class UserService {

    @Value( "${file.path}" )
    private String staticImagePath;

    private UserRepo userRepo;
    private CoordinateRepo coordinateRepo;
    private ImageRepo imageRepo;


    @Autowired
    public UserService(UserRepo userRepo, ImageRepo imageRepo, CoordinateRepo coordinateRepo) {
        this.userRepo = userRepo;
        this.imageRepo = imageRepo;
        this.coordinateRepo = coordinateRepo;
    }

    public List<Long> getImageId(Long id){
        List<UserPotion> tempList;
        List<Long> idList = new ArrayList<>();

        tempList = userRepo.findById(Long.valueOf(id)).get().getPotions();

        for (UserPotion z:tempList) {
            idList.add(z.getImageUrl().getId());
        }

        return idList;
    }

    public void getImageById(long id, HttpServletResponse response) throws IOException {
        String partOfURL;
        partOfURL = String.valueOf(imageRepo.findById(Long.valueOf(id)).get().getUrl());


        response.setContentType("Image");


        Path imagePath =  Path.of(staticImagePath+partOfURL);
        Files.copy(imagePath,response.getOutputStream());
    }

    public List<UserPotion> getPotions() {
        return userRepo.findById((long) 1).get().getPotions();
    }

    public List<Coordinate> getCoordinates(long id, long radius){

        Coordinate coordinate = userRepo.findById(id).get().getCoordinate();
        List<Coordinate> coordinateList = coordinateRepo.findByLatitudeBetweenAndLongitudeBetween(coordinate.getLatitude()-radius,
           coordinate.getLatitude()+radius, coordinate.getLongitude()-radius, coordinate.getLongitude()+radius);

        if(coordinateList.contains(coordinate)) {
            coordinateList.remove(coordinate);
        }
        return coordinateList;
    }
}
