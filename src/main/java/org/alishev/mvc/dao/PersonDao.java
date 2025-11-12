package org.alishev.mvc.dao;

import org.alishev.mvc.model.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDao {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "a", 10, "a@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "s", 11, "s@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "d", 12, "d@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "q", 13, "q@mail.ru"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream()
                .filter(person -> person.getId() == id)
                .findAny()
                .orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatedPerson) {
        Person personToBeUpdated = show(id);

        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }

    public void delete(int id) {
        people.removeIf(person -> person.getId() == id);
    }
}
