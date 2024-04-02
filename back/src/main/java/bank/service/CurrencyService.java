package bank.service;

import bank.dto.CurrencyDto;
import bank.entities.Currency;
import bank.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyService {
    @Autowired
    CurrencyRepository currencyRepository;

    public void create(CurrencyDto currencyDto)
    {
        Currency currency = new Currency(currencyDto.getName(),currencyDto.getShortname(),currencyDto.getSymbol());
        currencyRepository.save(currency);
    }
    public CurrencyDto getById(int i)
    {
        Currency currency = currencyRepository.getReferenceById(i);
        return new CurrencyDto(currency.getId(), currency.getName(), currency.getShortname(), currency.getSymbol());
    }
    public void deleteById(int i)
    {
        currencyRepository.delete(currencyRepository.getReferenceById(i));
    }
    public void update (CurrencyDto newCurrency)
    {
        Currency currency = new Currency(newCurrency.getId(), newCurrency.getName(), newCurrency.getShortname(), newCurrency.getSymbol());
        currencyRepository.save(currency);
    }
}
