package com.asifkamal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    record Person(String firstName, String lastName) {
        @Override
        public String toString()
        {
            return firstName + " " + lastName;
        }
    }
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>(Arrays.asList(
                new Main.Person("Lucy", "Van Pelt"),
                new Person("Sally", "Brown"),
                new Person("Linus", "Van Pelt"),
                new Person("Charlie", "Brown"),
                new Person("Peppermint", "Patty")
        ));

        //using anonymous class
        var comparatorLastName = new Comparator<Person>() {

            @Override
            public int compare(Person o1, Person o2) {
                return o1.lastName().compareTo(o2.lastName());
            }
        };

        //anonymous class inside sort method
        people.sort((o1, o2) -> o1.lastName().compareTo(o2.lastName()));
        System.out.println(people);

        interface EnhancedComparator<T> extends Comparator<Person> {
            int secondLevel(T o1, T o2);
        }
        var comparatorMixed = new EnhancedComparator<Person>() {

            @Override
            public int compare(Person o1, Person o2) {
                int result = o1.lastName().compareTo(o2.lastName());
                return result != 0 ? result : secondLevel(o1, o2);
            }

            @Override
            public int secondLevel(Person o1, Person o2) {
                return o1.firstName().compareTo(o2.firstName());
            }
        };

        people.sort(comparatorMixed);
        System.out.println(people);
    }
}