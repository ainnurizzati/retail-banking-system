import { Component } from '@angular/core';
import { CustomerDTO } from '../view-accounts/CustomerDTO';
import { CreateCustService } from './create-cust.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-cust',
  templateUrl: './create-cust.component.html',
  styleUrls: ['./create-cust.component.css']
})
export class CreateCustComponent {
  customerDTO: CustomerDTO = new CustomerDTO();

  constructor(private customerService: CreateCustService, private router: Router) { }

  ngOnInit() {
  }

  createCustomer() {
    this.customerService.createCustomer(this.customerDTO)
      .subscribe(
        data => {
          // show success message
          this.showSuccessMessage();
          // navigate to another page
          // this.router.navigate(['/accounts']);
        },
        error => {
          // handle error
          this.handleError(error);
        }
      );

  }

  showSuccessMessage() {
    console.log("successful!")
    return (`Customer Created!`);
  }

  handleError(error: any) {
    throw new Error('Method not implemented.');
  }


}

