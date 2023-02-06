import { HttpClient, HttpParams } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Statement } from './statement';
import { StatementService } from './statement.service';

@Component({
  selector: 'app-statement',
  templateUrl: './statement.component.html',
  styleUrls: ['./statement.component.css']
})

export class StatementComponent implements OnInit {
  fromDate: string = " ";
  toDate: string = " ";
  statement: any[] = [];

  constructor(private statementService: StatementService) { }

  ngOnInit() { }

  getStatement() {
    this.statementService.getStatement(1, this.fromDate, this.toDate)
      .subscribe(data => {
        this.statement = data;
      });
  }
}
