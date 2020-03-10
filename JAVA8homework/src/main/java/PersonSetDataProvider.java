import entity.Address;
import entity.Email;
import entity.MasterNumber;
import entity.Telephone;
import java.util.Arrays;
import java.util.List;

public class PersonSetDataProvider {

  public static PersonSet providePersonSetWithNumber1() {
    List<MasterNumber> masterNumbers =
        Arrays.asList(new MasterNumber("1"));

    List<Telephone> telephones =
        Arrays.asList(
            new Telephone("1", "+1", "123"),
            new Telephone("1", "+1", "456"));

    List<Address> addresses =
        Arrays.asList(new Address("1", "China", "Beijing", "Any Street"));

    List<Email> emails =
        Arrays.asList(new Email("1", "2343@gmail.com"),
                      new Email("1", "2344@gmail.com"));

    return new PersonSet(masterNumbers, telephones, addresses, emails);
  }

  public static PersonSet providePersonSetWithNumber1And2() {
    List<MasterNumber> masterNumbers =
        Arrays.asList(new MasterNumber("1"),
                      new MasterNumber("2"));

    List<Address> addresses =
        Arrays.asList(
            new Address("1", "China", "Beijing", "Any Street"),
            new Address("2", "China", "Beijing", "Any Street")
        );

    List<Telephone> telephones =
        Arrays.asList(
            new Telephone("1", "+1", "123"),
            new Telephone("1", "+1", "456"),
            new Telephone("2", "+1", "123"),
            new Telephone("2", "+1", "456"));

    List<Email> emails =
        Arrays.asList(
            new Email("1", "2343@gmail.com"),
            new Email("1", "2344@gmail.com"),
            new Email("2", "2343@gmail.com"),
            new Email("2", "2344@gmail.com")
        );

    return new PersonSet(masterNumbers, telephones, addresses, emails);
  }


}
