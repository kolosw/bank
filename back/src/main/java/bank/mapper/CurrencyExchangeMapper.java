package bank.mapper;

import bank.dto.CurrencyExchangeDto;
import bank.entities.CurrencyExchange;

public class CurrencyExchangeMapper {

    public static CurrencyExchangeDto toDto(CurrencyExchange currencyExchange) {
        CurrencyExchangeDto currencyExchangeDto = new CurrencyExchangeDto();
        currencyExchangeDto.setId(currencyExchange.getId());
        currencyExchangeDto.setAmount(currencyExchange.getAmount());
        currencyExchangeDto.setFrom(currencyExchange.getFrom());
        currencyExchangeDto.setTo(currencyExchange.getTo());
        return currencyExchangeDto;
    }

    public static CurrencyExchange toEntity(CurrencyExchangeDto currencyExchangeDto) {
        CurrencyExchange currencyExchange = new CurrencyExchange();
        if(currencyExchangeDto.getId()!=null)
            currencyExchange.setId(currencyExchangeDto.getId());
        currencyExchange.setAmount(currencyExchangeDto.getAmount());
        currencyExchange.setFrom(currencyExchangeDto.getFrom());
        currencyExchange.setTo(currencyExchangeDto.getTo());
        return currencyExchange;
    }
}
