package pl.hawk.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.hawk.entities.Category;
import pl.hawk.entities.Contact;
import pl.hawk.entities.Subcategory;
import pl.hawk.repository.CategoryRepository;
import pl.hawk.repository.ContactRepository;
import pl.hawk.repository.SubcategoryRepository;

/**
 * 
 * Implementacja usług dla kontaktu 
 * @author Hawk
 *
 */
@Service
public class ContactServiceImpl implements ContactService {

	
	private ContactRepository contactRepository;
	private CategoryRepository category;
	private SubcategoryRepository subcategory;
	
    @Autowired
    public void setProductRepository(ContactRepository contactRepository, CategoryRepository category, SubcategoryRepository subcategory) {
        this.contactRepository = contactRepository;
        this.category = category;
        this.subcategory = subcategory;
    }
	
    @Override
	public Iterable<Contact> listAllContacts() {
		return contactRepository.findAll();
	}

	 @Override
	public Contact getContactById(Integer id) {
		
		return contactRepository.findOne(id);
	}

	 @Override
	public Contact saveContact(Contact contact) {
		
		return contactRepository.save(contact);
	}

	 @Override
	public void deleteContact(Integer id) {
		
		contactRepository.delete(id);
		
	}

	@Override
	public Iterable<Category> listAllCategory() {
		return category.findAll();
	}

	@Override
	public Iterable<Subcategory> listAllSubcategory() {
		// TODO Auto-generated method stub
		return subcategory.findAll();
	}

}
