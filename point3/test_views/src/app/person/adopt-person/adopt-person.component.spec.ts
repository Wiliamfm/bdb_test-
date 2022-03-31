import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdoptPersonComponent } from './adopt-person.component';

describe('AdoptPersonComponent', () => {
  let component: AdoptPersonComponent;
  let fixture: ComponentFixture<AdoptPersonComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdoptPersonComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdoptPersonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
