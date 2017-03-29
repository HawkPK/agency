package pl.hawk.repository;

import org.springframework.data.repository.CrudRepository;

import pl.hawk.entities.Contact;
import pl.hawk.entities.Subcategory;

public interface SubcategoryRepository extends CrudRepository<Subcategory, Integer> {

}
