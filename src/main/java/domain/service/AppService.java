package domain.service;

import domain.model.Animal;

import java.util.ArrayList;

public class AppService {
    private AnimalService animals = new AnimalServiceDBSQL();
    private ImageService imageService = new ImageService();

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

}
