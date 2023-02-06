import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Accounts } from 'src/app/customer/accounts/accounts';
import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CreateAccService {

  private createAccountUrl = 'http://localhost:8080/createAccount/1';

  constructor(private http: HttpClient) { }

  createAccount(account: Accounts): Observable<Accounts> {
    return this.http.post<Accounts>(this.createAccountUrl, account)
      .pipe(
        catchError(this.handleError<Accounts>('createAccount'))
      );
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);
      return of(result as T);
    };
  }
}

