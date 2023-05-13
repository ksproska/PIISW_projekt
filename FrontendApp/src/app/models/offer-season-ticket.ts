export interface OfferSeasonTicket {
  id: number;
  concession: string;
  price: number;
  validityLengthInDays: string;
}

export enum SeasonTicketDuration{
  WEEK= "A week (7 days)",
  MONTH = "A month (31 days)",
  SEMESTER = "A semester (182 days)",
  YEAR = "A year (365 days)",
}

