package pl.hawk.controllers;

import java.sql.SQLException;
import java.util.regex.Pattern;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.hawk.entities.Contact;
import pl.hawk.services.ContactService;

@Controller
public class ContactController {

	private ContactService contactService;

	@Autowired
	public void setContactService(ContactService contactService) {
		this.contactService = contactService;
	}

	/**
	 * Pokazanie wszystkich kontaktow
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/contacts", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("contacts", contactService.listAllContacts());
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
	public String showContact(@PathVariable Integer id, Model model) {
		model.addAttribute("contact", contactService.getContactById(id));
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
	public String edit(@PathVariable Integer id, Model model) {
		model.addAttribute("contact", contactService.getContactById(id));
		model.addAttribute("category", contactService.listAllCategory());
		model.addAttribute("subcategory", contactService.listAllSubcategory());
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
		model.addAttribute("contact", new Contact());
		model.addAttribute("category", contactService.listAllCategory());
		model.addAttribute("subcategory", contactService.listAllSubcategory());
		return "contactform";
	}

	/**
	 * Zapisanie contact do bazy danych
	 * 
	 * @param contact
	 * @return
	 */
	@RequestMapping(value = "contact", method = RequestMethod.POST)
	public String saveProduct(@Valid Contact contact, BindingResult bindingResult, Model model) {
		
		boolean isEmailNotUnique = true;

		try {
			if (bindingResult.hasErrors()) {
				model.addAttribute("category", contactService.listAllCategory());
				System.out.println(bindingResult.getFieldError());
			} else {
				contactService.saveContact(contact);
				return "redirect:/contact/" + contact.getId();
			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.addAttribute("error", isEmailNotUnique);
		}

		return "contactform";
	}

	/**
	 * Usuniecie kontaktu
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("contact/delete/{id}")
	public String delete(@PathVariable Integer id) {
		contactService.deleteContact(id);
		return "redirect:/contacts";
	}
}
