package app.service;

import app.entity.Category;
import app.entity.Product;
import app.repo.CategoryRepo;
import app.repo.ProductRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class CategoryService {

    private final CategoryRepo categoryRepo;

    private List<Category> getChilds(long id){
        return categoryRepo.findAllByParentId(id);
    }

    public List<Category> getAll(){
        List<Category> childs = new ArrayList<>();
        List<Category> categoryList = categoryRepo
                .findAllByParentIsNotNull();
        categoryList.forEach(cat -> cat.setSubCategory(getChilds(cat.getId())));
        for (Category cat : categoryList) {
            cat.setSubCategory(getChilds(cat.getId()));
            childs.addAll(getChilds(cat.getId()));
        }
        categoryList.removeAll(childs);
        return categoryList;
    }

    public Category getById(long id){
        return categoryRepo.findById(id).get();
    }
}
