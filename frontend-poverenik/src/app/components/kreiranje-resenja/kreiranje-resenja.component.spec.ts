import { ComponentFixture, TestBed } from '@angular/core/testing';

import { KreiranjeResenjaComponent } from './kreiranje-resenja.component';

describe('KreiranjeResenjaComponent', () => {
  let component: KreiranjeResenjaComponent;
  let fixture: ComponentFixture<KreiranjeResenjaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ KreiranjeResenjaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(KreiranjeResenjaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
