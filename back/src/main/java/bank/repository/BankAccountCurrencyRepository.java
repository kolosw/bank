package bank.repository;

import bank.entities.BankAccountCurrency;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountCurrencyRepository extends JpaRepository<BankAccountCurrency, Integer> {
}
