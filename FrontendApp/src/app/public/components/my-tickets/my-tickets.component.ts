import { Component } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {TicketInfo} from "../../../models/ticket-info";

@Component({
  selector: 'app-my-tickets',
  templateUrl: './my-tickets.component.html',
  styleUrls: ['./my-tickets.component.css']
})
export class MyTicketsComponent {
  ticketInfos: TicketInfo[]

  constructor(private readonly activatedRoute: ActivatedRoute) {
    this.ticketInfos = this.activatedRoute.snapshot.data['ticketInfos'];
  }
}
