package bank.repository;

import bank.entities.BankAccountCurrency;
import bank.entities.BankAccountCurrencyId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountCurrencyRepository extends JpaRepository<BankAccountCurrency, BankAccountCurrencyId> {
}
