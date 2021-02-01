import { ComponentFixture, TestBed } from '@angular/core/testing';

import { KreiranjeZalbeComponent } from './kreiranje-zalbe.component';

describe('KreiranjeZalbeComponent', () => {
  let component: KreiranjeZalbeComponent;
  let fixture: ComponentFixture<KreiranjeZalbeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ KreiranjeZalbeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(KreiranjeZalbeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
