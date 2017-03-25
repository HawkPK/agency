package pl.hawk.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.hawk.entities.Contact;
import pl.hawk.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	private ContactRepository contactRepository;
	
    @Autowired
    public void setProductRepository(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
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

}
