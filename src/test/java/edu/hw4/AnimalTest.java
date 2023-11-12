package edu.hw4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {
    private List<Animal> animals = new ArrayList<>();
    private List<Animal> testAnimalList;

    @BeforeEach
    void beforeEach() {
        animals.add(new Animal("Musya", Animal.Type.CAT, Animal.Sex.F, 7, 20, 4, true));
        animals.add(new Animal("Tom", Animal.Type.CAT, Animal.Sex.M, 9, 24, 7, true));
        animals.add(new Animal("Busya", Animal.Type.CAT, Animal.Sex.F, 5, 18, 8, true));
        animals.add(new Animal("Gav", Animal.Type.DOG, Animal.Sex.M, 10, 45, 25, true));
        animals.add(new Animal("Balloon", Animal.Type.DOG, Animal.Sex.M, 4, 35, 18, true));
        animals.add(new Animal("Arrow", Animal.Type.BIRD, Animal.Sex.M, 8, 10, 3, false));
        animals.add(new Animal("Clown", Animal.Type.BIRD, Animal.Sex.M, 6, 31, 13, true));
        animals.add(new Animal("Sirena", Animal.Type.FISH, Animal.Sex.F, 3, 13, 5, false));
        animals.add(new Animal("Goldy", Animal.Type.FISH, Animal.Sex.M, 11, 18, 6, true));
        animals.add(new Animal("Nightmare", Animal.Type.SPIDER, Animal.Sex.M, 1, 5, 2, true));
        animals.add(new Animal("Blood Queen", Animal.Type.SPIDER, Animal.Sex.F, 2, 4, 1, true));

        testAnimalList = new ArrayList<>(animals);
    }

    // task1
    @DisplayName("Test asc sort by height")
    @Test
    void testSortAscByHeight_whenProvidedAnimalList_returnsSortedList() {
        // Arrange
        testAnimalList.sort(Comparator.comparingInt(Animal::height));

        // Act
        List<Animal> actualAnimalList = Animal.sortAscByHeight(animals);

        // Assert
        assertEquals(testAnimalList, actualAnimalList, "Actual and Expected lists should be equals");
    }

    // task2
    @DisplayName("Test desc sort by weight and limit")
    @Test
    void testSortDescByWeightAndLimit_whenProvidedAnimalList_returnsSortedAndLimitList() {
        // Arrange
        int limit = 2;
        testAnimalList = testAnimalList.stream()
            .sorted(Comparator.comparingInt(Animal::weight).reversed())
            .limit(limit)
            .collect(Collectors.toList());

        // Act
        List<Animal> actualAnimalList = Animal.sortDescByWeightAndLimit(animals, limit);

        // Assert
        assertEquals(testAnimalList, actualAnimalList, "Actual and Expected lists should be equals");
    }

    // task3
    @Test
    void testCountAnimalsByType_whenProvidedAnimalList_returnsSortedMapByType() {
        // Arrange
        Map<Animal.Type, Integer> expectedAnimalMap = animals.stream()
            .collect(Collectors.groupingBy(Animal::type, Collectors.summingInt(animal -> 1)));

        // Act
        Map<Animal.Type, Integer> actualAnimalMap = Animal.countAnimalsByType(animals);

        // Assert
        assertEquals(expectedAnimalMap, actualAnimalMap, "Actual and Expected maps should be equals");
    }

    // task4
    @Test
    void testGetLongestNameAnimal_whenProvidedAnimalList_returnsAnimalWithLongestName() {
        // Arrange
        Animal expectedAnimal = testAnimalList.stream()
            .max(Comparator.comparingInt(animal -> animal.name().length()))
            .orElse(null);

        // Act
        Animal actualAnimal = Animal.getLongestNameAnimal(animals);

        // Assert
        assertEquals(expectedAnimal, actualAnimal, "Actual and Expected animal should be equals");
    }

    // task5
    @Test
    void testGetMostAmountAnimalsBySexType_whenProvidedAnimalList_returnsTypeOfSex() {
        // Arrange
        Animal.Sex expectedSex = testAnimalList.stream()
            .collect(Collectors.groupingBy(Animal::sex, Collectors.counting()))
            .entrySet()
            .stream()
            .max(Map.Entry.comparingByValue())
            .map(Map.Entry::getKey)
            .orElse(null);

        // Act
        Animal.Sex actualSex = Animal.getMostAmountAnimalsBySexType(animals);

        // Assert
        assertEquals(expectedSex, actualSex, "Actual and Expected Sex should be equals");
    }

    // task6
    @Test
    void testGetHeaviestAnimalEachSpecies_whenProvidedAnimalList_returnsMap() {
        // Arrange
        Map<Animal.Type, Animal> expectedAnimalMap = testAnimalList.stream()
            .collect(Collectors.toMap(
                Animal::type,
                animal -> animal,
                (existing, replacement) -> existing.weight() > replacement.weight() ? existing : replacement));

        // Act
        Map<Animal.Type, Animal> actualAnimalMap = Animal.getHeaviestAnimalEachSpecies(animals);

        // Assert
        assertEquals(expectedAnimalMap, actualAnimalMap);
    }

    // task7
    @Test
    void testGetKOldestAnimal_whenProvidedAnimalListAndK_returnsAnimal() {
        // Arrange
        int k = 2;
        Animal expectedAnimal = testAnimalList.stream()
            .sorted(Comparator.comparingInt(Animal::age).reversed())
            .skip(k - 1)
            .findFirst()
            .orElse(null);
        System.out.println(expectedAnimal);

        // Act
        Animal actualAnimal = Animal.getKOldestAnimal(animals, k);

        // Assert
        assertEquals(expectedAnimal, actualAnimal);
    }

    // task8
    @Test
    void testGetHeaviestAnimalLowerKSm_whenProvidedAnimalListAndK_returnsOptional() {
        // Arrange
        int k = 15;
        Optional<Animal> expectedAnimal = animals.stream()
            .filter(animal -> animal.height() < k)
            .max(Comparator.comparingInt(Animal::weight));

        // Act
        Optional<Animal> actualAnimal = Animal.getHeaviestAnimalLowerKSm(animals, k);

        // Assert
        assertEquals(expectedAnimal, actualAnimal);
    }

    // task9
    @Test
    void testCountPaws_whenProvidedAnimalList_returnsPawsAmount() {
        // Arrange
        int expectedPawsAmount = testAnimalList.stream()
            .mapToInt(Animal::paws)
            .sum();

        // Act
        int actualPawsAmount = Animal.countPaws(animals);

        // Assert
        assertEquals(expectedPawsAmount, actualPawsAmount);
    }

    // task10
    @Test
    void testGetAnimalListAgeNotMatchPaws_whenProvidedAnimalList_returnsList() {
        // Arrange
        List<Animal> expectedList = testAnimalList.stream()
            .filter(animal -> animal.age() != animal.paws())
            .toList();

        // Act
        List<Animal> actualList = Animal.getAnimalListAgeNotMatchPaws(animals);

        // Assert
        assertEquals(expectedList, actualList);
    }

    // task11
    @Test
    void getAnimalListCanBiteAndHeightOver100_whenProvidedAnimalList_returnsList() {
        // Arrange
        List<Animal> expectedList = testAnimalList.stream()
            .filter(animal -> animal.bites() && animal.height() > 100)
            .toList();

        // Act
        List<Animal> actualList = Animal.getAnimalListCanBiteAndHeightOver100(animals);

        // Assert
        assertEquals(expectedList, actualList);
    }

    // task12
    @Test
    void testGetAmountWeightBiggerHeight_whenProvidedAnimalList_returnsAmount() {
        // Arrange
        int expectedAmount = (int) testAnimalList.stream()
            .filter(animal -> animal.weight() > animal.height())
            .count();

        // Act
        int actualAmount = Animal.getAmountWeightBiggerHeight(animals);

        // Assert
        assertEquals(expectedAmount, actualAmount);
    }

    // task13
    @Test
    void testGetAnimalListConsistNamesMoreThanTwoWords_whenProvidedAnimalList_returnsList() {
        // Arrange
        List<Animal> expectedAnimalList = testAnimalList.stream()
            .filter(animal -> animal.name().split(" ").length > 2)
            .toList();

        // Act
        List<Animal> actualAnimalList = Animal.getAnimalListConsistNamesMoreThanTwoWords(animals);

        // Assert
        assertEquals(expectedAnimalList, actualAnimalList);
    }

    // task14
    @Test
    void testisExistDogHeightMoreK_whenProvidedAnimalList_returnsBoolean() {
        // Arrange
        int k = 20;
        boolean expectedBoolean = testAnimalList.stream()
            .anyMatch(animal -> animal.type() == Animal.Type.DOG && animal.height() > k);

        // Act
        boolean actualBoolean = Animal.isExistDogHeightMoreK(animals, k);

        // Assert
        assertEquals(expectedBoolean, actualBoolean);
    }

    // task15
    @Test
    void testGetSumWeightByAge_whenProvidedAnimalList_returnsSumWeight() {
        // Arrange
        int k = 4;
        int l = 10;
        Map<Animal.Type, Integer> expectedMap = testAnimalList.stream()
            .filter(animal -> animal.age() >= k && animal.age() <= l)
            .collect(Collectors.groupingBy(Animal::type, Collectors.summingInt(Animal::weight)));

        // Act
        Map<Animal.Type, Integer> actualMap = Animal.getSumWeightByAge(animals, k, l);

        // Assert
        assertTrue(equalsMap(expectedMap, actualMap));
    }

    private boolean equalsMap(Map<Animal.Type, Integer> expectedMap, Map<Animal.Type, Integer> actualMap) {
        if (expectedMap.size() != actualMap.size()) {
            return false;
        }

        for (Map.Entry<Animal.Type, Integer> next : expectedMap.entrySet()) {
            if (!actualMap.containsKey(next.getKey()) || !next.getValue().equals(actualMap.get(next.getKey()))) {
                return false;
            }
        }

        return true;
    }

    // task16
    @Test
    void testGetSortedListByTypeSexName_whenProvidedAnimalList_returnsSortedlist() {
        // Arrange
        List<Animal> expectedList = testAnimalList.stream()
            .sorted(Comparator.comparing(Animal::type)
                    .thenComparing(Animal::sex)
                    .thenComparing(Animal::name))
            .toList();

        // Act
        List<Animal> actualList = Animal.getSortedListByTypeSexName(animals);

        // Assert
        assertEquals(expectedList, actualList);
    }

    // task17
    @Test
    void testSpidersBiteMoreOftenThanDogs_whenProvidedAnimalList_returnsBoolean() {
        // Arrange
        double spidersBiteRate = testAnimalList.stream()
            .filter(animal -> animal.type() == Animal.Type.SPIDER)
            .collect(Collectors.teeing(
                Collectors.counting(),
                Collectors.filtering(Animal::bites, Collectors.counting()),
                (total, bites) -> total > 0 ? (double) bites / total : 0
            ));

        double dogsBiteRate = testAnimalList.stream()
            .filter(animal -> animal.type() == Animal.Type.DOG)
            .collect(Collectors.teeing(
                Collectors.counting(),
                Collectors.filtering(Animal::bites, Collectors.counting()),
                (total, bites) -> total > 0 ? (double) bites / total : 0
            ));

        boolean expectedBoolean = false;

        if (spidersBiteRate != 0 && dogsBiteRate != 0) {
            expectedBoolean = spidersBiteRate > dogsBiteRate;
        }

        // Act
        boolean actualBoolean = Animal.spidersBiteMoreOftenThanDogs(animals);

        // Assert
        assertEquals(expectedBoolean, actualBoolean);
    }

    // task18
    @Test
    void testGetHeaviestFish_whenProvidedAnimalLists_returnsAnimal() {
        // Arrange
        List<Animal> testAnimalList2 = new ArrayList<>();
        testAnimalList2.add(new Animal("Boby", Animal.Type.FISH, Animal.Sex.M, 10, 25, 40, false));
        List<List<Animal>> lists = new ArrayList<>();
        lists.add(testAnimalList);
        lists.add(testAnimalList2);
        Animal expectedAnimal = lists.stream()
            .flatMap(List::stream)
            .filter(animal -> animal.type() == Animal.Type.FISH)
            .max(Comparator.comparingInt(Animal::weight))
            .orElse(null);

        // Act
        Animal actualAnimal = Animal.getHeaviestFish(animals, testAnimalList2);

        // Assert
        assertEquals(expectedAnimal, actualAnimal);
    }

    // task19
    @Test
    void testGetErrors_whenProvidedAnimalList_returnsMap() {
        // Arrange
        Animal animal = new Animal("Polly", Animal.Type.BIRD, Animal.Sex.M, -1, -1, -1, true);
        animals.add(animal);
        Map<String, Set<Animal.ValidationError>> expectedMap = new HashMap<>();
        Set<Animal.ValidationError> set = new HashSet<>();
        set.add(new Animal.ValidationError("Age negative"));
        set.add(new Animal.ValidationError("Height not positive"));
        set.add(new Animal.ValidationError("Weight not positive"));
        expectedMap.put(animal.name(), set);

        // Act
        Map<String, Set<Animal.ValidationError>> actualMap = Animal.getErrors(animals);

        // Assert
        assertTrue(areMapsEqual(expectedMap, actualMap));
    }

    private boolean areMapsEqual(Map<String, Set<Animal.ValidationError>> map1,
        Map<String, Set<Animal.ValidationError>> map2) {
        if (map1.size() != map2.size()) {
            return false;
        }

        for (Map.Entry<String, Set<Animal.ValidationError>> entry : map1.entrySet()) {
            String key1 = entry.getKey();
            Set<Animal.ValidationError> value1 = entry.getValue();
            Set<Animal.ValidationError> value2 = map2.get(key1);

            if (value1.size() != value2.size()) {
                return false;
            }

            for (Animal.ValidationError next : value1) {
                if (!value2.contains(next)) {
                    return false;
                }
            }
        }

        return true;
    }

    // task20
    @Test
    void testGetComfortableErrors_whenProvidedAnimalList_returnsMap() {
        // Arrange
        Animal animal = new Animal("Polly", Animal.Type.BIRD, Animal.Sex.M, -1, -1, -1, true);
        animals.add(animal);
        Map<String, String> expectedMap = new HashMap<>();
        expectedMap.put(animal.name(), "Age negative" + "; " + "Height not positive" + "; " + "Weight not positive" + "; ");

        // Act
        Map<String, String> actualMap = Animal.getComfortableErrors(animals);

        // Assert
        assertEquals(expectedMap, actualMap);
    }

}
