package com.y.back.services;

import com.y.back.models.entity.Person;
import com.y.back.models.repository.PersonRepository;
import com.y.back.errors.NoRegisteredUsers;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Person service.
 */
@Service
public class PersonService implements UserDetailsService {
  private PersonRepository personRepository;

  @Autowired
  public PersonService(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }
  
  /**
   * Create a person with informations in object.
   * Object @param person
   * Return object @return
   */
  public Person createPerson(Person person) {
    String hashedPassword = new BCryptPasswordEncoder().encode(person.getPassword());
    person.setPassword(hashedPassword);

    return personRepository.save(person);
  }

  /**
   * Method that return a list of all persons registered.
   * Returns a list of all persons @return
   */
  public List<Person> getAllPersons() {
    if(personRepository.findAll().isEmpty()) {
      throw new NoRegisteredUsers();
    };

    return personRepository.findAll();
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return personRepository.findByUsername(username)
      .orElseThrow(() -> new UsernameNotFoundException(username));
  }
}
