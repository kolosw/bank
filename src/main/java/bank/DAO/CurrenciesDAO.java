package bank.DAO;

import bank.entities.Transaction;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.Currency;

public class CurrenciesDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public void save(Currency currency) {
        entityManager.persist(currency);
    }

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
