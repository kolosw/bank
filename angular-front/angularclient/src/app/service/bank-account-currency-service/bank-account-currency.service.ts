import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { BankAccountCurrency } from '../../model/bank-account-currency';
import { Observable } from 'rxjs';

@Injectable()
export class BankAccountCurrencyService {

  private accountCurrencyUrl: string;

  constructor(private http: HttpClient) {
    this.accountCurrencyUrl = 'http://localhost:8080/accountcurrency';
  }

  public findAll(): Observable<BankAccountCurrency[]> {
    return this.http.get<BankAccountCurrency[]>(this.accountCurrencyUrl);
  }

  public save(bankAccountCurrency : BankAccountCurrency) {
    return this.http.post<BankAccountCurrency>(this.accountCurrencyUrl, bankAccountCurrency);
  }
  public delete(accountId: number, currencyId: number)
  {
  const url = `${this.accountCurrencyUrl}/${accountId}/${currencyId}`;
  return this.http.delete<number>(url);
  }

}
