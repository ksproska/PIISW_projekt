import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ValidityCheckComponent } from './validity-check.component';

describe('ValidityCheckComponent', () => {
  let component: ValidityCheckComponent;
  let fixture: ComponentFixture<ValidityCheckComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ValidityCheckComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ValidityCheckComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
