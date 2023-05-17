import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {TicketInfo} from "../../../models/ticket-info";
import {SeasonCommuterTicketDuration} from "../../../models/offer-season-ticket";
import {TicketServiceService} from "../../../services/ticket-service.service";
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-my-tickets',
  templateUrl: './my-tickets.component.html',
  styleUrls: ['./my-tickets.component.css']
})
export class MyTicketsComponent implements OnInit{
  ticketInfos: TicketInfo[]
  enumSeasonCommuter = <any>SeasonCommuterTicketDuration
  tramForm?: FormGroup
  tramID?: string
  errorMsg: boolean = false
  constructor(private readonly activatedRoute: ActivatedRoute,
              private readonly service: TicketServiceService,
  ) {
    this.ticketInfos = this.activatedRoute.snapshot.data['ticketInfos'];
    console.log(this.ticketInfos)
  }

  ngOnInit(): void {
    let singleTickets = this.ticketInfos.filter(obj => {
      return obj.type == 'SINGLE'
    })

    for(let ticket of singleTickets)
      this.tramForm?.addControl('ticket'+ticket.ticketId, new FormControl('', Validators.required))
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
    let ticket = this.ticketInfos.find(obj => {
      return obj.ticketId == ticketId
    })
    if(ticket?.type == 'SINGLE' && this.tramID == null) {
      this.errorMsg = true
      return
    }
    this.errorMsg = false
    this.service.activeTicket(ticketId,this.tramID).subscribe({
      complete: () => window.location.reload()
    })
  }

}
