import { TestBed } from '@angular/core/testing';

import { OfferSingleTicketResolver } from './offer-single-ticket.resolver';

describe('OfferSingleTicketResolver', () => {
  let resolver: OfferSingleTicketResolver;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    resolver = TestBed.inject(OfferSingleTicketResolver);
  });

  it('should be created', () => {
    expect(resolver).toBeTruthy();
  });
});
