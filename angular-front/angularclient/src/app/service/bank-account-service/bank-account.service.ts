import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { BankAccount } from '../../model/bank-account';
import { Observable } from 'rxjs';

@Injectable()
export class BankAccountService {

  private readonly accountUrl: string;

  constructor(private http: HttpClient) {
    this.accountUrl = 'http://localhost:8080/account';
  }

  public findAll(): Observable<BankAccount[]> {
    return this.http.get<BankAccount[]>(this.accountUrl);
  }

  public save(account: BankAccount) {
    return this.http.post<BankAccount>(this.accountUrl, account);
  }

  public getById(id : number)
  {
    const url = `${this.accountUrl}/${id}`;
    return this.http.get<BankAccount>(url);
  }

  public delete(accountId: number) {
  const url = `${this.accountUrl}/${accountId}`;
  return this.http.delete<number>(url);
  }

  public update(account: BankAccount) {
    const url = `${this.accountUrl}/${account.id}`;
    return this.http.put<BankAccount>(url,account);
  }
}
