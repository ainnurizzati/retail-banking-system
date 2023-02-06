import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { AccountInfoDTO } from './account-info-dto';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class AccountService {

  private accountsUrl = 'http://localhost:8080/getAccounts/';  // URL to web api

  constructor(private http: HttpClient) { }

  getAccountsByCustomerId(customerId: number): Observable<AccountInfoDTO[]> {
    const url = `${this.accountsUrl}${customerId}`;
    return this.http.get<AccountInfoDTO[]>(url, httpOptions);
  }
}
