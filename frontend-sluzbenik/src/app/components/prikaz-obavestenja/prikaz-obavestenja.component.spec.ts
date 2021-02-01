import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrikazObavestenjaComponent } from './prikaz-obavestenja.component';

describe('PrikazObavestenjaComponent', () => {
  let component: PrikazObavestenjaComponent;
  let fixture: ComponentFixture<PrikazObavestenjaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PrikazObavestenjaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PrikazObavestenjaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
