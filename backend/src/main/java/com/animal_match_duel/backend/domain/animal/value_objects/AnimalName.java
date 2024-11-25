package com.animal_match_duel.backend.domain.animal.value_objects;

public class AnimalName {
    private String animalName;

    public AnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getAnimalName() {
        return this.animalName;
    }

    public static boolean isValidName(String name) {
        return !name.isBlank();
    }

}
