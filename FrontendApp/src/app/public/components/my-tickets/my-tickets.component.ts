import { Component } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {TicketInfo} from "../../../models/ticket-info";
import {SeasonCommuterTicketDuration} from "../../../models/offer-season-ticket";
import {TicketServiceService} from "../../../services/ticket-service.service";

@Component({
  selector: 'app-my-tickets',
  templateUrl: './my-tickets.component.html',
  styleUrls: ['./my-tickets.component.css']
})
export class MyTicketsComponent {
  ticketInfos: TicketInfo[]
  enumSeasonCommuter = <any>SeasonCommuterTicketDuration

  constructor(private readonly activatedRoute: ActivatedRoute,
              private readonly service: TicketServiceService
  ) {
    this.ticketInfos = this.activatedRoute.snapshot.data['ticketInfos'];
    console.log(this.ticketInfos)
  }


  classify(type: string): string{
    if(type == "WEEK" || type ==  "MONTH" || type ==  "SEMESTER" || type ==  "YEAR")
      return 'SEASON'
    if(type == "QUARTER" || type == "HALF_HOUR" || type == "HOUR" || type == "DAY")
      return 'COMMUTER'
    if(type == "SINGLE")
      return 'SINGLE'
    return ""
  }

  clip(ticketId: number) {
    this.service.activeTicket(ticketId) // TODO: tramId required for SingleTicket
  }
}
