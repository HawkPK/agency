package pl.hawk.services;

import pl.hawk.entities.Category;
import pl.hawk.entities.Contact;
import pl.hawk.entities.Subcategory;


public interface ContactService {

    Iterable<Contact> listAllContacts();
    
    Iterable<Category> listAllCategory();
    
    Iterable<Subcategory> listAllSubcategory();

    Contact getContactById(Integer id);

    Contact saveContact(Contact contact);

    void deleteContact(Integer id);
}
