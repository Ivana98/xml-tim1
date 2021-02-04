import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ZalbaNaCutanjeComponent } from './zalba-na-cutanje.component';

describe('ZalbaNaCutanjeComponent', () => {
  let component: ZalbaNaCutanjeComponent;
  let fixture: ComponentFixture<ZalbaNaCutanjeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ZalbaNaCutanjeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ZalbaNaCutanjeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
