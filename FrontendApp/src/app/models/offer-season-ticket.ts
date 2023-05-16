export interface OfferSeasonTicket {
  id: number;
  concession: string;
  price: number;
  validityLengthInDays: string;
}

export enum SeasonCommuterTicketDuration{
  WEEK= "A week (7\xa0days)",
  MONTH = "A month (31\xa0days)",
  SEMESTER = "A semester (182\xa0days)",
  YEAR = "A year (365\xa0days)",
  QUARTER= "15 minute",
  HALF_HOUR = "30 minutes",
  HOUR = "An hour",
  DAY = "24 hours",
  SINGLE = "Single ticket"
}

