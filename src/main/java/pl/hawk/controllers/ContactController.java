package pl.hawk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.hawk.entities.Contact;
import pl.hawk.services.ContactService;

@Controller
public class ContactController {

	private ContactService contactService;
	
	@Autowired
	public void setContactService(ContactService contactService){
		this.contactService = contactService;
	}
	
	/**
	 * Pokazanie wszystkich kontaktow
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/contacts", method = RequestMethod.GET)
	public String list(Model model){
		model.addAttribute("contact",contactService.listAllContacts());
		System.out.println("Returning contacts:");
		return "contacts";
	}
	
	
	/**
	 * Widok ze wskazanym kontaktem
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("contact/{id}")
	public String showContact(@PathVariable Integer id, Model model){
		model.addAttribute("contact",contactService.getContactById(id));
		return "contactshow";
	}
	
	/**
	 * Edytowanie kontaktu
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("contact/edit/{id}")
	public String edit(@PathVariable Integer id, Model model){
		model.addAttribute("contact",contactService.getContactById(id));
		return "contactform";
		
	}
	
	/**
	 * Dodanie nowego kontaktu
	 * 
	 * @param model
	 * @return
	 */
    @RequestMapping("contact/new")
    public String newProduct(Model model) {
        model.addAttribute("product", new Contact());
        return "productform";
    }
    
    /**
     * Zapisanie contact do bazy danych
     * 
     * @param contact
     * @return
     */
    @RequestMapping(value = "product", method = RequestMethod.POST)
    public String saveProduct(Contact contact) {
        contactService.saveContact(contact);
        return "redirect:/product/" + contact.getId();
    }
	
    /**
     * Usuniecie kontaktu
     * 
     * @param id
     * @return
     */
    @RequestMapping("product/delete/{id}")
    public String delete(@PathVariable Integer id) {
        contactService.deleteContact(id);
        return "redirect:/contacts";
    }
}
