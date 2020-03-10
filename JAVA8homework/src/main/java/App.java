import entity.Address;
import entity.MasterNumber;
import entity.Person;
import entity.Telephone;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

  public static void main(String[] args) {
    PersonService personService = new PersonService();
    //TODO: print Person data that masterNumber is 1 and 2
    // print Person data that masterNumber is 3
    System.out.println(personService.getPersonByMasterNumbers(Arrays.asList(new MasterNumber("1"), new MasterNumber("2"))).collect(Collectors.toList()));
    System.out.println(personService.getPersonByMasterNumbers(Arrays.asList(new MasterNumber("3"))).collect(Collectors.toList()));
  }

}
