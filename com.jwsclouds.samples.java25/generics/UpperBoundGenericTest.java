package generics;

import java.util.ArrayList;
import java.util.List;

public class UpperBoundGenericTest {

    public static void main(String[] args) {

        List<Cat> sounds = new ArrayList<>();
        Cat cat1 = new Cat();
        sounds.add(cat1);

        List<Animal> superAnimalClass = new ArrayList<>();
        Animal cat2 = new Animal();
        superAnimalClass.add(cat2);

        soundsLikeWithExtends(sounds);
        soundsLikeWithSuper(sounds);

    }

    static void soundsLikeWithExtends(List<? extends Animal> animalSound){

        animalSound.stream().map(animal -> {
            if(animal instanceof Cat)
                ((Cat)animal).sounds("Cat","Meow");
            return animal;
        }).toList();


    }

    static void soundsLikeWithSuper(List<? super Cat> animalSound){

        animalSound.stream().map(animal -> {
            if(animal instanceof Animal)
                ((Animal)animal).sounds();
            return animal;
        }).toList();


    }
}
