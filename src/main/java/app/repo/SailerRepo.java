package app.repo;

import app.entity.Sailer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SailerRepo extends JpaRepository <Sailer, Long> {
}
