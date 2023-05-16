import {Component, OnDestroy, OnInit} from '@angular/core';
import {OfferSingleTicket} from "../../../models/offer-single-ticket";
import {OfferSeasonTicket, SeasonCommuterTicketDuration} from "../../../models/offer-season-ticket";
import {OfferCommuterPass} from "../../../models/offer-commuter-pass";
import {ActivatedRoute} from "@angular/router";
import {FormBuilder} from "@angular/forms";
import {Subscription} from "rxjs";
import {TicketServiceService} from "../../../services/ticket-service.service";

@Component({
  selector: 'app-shop',
  templateUrl: './shop.component.html',
  styleUrls: ['./shop.component.css']
})
export class ShopComponent implements OnInit, OnDestroy {
  private subscriptions: Subscription[] = [];

  constructor(private activatedRoute: ActivatedRoute,
              private formBuilder: FormBuilder,
              private readonly service: TicketServiceService
  ) {
    this.offerSingleTickets = this.activatedRoute.snapshot.data['offerSingleTickets'];
    this.offerSeasonTickets = this.activatedRoute.snapshot.data['offerSeasonTickets'];
    this.offerCommuterPass = this.activatedRoute.snapshot.data['offerCommuterPass'];
  }

  private readonly offerSingleTickets: OfferSingleTicket[]

  private readonly offerSeasonTickets: OfferSeasonTicket[]

  private readonly offerCommuterPass: OfferCommuterPass[]

  enumSeasonCommuter = <any>SeasonCommuterTicketDuration

  seasonTickets: OfferSeasonTicket[] | undefined

  commuterPass: OfferCommuterPass[] | undefined
  selectedSeasonTicket: OfferSeasonTicket | undefined
  selectedCommuterTicket: OfferCommuterPass | undefined
  selectedSingleTicket: OfferSingleTicket | undefined
  ticketForm = this.formBuilder.group({
    concession: [false],
    seasonTicketLength: [''],
    commuterTicketLength: [''],
    tramId: [''],
  });

  ngOnInit(): void {
    this.subscriptions.push(
      this.concession.valueChanges.subscribe({
        next: () => {
          this.filterByConcession()
          this.filterByLengthSeason()
          this.filterByLengthCommuter()
        }
      }),
      this.seasonTicketLength.valueChanges.subscribe({
        next: () => {
          this.filterByLengthSeason()
        }
      }),
      this.commuterTicketLength.valueChanges.subscribe({
        next: () => this.filterByLengthCommuter()
      }),
    )
    this.concession.setValue(false)
  }

  ngOnDestroy() {
    this.subscriptions.forEach((subscription) => subscription.unsubscribe());
  }

  filterByConcession(): void {
    const concessionType = this.concession.value ? "REDUCED_FARE" : "NORMAL";
    const filterByConcessionType = (tickets: any[]) =>
      tickets?.filter(obj => obj.concession === concessionType);

    this.seasonTickets = filterByConcessionType(this.offerSeasonTickets);
    this.commuterPass = filterByConcessionType(this.offerCommuterPass);
    this.selectedSingleTicket = filterByConcessionType(this.offerSingleTickets).pop();
  }

  filterByLengthSeason(): void {
    this.selectedSeasonTicket = this.seasonTickets?.find(obj => {
      return obj.validityLengthInDays === this.seasonTicketLength.value
    })
  }

  filterByLengthCommuter(): void {
    this.selectedCommuterTicket = this.commuterPass?.find(obj => {
      return obj.validityLengthInMinutes === this.commuterTicketLength.value
    })
  }

  get concession() {
    return this.ticketForm.controls['concession']
  }

  get seasonTicketLength() {
    return this.ticketForm.controls['seasonTicketLength']
  }

  get commuterTicketLength() {
    return this.ticketForm.controls['commuterTicketLength']
  }

  purchaseSingleTicket() {
    // @ts-ignore
    this.service.putSingleTicket(this.selectedSingleTicket.id, 101); // TODO remove userId
  }

  purchaseSeasonTicket() {
    // @ts-ignore
    this.service.putSeasonTicket(this.selectedSeasonTicket.id, 101); // TODO remove userId
  }

  purchaseCommuterPass() {
    // @ts-ignore
    this.service.putCommuterPass(this.selectedCommuterTicket.id, 101); // TODO remove userId
  }
}
