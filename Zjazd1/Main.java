import java.util.*;
import java.util.stream.Collectors;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Person person1 = null;
        try {
            person1 = new Person("Jan", 20);
        } catch (InvalidAgeException e) {
            System.out.println("Zlapano wyjatek: " + e.getMessage());
        }
        try {
            Person person2 = new Person("Adam", -5);
        } catch (InvalidAgeException e) {
            System.out.println("Zlapano wyjatek: " + e.getMessage());
        }
        System.out.println("Osoba: " + person1.toString());

        Person personx = new Person("Alicja", 23);
        Person persony = new Person("Kacper", 38);
        Person personz = new Person("Anna", 21);

        List<Person> immutablePersonlist = List.of(personx, persony, personz); // -- moze miec zdublowane wartosc
        System.out.println("Lista niemutowalna: " + immutablePersonlist);

        List<Person> mutablePersonList = new ArrayList<>();
        mutablePersonList.add(personx);
        mutablePersonList.add(persony);
        mutablePersonList.add(personz);

        System.out.println("Lista mutowalna: " + mutablePersonList);


        Set<Person> immutablePersonSet = Set.of(personx, persony, personz); // -- Zawiera tylko unikalne wartosci

        System.out.println("Set niemutowalny: " + immutablePersonSet);

        Set<Person> mutablePersonSet = new HashSet<>();
        mutablePersonSet.add(personx);
        mutablePersonSet.add(persony);
        mutablePersonList.add(personz);

        System.out.println("Set mutowalny: "+ mutablePersonSet);

        Map<Integer, Person> immutablPersonMap = Map.of(1, personx, 2, persony, 3, personz, 4, personx);

        System.out.println("Mapa niemutowalna: " + immutablPersonMap);

        Map<String, Person> mutablePersonMap = new HashMap<>();
        mutablePersonMap.put("A", personx);
        mutablePersonMap.put("B", persony);
        mutablePersonMap.put("C", personz);
        mutablePersonMap.put("A", persony);

        System.out.println("Mapa mutowalna: " + mutablePersonMap);




        ////Streamy
        List<Integer> ageList = immutablePersonlist.stream()
                .map(Person::getAge)
                .collect(Collectors.toList());

        Integer ageSum = ageList.stream()
                .reduce(0,(sum, value) -> sum + value);

        System.out.println("Suma lat: " + ageSum);

        double averageAge = (double)ageSum / ageList.size();

        System.out.println("Srednia wieku to: " + averageAge);




        //Zad 4.1
        Integer ageSum1 = immutablePersonlist.stream()
                .map(Person::getAge)
                .reduce(0, Integer::sum);

        System.out.println("Suma stream chain: " + ageSum1);



        //Zad 4.2
        List<String> nameList = immutablePersonlist.stream()
                .map(Person::getName)
                .collect(Collectors.toList());
        System.out.println("Lista imion to: " + nameList);




        //Zad 4.3
        List<Person> above25 = immutablePersonlist.stream()
                .filter(p -> p.getAge() > 25)
                .collect(Collectors.toList());

        System.out.println("Lista osob powyzej 25 roku zycia: " + above25);




        //Zad 4.4
        List<Person> alphabet = immutablePersonlist.stream()
                .sorted(Comparator.comparing(Person::getName))
                .collect(Collectors.toList());

        System.out.println("Posortowana lista wedlug alfabetu: " + alphabet);




        //Zad 4.5
        immutablePersonlist.stream()
                .forEach(System.out::println);




        //Zad 4.6
        Person minAge = immutablePersonlist.stream()
                .min(Comparator.comparing(Person::getAge))
                .orElseThrow(NoSuchElementException::new);

        System.out.println("Najmlodsza osoba: " + minAge);

        Person maxAge = immutablePersonlist.stream()
                .max(Comparator.comparing(Person::getAge))
                .orElseThrow(NoSuchElementException::new);

        System.out.println("Najstarsza osoba: " + maxAge);

        }
    }
