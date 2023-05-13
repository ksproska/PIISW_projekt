export interface OfferCommuterPass {
  id: number;
  concession: string;
  price: number;
  validityLengthInMinutes: string;
}

export enum CommuterPassDuration{
  QUARTER= "15 minute",
  HALF_HOUR = "30 minutes",
  HOUR = "An hour",
  DAY = "24 hours",
}
