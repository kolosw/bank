package bank.service;

import bank.dto.BankAccountCurrencyDto;
import bank.entities.BankAccountCurrency;
import bank.entities.BankAccountCurrencyId;
import bank.mapper.BankAccountCurrencyMapper;
import bank.repository.BankAccountCurrencyRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BankAccountCurrencyService {
    private final BankAccountCurrencyRepository repository;

    private final BankAccountService bankAccountService;

    private final CurrencyService currencyService;
    private final BankAccountCurrencyMapper bankAccountCurrencyMapper;

    public BankAccountCurrencyService(BankAccountCurrencyRepository repository, BankAccountService bankAccountService,
                              CurrencyService currencyService, BankAccountCurrencyMapper bankAccountCurrencyMapper) {
        this.repository = repository;
        this.bankAccountService = bankAccountService;
        this.currencyService = currencyService;
        this.bankAccountCurrencyMapper = bankAccountCurrencyMapper;
    }
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
