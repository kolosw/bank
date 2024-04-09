package bank.service;

import bank.dto.BankAccountCurrencyDto;
import bank.entities.BankAccountCurrency;
import bank.entities.BankAccountCurrencyId;
import bank.mapper.BankAccountCurrencyMapper;
import bank.mapper.BankAccountMapper;
import bank.mapper.CurrencyMapper;
import bank.repository.BankAccountCurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BankAccountCurrencyService {
    @Autowired
    BankAccountCurrencyRepository repository;
    @Autowired
    BankAccountService bankAccountService;
    @Autowired
    CurrencyService currencyService;
    @Autowired BankAccountCurrencyMapper bankAccountCurrencyMapper;

    public void create(BankAccountCurrencyDto dto)
    {
        dto.setAccount(bankAccountService.getById(dto.getAccount().getId()));
        dto.setCurrency(currencyService.getById(dto.getCurrency().getId()));
        repository.save(bankAccountCurrencyMapper.toEntity(dto));
    }
    public BankAccountCurrencyDto getById(int accountId, int currencyId)
    {
        BankAccountCurrency bankAccountCurrency = repository.getReferenceById(new BankAccountCurrencyId(accountId,currencyId));
        return bankAccountCurrencyMapper.toDto(bankAccountCurrency);
    }
    public void deleteById(int accountId, int currencyId)
    {
        repository.delete(repository.getReferenceById(new BankAccountCurrencyId(accountId,currencyId)));
    }
    public void update (BankAccountCurrencyDto dto)
    {
        BankAccountCurrency bankAccountCurrency = bankAccountCurrencyMapper.toEntity(dto);
        repository.save(bankAccountCurrency);
    }
    public List<BankAccountCurrencyDto> getList()
    {
        List<BankAccountCurrencyDto> dto = new ArrayList<>();
        for(BankAccountCurrency bankAccountCurrency : repository.findAll())
            dto.add(bankAccountCurrencyMapper.toDto(bankAccountCurrency));
        return dto;
    }
}
