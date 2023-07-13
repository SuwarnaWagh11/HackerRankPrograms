package lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Unit1Exercise {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("ZA","YB", 20),
                new Person("CB","BC",21),
                new Person("FC","MD",22),
                new Person("CD","DE",23),
                new Person("AE","YF",24)
        );
        //step 1 ; sort list by last name
/*
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getLastName().compareTo(o2.getLastName());
            }
        });
*/

        Collections.sort(people, (o1,o2)-> o1.getLastName().compareTo(o2.getLastName()));
        Collections.sort(people, Comparator.comparing(Person::getLastName));
        //step 2: create method that prints all elements from the list
        printAllConditionally(people,p -> true);
        Collections.sort(people, Comparator.comparing(Person::getFirstName));
        printAllConditionally(people,person -> true);
        //step 3: create method that prints all the elements starts with C
        printAllConditionally(people, person -> person.getLastName().startsWith("C"));

    }

    private static void printAllConditionally(List<Person> people, Predicate<Person> c) {
        for(Person p: people){
            if(c.test(p)){
                System.out.println(p);
            }
        }
    }
}
