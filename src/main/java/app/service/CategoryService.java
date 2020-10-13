package app.service;

import app.entity.Category;
import app.repo.CategoryRepo;
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
}
