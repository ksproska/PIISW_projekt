import { Component } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {TicketInfo} from "../../../models/ticket-info";
import {SeasonCommuterTicketDuration} from "../../../models/offer-season-ticket";
import {tick} from "@angular/core/testing";

@Component({
  selector: 'app-my-tickets',
  templateUrl: './my-tickets.component.html',
  styleUrls: ['./my-tickets.component.css']
})
export class MyTicketsComponent {
  ticketInfos: TicketInfo[]
  enumSeasonCommuter = <any>SeasonCommuterTicketDuration

  constructor(private readonly activatedRoute: ActivatedRoute) {
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
}
