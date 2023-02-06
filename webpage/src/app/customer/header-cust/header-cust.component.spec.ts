import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HeaderCustComponent } from './header-cust.component';

describe('HeaderCustComponent', () => {
  let component: HeaderCustComponent;
  let fixture: ComponentFixture<HeaderCustComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HeaderCustComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HeaderCustComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
