import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PodnosenjeObavestenjaComponent } from './podnosenje-obavestenja.component';

describe('PodnosenjeObavestenjaComponent', () => {
  let component: PodnosenjeObavestenjaComponent;
  let fixture: ComponentFixture<PodnosenjeObavestenjaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PodnosenjeObavestenjaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PodnosenjeObavestenjaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
