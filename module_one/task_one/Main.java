package ru.module_one.task_one;

import ru.module_one.task_one.environment.*;
import ru.module_one.task_one.animals.*;

public class Main {
    public static void main(String[] args) {
        Water sea = new Water(1000, "Океан");
        Fur catFur = new Fur("cерая", 3);
        Animal cat = new Cat(catFur);
        Animal whale = new Whale(sea);
        Animal fish = new Fish(sea);
        Animal bear = new Bear(new Fur("Коричневая", 10));

        System.out.println("Кошка живая: " + cat.isAlive());
        System.out.println("Кит плавает и живет: " + ((Aquatic) whale).getHabitat().getType());
        System.out.println("Глубина проживания рыбы: " + ((Aquatic) fish).getHabitat().getDepth());
        System.out.println("Медведь обитает: " + ((Terrestrial) bear).getTerrain());
    }
}