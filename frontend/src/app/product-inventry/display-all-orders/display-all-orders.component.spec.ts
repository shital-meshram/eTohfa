import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DisplayAllOrdersComponent } from './display-all-orders.component';

describe('DisplayAllOrdersComponent', () => {
  let component: DisplayAllOrdersComponent;
  let fixture: ComponentFixture<DisplayAllOrdersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DisplayAllOrdersComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DisplayAllOrdersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
