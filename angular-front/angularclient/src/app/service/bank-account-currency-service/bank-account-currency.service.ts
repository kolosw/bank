import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { BankAccountCurrency } from '../../model/bank-account-currency';
import { CrudService} from '../crud-service/crud.service'
import { Observable } from 'rxjs';

@Injectable()
export class BankAccountCurrencyService extends CrudService{


  constructor(http : HttpClient) {
    super(http);
    this.setUpUrl('/accountcurrency')
  }

  public deleteAccountCurrency(accountId: number, currencyId: number) {
  const url = `${this.url}/${accountId}/${currencyId}`;
  return this.http.delete<number>(url);
  }
}
