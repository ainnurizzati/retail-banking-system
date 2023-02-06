import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Accounts } from '../accounts/accounts';

@Injectable({
  providedIn: 'root'
})

export class TransferService {

  constructor(private http: HttpClient) {}

  getAccounts(customerId: number) {
    return this.http.get<Accounts[]>(`http://localhost:8080/getAccounts/${customerId}`);
  }

  transfer(sourceAccountId: number, targetAccountId: number, amount: number) {
    return this.http.post<any>(`http://localhost:8080/transfer`, {
      sourceAccountId,
      targetAccountId,
      amount
    });
  }
}


// export class TransferService {
//   constructor(private http: HttpClient) {}

//   transfer(sourceAccountId: number, targetAccountId: number, amount: number) {
//     const transferRequest = {
//       sourceAccountId,
//       targetAccountId,
//       amount
//     };
//     const httpOptions = {
//       headers: new HttpHeaders({ 'Content-Type': 'application/json' })
//     };

//     return this.http.post('http://localhost:8080/transfer', transferRequest, httpOptions);
//   }
// }
