import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateCustComponent } from './create-cust.component';

describe('CreateCustComponent', () => {
  let component: CreateCustComponent;
  let fixture: ComponentFixture<CreateCustComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateCustComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreateCustComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
