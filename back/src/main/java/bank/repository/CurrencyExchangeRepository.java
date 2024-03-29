package bank.repository;

import bank.entities.CurrencyExchange;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class CurrencyExchangeRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Transactional
    public void save(CurrencyExchange currencyExchange) {
        entityManager.persist(currencyExchange);
    }

    public CurrencyExchange getById(int id) {
        return entityManager.find(CurrencyExchange.class, id);
    }

    public void update(CurrencyExchange currencyExchange) {
        entityManager.merge(currencyExchange);
    }
    public void delete(CurrencyExchange currencyExchange) {
        entityManager.remove(currencyExchange);
    }
}
