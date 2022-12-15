package domain.service;

import domain.model.Animal;
import domain.model.Location;

import java.util.ArrayList;

public class AppService {
    private AnimalService animals = new AnimalServiceDBSQL();
    private ImageService imageService = new ImageService();

    private LocationService locationService = new LocationService();

    public void addAnimal(Animal animal) {
        animals.addAnimal(animal);
    }

    public Animal findAnimalWithName(String naam) {
        return animals.findAnimalWithName(naam);
    }

    public ArrayList<Animal> getAllAnimals() {
        return animals.getAllAnimals();
    }

    public void addImage(String filename) {
        imageService.addImage(filename);
    }

    public ArrayList<String> getAllImages(){
        return imageService.getAllImages();
    }

    public void addLocation(Location location) {
        locationService.addLocation(location);
    }

    public ArrayList<Location> getAllLocations(){

        return locationService.getAllLocations();
    }
}
