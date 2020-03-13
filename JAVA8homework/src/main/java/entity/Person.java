package entity;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Person {

  private String masterNumber;
  private Address address;

  private List<Telephone> telephones;

  private List<Email> emails;

  public Person() {
  }

  public Person(String masterNumber, List<Telephone> telephones, Address address,
                List<Email> emails) {
    this.masterNumber = masterNumber;
    this.address = address;
    this.telephones = telephones;
    this.emails = emails;
  }

  public Optional<SimpleAddress> getSimpleAddress() {
    //TODO: return Optional<SimpleAddress>
    Optional<Address> address = Optional.ofNullable(this.address);
    Optional<SimpleAddress> sa = address.map(addr -> new SimpleAddress(addr.getStreet(), addr.getCity()));
    return sa;
  }

  public Address getAddress() {
    return address;
  }

  public List<Email> getEmails() {
    return emails;
  }

  public List<Telephone> getTelephones() {
    return telephones;
  }

  public void setMasterNumber(String masterNumber) {
    this.masterNumber = masterNumber;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public void setTelephones(List<Telephone> telephones) {
    this.telephones = telephones;
  }

  public void setEmails(List<Email> emails) {
    this.emails = emails;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Person)) return false;
    Person person = (Person) o;
    return Objects.equals(masterNumber, person.masterNumber) &&
            Objects.equals(address, person.address) &&
            Objects.equals(telephones, person.telephones) &&
            Objects.equals(emails, person.emails);
  }

  @Override
  public int hashCode() {
    return Objects.hash(masterNumber, address, telephones, emails);
  }

  @Override
  public String toString() {
    return "Person{" +
            "masterNumber='" + masterNumber + '\'' +
            ", address=" + address +
            ", telephones=" + telephones +
            ", emails=" + emails +
            '}';
  }
}
