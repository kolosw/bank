package bank.repository;

import bank.entities.Currency;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class CurrenciesRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Transactional
    public void save(Currency currency) {
        entityManager.persist(currency);
    }

    @Transactional
    public Currency getById(int id) {
        return entityManager.find(Currency.class, id);
    }

    public void update(Currency currency) {
        entityManager.merge(currency);
    }
    public void delete(Currency currency) {
        entityManager.remove(currency);
    }
}
