package bank.service;

import bank.dto.BankAccountCurrencyDto;
import bank.dto.BankAccountDto;
import bank.entities.BankAccount;
import bank.entities.BankAccountCurrency;
import bank.entities.BankAccountCurrencyId;
import bank.repository.BankAccountCurrencyRepository;
import bank.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankAccountCurrencyService {
    @Autowired
    BankAccountCurrencyRepository repository;

    public void create(BankAccountCurrencyDto dto)
    {
        BankAccountCurrency bankAccountCurrency = new BankAccountCurrency(dto.getAccount(),dto.getCurrency());
        repository.save(bankAccountCurrency);
    }
    public BankAccountCurrencyDto getById(int accountId, int currencyId)
    {
        BankAccountCurrency bankAccountCurrency = repository.getReferenceById(new BankAccountCurrencyId(accountId,currencyId));
        return new BankAccountCurrencyDto(bankAccountCurrency.getAccount(),bankAccountCurrency.getCurrency());
    }
    public void deleteById(int accountId, int currencyId)
    {
        repository.delete(repository.getReferenceById(new BankAccountCurrencyId(currencyId,accountId)));
    }
    public void update (BankAccountCurrencyDto dto)
    {
        BankAccountCurrency bankAccountCurrency = new BankAccountCurrency(dto.getAccount(),dto.getCurrency());
        repository.save(bankAccountCurrency);
    }
}
