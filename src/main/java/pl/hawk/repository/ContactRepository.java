package pl.hawk.repository;

import org.springframework.data.repository.CrudRepository;

import pl.hawk.entities.Contact;

public interface ContactRepository extends CrudRepository<Contact, Integer>{
}
