package app.repo;

import app.entity.Category;
import org.hibernate.annotations.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {

    List<Category> findByParentIsNull();

    List<Category> findAllByParentId(long id);

    Optional<Category> findById(long id);
}
