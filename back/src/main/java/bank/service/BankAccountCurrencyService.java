package bank.service;

import bank.dto.BankAccountCurrencyDto;
import bank.entities.BankAccountCurrency;
import bank.entities.BankAccountCurrencyId;
import bank.mapper.BankAccountCurrencyMapper;
import bank.repository.BankAccountCurrencyRepository;
import bank.repository.BankAccountRepository;
import bank.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BankAccountCurrencyService {
    @Autowired
    BankAccountCurrencyRepository repository;
    @Autowired
    CurrencyRepository currencyRepository;
    @Autowired
    BankAccountRepository bankAccountRepository;
    @Autowired BankAccountCurrencyMapper bankAccountCurrencyMapper;

    public void createWithIds(Integer accountId, Integer currencyId)
    {
        repository.save(new BankAccountCurrency(bankAccountRepository.getReferenceById(accountId),
                currencyRepository.getReferenceById(currencyId)));
    }
    public void create(BankAccountCurrencyDto dto)
    {
        repository.save(bankAccountCurrencyMapper.toEntity(dto));
    }
    public BankAccountCurrencyDto getById(int accountId, int currencyId)
    {
        BankAccountCurrency bankAccountCurrency = repository.getReferenceById(new BankAccountCurrencyId(accountId,currencyId));
        return bankAccountCurrencyMapper.toDto(bankAccountCurrency);
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
