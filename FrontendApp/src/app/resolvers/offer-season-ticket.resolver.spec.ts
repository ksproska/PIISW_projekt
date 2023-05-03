import { TestBed } from '@angular/core/testing';

import { OfferSeasonTicketResolver } from './offer-season-ticket.resolver';

describe('OfferSeasonTicketResolver', () => {
  let resolver: OfferSeasonTicketResolver;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    resolver = TestBed.inject(OfferSeasonTicketResolver);
  });

  it('should be created', () => {
    expect(resolver).toBeTruthy();
  });
});
