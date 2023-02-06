import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class StatementService {

  private baseUrl = 'http://localhost:8080/getAccountStatement';

  constructor(private http: HttpClient) { }

  getStatement(accountId: number, fromDate: string, toDate: string) {
    let params = new HttpParams()
      .set('fromDate', fromDate)
      .set('toDate', toDate);

    return this.http.get<any>(`${this.baseUrl}/${accountId}`, { params });
  }
}

// `/getAccountStatement/${accountId}?fromDate=${fromDate}&toDate=${toDate}`
