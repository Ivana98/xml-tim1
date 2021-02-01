import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrikazZalbeComponent } from './prikaz-zalbe.component';

describe('PrikazZalbeComponent', () => {
  let component: PrikazZalbeComponent;
  let fixture: ComponentFixture<PrikazZalbeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PrikazZalbeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PrikazZalbeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
