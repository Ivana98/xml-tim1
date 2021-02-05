import { TestBed } from '@angular/core/testing';

import { ZalbeService } from './zalbe.service';

describe('ZalbeService', () => {
  let service: ZalbeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ZalbeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
