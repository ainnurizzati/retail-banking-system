import { Component } from '@angular/core';
import { ViewAccountsService } from './view-accounts.service';
import { CustomerDTO } from '../view-accounts/CustomerDTO';
import { AccountInfoDTO } from 'src/app/customer/accounts/account-info-dto';
import { AccountService } from 'src/app/customer/accounts/accounts.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-view-accounts',
  templateUrl: './view-accounts.component.html',
  styleUrls: ['./view-accounts.component.css']
})
export class ViewAccountsComponent {
  customer: CustomerDTO = new CustomerDTO;
  customerId: number = 0;
  accounts: any;

  constructor(private custService: ViewAccountsService, private http: HttpClient) { }

  ngOnInit() {
  }

  searchCustomer() {
    this.custService.getCustomerDetails(this.customerId)
      .subscribe(customer => this.customer = customer);
  }

  getAccounts() {
    this.http.get(`http://localhost:8080/getAccounts/${this.customerId}`)
    .subscribe(data => {
      this.accounts = data;
    });
  }

}

