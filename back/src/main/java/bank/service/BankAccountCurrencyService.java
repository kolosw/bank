package bank.service;

import bank.dto.BankAccountCurrencyDto;
import bank.dto.BankAccountDto;
import bank.entities.BankAccount;
import bank.entities.BankAccountCurrency;
import bank.entities.BankAccountCurrencyId;
import bank.entities.User;
import bank.repository.BankAccountCurrencyRepository;
import bank.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    public void update (Integer accountId, Integer currencyId, BankAccountCurrencyDto dto)
    {
        BankAccountCurrency bankAccountCurrency = repository.getReferenceById(new BankAccountCurrencyId(accountId,currencyId));
        if(dto.getAccount() != null)
            bankAccountCurrency.setAccount(dto.getAccount());
        if(dto.getCurrency() != null)
            bankAccountCurrency.setCurrency(dto.getCurrency());
        repository.save(bankAccountCurrency);
    }
    public List<BankAccountCurrencyDto> getAccountCurrencyList()
    {
        List<BankAccountCurrencyDto> dto = new ArrayList<>();
        for(BankAccountCurrency bankAccountCurrency : repository.findAll())
            dto.add(new BankAccountCurrencyDto(bankAccountCurrency.getAccount(),bankAccountCurrency.getCurrency()));
        return dto;
    }
}
