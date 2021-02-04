import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ZalbaNaOdbijanjeComponent } from './zalba-na-odbijanje.component';

describe('ZalbaNaOdbijanjeComponent', () => {
  let component: ZalbaNaOdbijanjeComponent;
  let fixture: ComponentFixture<ZalbaNaOdbijanjeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ZalbaNaOdbijanjeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ZalbaNaOdbijanjeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
