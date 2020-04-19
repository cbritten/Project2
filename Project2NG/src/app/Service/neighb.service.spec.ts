import { TestBed } from '@angular/core/testing';

import { NeighbService } from '../neighb.service';

describe('NeighbService', () => {
  let service: NeighbService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(NeighbService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
