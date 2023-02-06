import { TestBed } from '@angular/core/testing';

import { CreateCustService } from './create-cust.service';

describe('CreateCustService', () => {
  let service: CreateCustService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CreateCustService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
