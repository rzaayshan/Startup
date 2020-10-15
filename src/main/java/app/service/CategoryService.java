package app.service;

import app.entity.Category;
import app.entity.Product;
import app.repo.CategoryRepo;
import app.repo.ProductRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {

    private final CategoryRepo categoryRepo;

    public List<Category> getParentCategories(){
        return categoryRepo.findByParentIsNull();
    }

    public List<Category> getChilds(long id){
        return categoryRepo.findAllByParentId(id);
    }

    public List<Category> getById(){
        return categoryRepo.findByParentIsNull();
    }
}
