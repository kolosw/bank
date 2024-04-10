import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Currency } from '../../model/currency';
import { Observable } from 'rxjs';

@Injectable()
export class CurrencyService {

  private readonly currencyUrl: string;

  constructor(private http: HttpClient) {
    this.currencyUrl = 'http://localhost:8080/currency';
  }

  public findAll(): Observable<Currency[]> {
    return this.http.get<Currency[]>(this.currencyUrl);
  }
  public getById(id : number)
  {
    const url = `${this.currencyUrl}/${id}`;
    return this.http.get<Currency>(url);
  }
  public save(currency: Currency) {
    return this.http.post<Currency>(this.currencyUrl, currency);
  }
  public delete(currencyId : number)
  {
  const url = `${this.currencyUrl}/${currencyId}`;
  return this.http.delete<number>(url);
  }
  public update(currency : Currency)
  {
    const url = `${this.currencyUrl}/${currency.id}`;
    return this.http.put<Currency>(url,currency);
  }
}
