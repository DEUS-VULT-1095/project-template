package edu.hw4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public record Animal(
    String name,
    Type type,
    Sex sex,
    int age,
    int height,
    int weight,
    boolean bites
) {
    enum Type {
        CAT, DOG, BIRD, FISH, SPIDER
    }

    enum Sex {
        M, F
    }

    @SuppressWarnings("MagicNumber")
    public int paws() {
        return switch (type) {
            case CAT, DOG -> 4;
            case BIRD -> 2;
            case FISH -> 0;
            case SPIDER -> 8;
        };
    }

    // task1
    public static List<Animal> sortAscByHeight(List<Animal> animals) {
        return animals.stream()
            .sorted(Comparator.comparingInt(Animal::height))
            .collect(Collectors.toList());
    }

    // task2
    public static List<Animal> sortDescByWeightAndLimit(List<Animal> animals, int limit) {
        return animals.stream()
            .sorted(Comparator.comparingInt(Animal::weight).reversed())
            .limit(limit)
            .collect(Collectors.toList());
    }

    // task3
    public static Map<Type, Integer> countAnimalsByType(List<Animal> animals) {
        return animals.stream()
            .collect(Collectors.groupingBy(Animal::type, Collectors.summingInt(animal -> 1)));
    }

    // task4
    public static Animal getLongestNameAnimal(List<Animal> animals) {
        return animals.stream()
            .max(Comparator.comparingInt(animal -> animal.name.length()))
            .orElse(null);
    }

    // task5
    public static Sex getMostAmountAnimalsBySexType(List<Animal> animals) {
        return animals.stream()
            .collect(Collectors.groupingBy(Animal::sex, Collectors.counting()))
            .entrySet()
            .stream()
            .max(Map.Entry.comparingByValue())
            .map(Map.Entry::getKey)
            .orElse(null);
    }

    // task6
    public static Map<Animal.Type, Animal> getHeaviestAnimalEachSpecies(List<Animal> animals) {
        return animals.stream()
            .collect(Collectors.toMap(
                Animal::type,
                animal -> animal,
                (existing, replacement) -> existing.weight() > replacement.weight() ? existing : replacement
            ));
    }

    // task7
    public static Animal getKOldestAnimal(List<Animal> animals, int k) {
        return animals.stream()
            .sorted(Comparator.comparingInt(Animal::age).reversed())
            .skip(k - 1)
            .findFirst()
            .orElse(null);
    }

    // task8
    public static Optional<Animal> getHeaviestAnimalLowerKSm(List<Animal> animals, int k) {
        return animals.stream()
            .filter(animal -> animal.height() < k)
            .max(Comparator.comparingInt(Animal::weight));
    }

    // task9
    public static Integer countPaws(List<Animal> animals) {
        return animals.stream()
            .mapToInt(Animal::paws)
            .sum();
    }

    // task10
    public static List<Animal> getAnimalListAgeNotMatchPaws(List<Animal> animals) {
        return animals.stream()
            .filter(animal -> animal.age() != animal.paws())
            .toList();
    }

    // task11
    public static List<Animal> getAnimalListCanBite(List<Animal> animals) {
        return animals.stream()
            .filter(Animal::bites)
            .toList();
    }

    // task12
    public static Integer getAmountWeightBiggerHeight(List<Animal> animals) {
        return animals.stream()
            .filter(animal -> animal.weight() > animal.height())
            .mapToInt(animal -> 1)
            .sum();
    }

    // task13
    public static List<Animal> getAnimalListConsistNamesMoreThanTwoWords(List<Animal> animals) {
        return animals.stream()
            .filter(animal -> animal.name().split(" ").length > 2)
            .toList();
    }

    // task14
    public static Boolean isExistDogHeightMoreK(List<Animal> animals, int k) {
        return animals.stream()
            .anyMatch(animal -> animal.type() == Type.DOG && animal.height() > k);
    }

    // task15
    public static Integer getSumWeightByAge(List<Animal> animals, int k, int l) {
        return animals.stream()
            .filter(animal -> animal.age() >= k && animal.age() <= l)
            .mapToInt(Animal::weight)
            .sum();
    }

    // task16
    public static List<Animal> getSortedListByTypeSexName(List<Animal> animals) {
        return animals.stream()
            .sorted(Comparator.comparing(Animal::type)
                .thenComparing(Animal::sex)
                .thenComparing(Animal::name))
            .toList();
    }

    // task17
    public static Boolean spidersBiteMoreOftenThanDogs(List<Animal> animals) {
        double spiderBiteRate = animals.stream()
            .filter(animal -> animal.type() == Type.SPIDER)
            .collect(Collectors.teeing(
                Collectors.counting(),
                Collectors.filtering(Animal::bites, Collectors.counting()),
                (total, biting) -> total > 0 ? (double) biting / total : 0
            ));

        double dogBiteRate = animals.stream()
            .filter(animal -> animal.type() == Type.DOG)
            .collect(Collectors.teeing(
                Collectors.counting(),
                Collectors.filtering(Animal::bites, Collectors.counting()),
                (total, biting) -> total > 0 ? (double) biting / total : 0
            ));

        if (spiderBiteRate != 0 && dogBiteRate != 0) {
            return spiderBiteRate > dogBiteRate;
        }

        return false;
    }

    // task18
    public static Animal getHeaviestFish(
        List<Animal> animals1,
        List<Animal> animals2,
        List<Animal>... animals3
    ) {
        List<List<Animal>> allLists = new ArrayList<>();
        allLists.add(animals1);
        allLists.add(animals2);
        allLists.addAll(Arrays.asList(animals3));

        return allLists.stream()
            .flatMap(List::stream)
            .filter(animal -> animal.type() == Type.FISH)
            .max(Comparator.comparingInt(Animal::weight))
            .orElse(null);
    }

    // task19
    public static Map<String, Set<ValidationError>> getErrors(List<Animal> animals) {
        Map<String, Set<ValidationError>> animalsWithErrors = new HashMap<>();

        for (Animal animal : animals) {
            Set<ValidationError> errors = new HashSet<>();

            if (animal.age() < 0) {
                errors.add(new ValidationError("Age negative"));
            }
            if (animal.height() <= 0) {
                errors.add(new ValidationError("Height not positive"));
            }
            if (animal.weight() <= 0) {
                errors.add(new ValidationError("Weight not positive"));
            }

            if (!errors.isEmpty()) {
                animalsWithErrors.put(animal.name(), errors);
            }
        }

         return animalsWithErrors;
    }

    // task20
    public static Map<String, String> getComfortableErrors(List<Animal> animals) {
        return animals.stream()
            .filter(animal -> animal.age() < 0 || animal.height() <= 0 || animal.weight() <= 0)
            .collect(Collectors.toMap(
                Animal::name,
                animal -> {
                    StringBuilder sb = new StringBuilder();
                    if (animal.age() < 0) {
                        sb.append("Age negative; ");
                    }
                    if (animal.height() <= 0) {
                        sb.append("Height not positive; ");
                    }
                    if (animal.weight() <= 0) {
                        sb.append("Weight not positive; ");
                    }

                    return sb.toString();
                }
            ));
    }

    public static class ValidationError {
        private final String errorDescription;

        public ValidationError(String errorDescription) {
            this.errorDescription = errorDescription;
        }

        public String getErrorDescription() {
            return errorDescription;
        }

        @Override public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            ValidationError that = (ValidationError) o;

            return Objects.equals(errorDescription, that.errorDescription);
        }

        @Override
        public int hashCode() {
            return errorDescription != null ? errorDescription.hashCode() : 0;
        }
    }
}
