package app.repo;

import app.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SellerRepo extends JpaRepository <Seller, Long> {
    Optional<Seller> findSellerByCompany(String company);

    Optional<Seller> findSellerByEmail(String email);
}
