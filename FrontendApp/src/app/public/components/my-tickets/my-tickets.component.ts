import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {TicketInfo} from "../../../models/ticket-info";
import {SeasonCommuterTicketDuration} from "../../../models/offer-season-ticket";
import {TicketServiceService} from "../../../services/ticket-service.service";
import {FormArray, FormBuilder, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-my-tickets',
  templateUrl: './my-tickets.component.html',
  styleUrls: ['./my-tickets.component.css']
})
export class MyTicketsComponent implements OnInit{
  ticketInfos: TicketInfo[]
  enumSeasonCommuter = <any>SeasonCommuterTicketDuration
  ticketForm: FormGroup
  errorMsg: boolean = false
  constructor(private readonly activatedRoute: ActivatedRoute,
              private readonly service: TicketServiceService,
              private fb: FormBuilder
  ) {
    this.ticketInfos = this.activatedRoute.snapshot.data['ticketInfos'];
    this.ticketForm = this.fb.group({
      tickets: this.fb.array([])
    });
  }

  ngOnInit(): void {
    this.initializeFormArray()
  }
  initializeFormArray(): void {
    const ticketsArray = this.ticketForm.get('tickets') as FormArray;
    this.ticketInfos.forEach(() => {
      ticketsArray.push(this.fb.group({
        tramId: ['', {updateOn: 'change'}]
      }))
    });
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

  clip(ticketId: number, index: number) {
    const ticket = this.ticketInfos.find(obj => {
      return obj.ticketId == ticketId
    })

    const tramID = this.ticketForm.value.tickets[index].tramId;

    if(ticket?.type == 'SINGLE' && tramID == null) {
      this.errorMsg = true
      return
    }
    this.errorMsg = false
    this.service.activeTicket(ticketId,tramID).subscribe({
      complete: () => window.location.reload()
    })
  }

}
