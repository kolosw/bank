package bank.service;

import bank.dto.CurrencyDto;
import bank.entities.Currency;
import bank.mapper.CurrencyMapper;
import bank.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyService {
    @Autowired
    CurrencyRepository currencyRepository;

    public void create(CurrencyDto currencyDto)
    {
        currencyRepository.save(CurrencyMapper.toEntity(currencyDto));
    }
    public CurrencyDto getById(int i)
    {
        Currency currency = currencyRepository.getReferenceById(i);
        return CurrencyMapper.toDto(currency);
    }
    public void deleteById(int i)
    {
        currencyRepository.delete(currencyRepository.getReferenceById(i));
    }
    public void update (Integer id, CurrencyDto newCurrency)
    {
        Currency currency = currencyRepository.getReferenceById(id);
        if(newCurrency.getName() != null)
            currency.setName(newCurrency.getName());
        if(newCurrency.getShortname() != null)
            currency.setShortname(newCurrency.getShortname());
        if(newCurrency.getSymbol() != null)
            currency.setSymbol(newCurrency.getSymbol());
        currencyRepository.save(currency);
    }
    public List<Currency> getCurrencyList()
    {
        return currencyRepository.findAll();
    }
}
