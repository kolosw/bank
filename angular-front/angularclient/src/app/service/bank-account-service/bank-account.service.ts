import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { BankAccount } from '../../model/bank-account';
import { CrudService} from '../crud-service/crud.service'
import { Observable } from 'rxjs';

@Injectable()
export class BankAccountService extends CrudService{

  constructor(http : HttpClient) {
    super(http);
    this.setUpUrl('/account')
  }
}
