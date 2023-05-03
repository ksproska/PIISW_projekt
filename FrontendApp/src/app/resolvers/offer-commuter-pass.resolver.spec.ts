import { TestBed } from '@angular/core/testing';

import { OfferCommuterPassResolver } from './offer-commuter-pass.resolver';

describe('OfferCommuterPassResolver', () => {
  let resolver: OfferCommuterPassResolver;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    resolver = TestBed.inject(OfferCommuterPassResolver);
  });

  it('should be created', () => {
    expect(resolver).toBeTruthy();
  });
});
