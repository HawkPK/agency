package pl.hawk.services;

import pl.hawk.entities.Category;
import pl.hawk.entities.Contact;


public interface ContactService {

    Iterable<Contact> listAllContacts();
    
    Iterable<Category> listAllCategory();

    Contact getContactById(Integer id);

    Contact saveContact(Contact contact);

    void deleteContact(Integer id);
}
