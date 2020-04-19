import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SeereviewComponent } from './seereview.component';

describe('SeereviewComponent', () => {
  let component: SeereviewComponent;
  let fixture: ComponentFixture<SeereviewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SeereviewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SeereviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
