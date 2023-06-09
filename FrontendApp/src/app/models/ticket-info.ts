export interface TicketInfo {
  ticketId: number;
  datetime: Date;
  activeTill: Date;
  price: number;
  concession: string;
  type: string;
  tramId: string;
  active: boolean;
}
