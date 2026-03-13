import { TestBed } from '@angular/core/testing';

import { LocatorServiceService } from './locator-service.service';

describe('LocatorServiceService', () => {
  let service: LocatorServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LocatorServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
