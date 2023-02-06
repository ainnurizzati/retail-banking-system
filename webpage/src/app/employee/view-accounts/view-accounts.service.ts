import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { catchError, map } from 'rxjs/operators';
import { CustomerDTO } from './CustomerDTO';
import { AccountInfoDTO } from 'src/app/customer/accounts/account-info-dto';
import { Observable } from 'rxjs/internal/Observable';
import { throwError } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class ViewAccountsService {
  private customerUrl = 'http://localhost:8080/customer/';


  constructor(private http: HttpClient) { }

  getCustomerDetails(customerId: number) {
    return this.http.get<CustomerDTO>(this.customerUrl + customerId)
      .pipe(
        map(res => res),
        catchError(this.handleError)
      );
  }

  private handleError(error: HttpErrorResponse) {
    if (error.error instanceof ErrorEvent) {
      console.error('An error occurred:', error.error.message);
    } else {
      console.error(
        `Backend returned code ${error.status}, ` +
        `body was: ${error.error}`);
    }
    return throwError('Something bad happened; please try again later.');
  }
}
