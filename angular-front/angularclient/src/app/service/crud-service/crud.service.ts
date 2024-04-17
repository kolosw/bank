import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class CrudService {

  protected url: string;

  constructor(protected http: HttpClient) {
  this.url = 'http://localhost:8080';
  }

  public setUpUrl(url : string) {
    this.url += url;
  }

  public findAll(): Observable<any[]> {
    console.log('inside findAll');
    return this.http.get<any[]>(this.url);
  }

  public getById(id : number) {
      console.log('inside getById');
    const url = `${this.url}/${id}`;
    return this.http.get<any>(url);
  }

  public save(body : any) {
      console.log('inside save');
    return this.http.post<any>(this.url, body);
  }

  public delete(id : number) {
      console.log('inside delete');
  const url = `${this.url}/${id}`;
  return this.http.delete<number>(url);
  }

  public update(body : any) {
      console.log('inside update');
    const url = `${this.url}/${body.id}`;
    return this.http.put<any>(url,body);
  }
}
