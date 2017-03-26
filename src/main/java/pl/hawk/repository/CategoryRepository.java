package pl.hawk.repository;

import org.springframework.data.repository.CrudRepository;

import pl.hawk.entities.Category;

public interface CategoryRepository extends CrudRepository<Category, Integer>{

}
