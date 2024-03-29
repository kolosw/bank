package bank.repository;

import bank.entities.Beneficiary;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class BeneficiaryRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Transactional
    public void save(Beneficiary beneficiary) {
        entityManager.persist(beneficiary);
    }

    public Beneficiary getById(int id) {
        return entityManager.find(Beneficiary.class, id);
    }

    public void update(Beneficiary beneficiary) {
        entityManager.merge(beneficiary);
    }
    public void delete(Beneficiary beneficiary) {
        entityManager.remove(beneficiary);
    }
}
