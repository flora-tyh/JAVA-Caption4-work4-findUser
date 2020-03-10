import entity.MasterNumber;
import entity.Person;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PersonService {

  private Map<List<String>, Optional<PersonSet>> people;

  public PersonService() {
    this.people = new HashMap<>();
    people.put(Arrays.asList("1"), Optional.of(PersonSetDataProvider.providePersonSetWithNumber1()));
    people.put(Arrays.asList("1", "2"), Optional.of(PersonSetDataProvider.providePersonSetWithNumber1And2()));
  }

  public Stream<Person> getPersonByMasterNumbers(List<MasterNumber> numbers) {
    //TODO: Add the code to return people by numbers
    // Use groupToPeople() method
    List<String> numbersList = numbers.stream().map(MasterNumber::getNumber).collect(Collectors.toList());
    Optional<PersonSet> personSet = Optional.ofNullable(people.get(numbersList)).orElse(Optional.of(new PersonSet(null, null, null, null)));
    Stream<Person> person = personSet.get().groupToPeople();
    return person;
  }
}
