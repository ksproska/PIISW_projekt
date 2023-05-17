export interface TicketInfo {
  ticketId: number;
  datetime: Date;
  price: number;
  concession: string;
  type: string;
  tramId: string;
  active: boolean;
}
