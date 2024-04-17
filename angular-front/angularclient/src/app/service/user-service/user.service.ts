import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../../model/user';
import { CrudService} from '../crud-service/crud.service'
import { Observable } from 'rxjs';

@Injectable()
export class UserService extends CrudService{

  constructor(http : HttpClient) {
    super(http);
    this.setUpUrl('/users')
  }
}
