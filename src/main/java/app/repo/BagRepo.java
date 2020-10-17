package app.repo;

import app.entity.Bag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BagRepo extends JpaRepository<Bag, Long> {
}
