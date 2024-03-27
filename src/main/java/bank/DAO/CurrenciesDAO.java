package bank.DAO;

import bank.entities.Currencies;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class CurrenciesDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public void save(Currencies currency) {
        entityManager.persist(currency);
    }

    public Currencies getById(int id) {
        return entityManager.find(Currencies.class, id);
    }

    public void update(Currencies currency) {
        entityManager.merge(currency);
    }
    public void delete(Currencies currency) {
        entityManager.remove(currency);
    }
}
