import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PersonModelComponent } from './person-model.component';

describe('PersonModelComponent', () => {
  let component: PersonModelComponent;
  let fixture: ComponentFixture<PersonModelComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PersonModelComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PersonModelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
