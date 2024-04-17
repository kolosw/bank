import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Currency } from '../../model/currency';
import { CrudService} from '../crud-service/crud.service'
import { Observable } from 'rxjs';

@Injectable()
export class CurrencyService extends CrudService {

  constructor(http : HttpClient) {
    super(http);
    this.setUpUrl('/currency')
  }
}
