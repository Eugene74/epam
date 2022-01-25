package stream;

/*
please write the code here to find the youngest person and print his name and last name to console
*/

import java.util.*;

public class FindYoungerPerson {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Peter", "Patterson", 21));
        personList.add(new Person("Paul", "Walker", 31));
        personList.add(new Person("Steve", "Runner", 41));
        personList.add(new Person("Arnold1", "", -1));
        personList.add(new Person(" ", "Stevenson", 19));
        personList.add(new Person("Arnold2", "Stevenson", 19));
        personList.add(null);
        // **** //
        personList.add(new Person("Aaron", "Bortnicker", 18));
        Optional<Person> result = findYoungerPerson(personList);

        if (result.isPresent()) {
            Person person = result.get();
            System.out.println(person);
        } else {
            System.out.println("Person not found");
        }
    }

    private static Optional<Person> findYoungerPerson(List<Person> personList) {
        Optional<Person> youngerPerson = personList.stream()
                .filter(Objects::nonNull)
                .filter(a -> a.getAge() > 0)
                .min(Comparator.comparingInt(Person::getAge));
        return Optional.of(youngerPerson.get());
    }
}
