import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CustomerDTO } from '../view-accounts/CustomerDTO';


@Injectable({
  providedIn: 'root'
})
export class CreateCustService {

  constructor(private http: HttpClient) { }

  createCustomer(customer: CustomerDTO) {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json'
      })
    };

    return this.http.post('http://localhost:8080/createCustomer', customer, httpOptions);
  }
}
