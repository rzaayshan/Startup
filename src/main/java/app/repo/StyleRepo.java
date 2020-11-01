package app.repo;

import app.entity.Style;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StyleRepo extends JpaRepository<Style, Long> {
}
