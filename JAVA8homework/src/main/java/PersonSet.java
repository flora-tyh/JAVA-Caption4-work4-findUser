import entity.Address;
import entity.Email;
import entity.MasterNumber;
import entity.Person;
import entity.Telephone;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PersonSet {
  private List<MasterNumber> masterNumbers;

  private List<Address> addresses;

  private List<Telephone> telephones;

  private List<Email> emails;

  public PersonSet(List<MasterNumber> masterNumbers,
                   List<Telephone> telephones,
                   List<Address> addresses,
                   List<Email> emails) {
    this.masterNumbers = masterNumbers;
    this.addresses = addresses;
    this.telephones = telephones;
    this.emails = emails;
  }

  public Stream<Person> groupToPeople() {
    // TODO: group the data to Stream<Person>
    // Can use Collectors.groupingBy method
    // Can add helper method
    List<Person> persons = new ArrayList<>();
    List<MasterNumber> realMasterNumbers = Optional.ofNullable(getMasterNumbers()).orElse(new ArrayList<MasterNumber>());
    List<Address> realAddresses = Optional.ofNullable(getAddresses()).orElse(new ArrayList<Address>());
    List<Telephone> realTelephones = Optional.ofNullable(getTelephones()).orElse(new ArrayList<Telephone>());
    List<Email> realEmails = Optional.ofNullable(getEmails()).orElse(new ArrayList<Email>());
    Map<String, Address> addressGroup = realAddresses.stream().collect(Collectors.toMap(Address :: getMasterNumber, a -> a));
    Map<String, List<Telephone>> telephoneGroup = realTelephones.stream().collect(Collectors.groupingBy(Telephone :: getMasterNumber));
    Map<String, List<Email>> emailGroup = realEmails.stream().collect(Collectors.groupingBy(Email :: getMasterNumber));

    realMasterNumbers.stream().map(num -> num.getNumber()).forEach(number
                                       -> persons.add(new Person(number,
                                                          telephoneGroup.getOrDefault(number, new ArrayList<>()),
                                                          addressGroup.getOrDefault(number, null),
                                                          emailGroup.getOrDefault(number, new ArrayList<>()))));
   return persons.stream();
  }

  public List<Address> getAddresses() {
    return addresses;
  }

  public List<Telephone> getTelephones() {
    return telephones;
  }

  public List<Email> getEmails() {
    return emails;
  }

  public List<MasterNumber> getMasterNumbers() {return masterNumbers; }

  public void setMasterNumbers(List<MasterNumber> masterNumbers) {
    this.masterNumbers = masterNumbers;
  }

  public void setAddresses(List<Address> addresses) {
    this.addresses = addresses;
  }

  public void setEmails(List<Email> emails) {
    this.emails = emails;
  }

  public void setTelephones(List<Telephone> telephones) {
    this.telephones = telephones;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof PersonSet)) return false;
    PersonSet personSet = (PersonSet) o;
    return Objects.equals(masterNumbers, personSet.masterNumbers) &&
            Objects.equals(addresses, personSet.addresses) &&
            Objects.equals(telephones, personSet.telephones) &&
            Objects.equals(emails, personSet.emails);
  }

  @Override
  public int hashCode() {
    return Objects.hash(masterNumbers, addresses, telephones, emails);
  }
}
