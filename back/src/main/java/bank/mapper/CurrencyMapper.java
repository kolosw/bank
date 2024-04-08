package bank.mapper;

import bank.dto.CurrencyDto;
import bank.entities.Currency;

public class CurrencyMapper {

    public static CurrencyDto toDto(Currency currency) {
        CurrencyDto currencyDto = new CurrencyDto();
        currencyDto.setId(currency.getId());
        currencyDto.setName(currency.getName());
        currencyDto.setShortname(currency.getShortname());
        currencyDto.setSymbol(currency.getSymbol());
        return currencyDto;
    }

    public static Currency toEntity(CurrencyDto currencyDto) {
        Currency currency = new Currency();
        if(currencyDto.getId()!=null)
            currency.setId(currencyDto.getId());
        currency.setName(currencyDto.getName());
        currency.setShortname(currencyDto.getShortname());
        currency.setSymbol(currencyDto.getSymbol());
        return currency;
    }
}
