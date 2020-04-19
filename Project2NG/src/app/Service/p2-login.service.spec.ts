import { TestBed } from '@angular/core/testing';

import { P2LoginService } from './p2-login.service';

describe('P2LoginService', () => {
  let service: P2LoginService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(P2LoginService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
