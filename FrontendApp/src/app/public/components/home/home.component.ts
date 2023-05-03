import {Component} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {OfferSingleTicket} from "../../../models/offer-single-ticket";
import {OfferSeasonTicket} from "../../../models/offer-season-ticket";
import {OfferCommuterPass} from "../../../models/offer-commuter-pass";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
  offerSingleTickets: OfferSingleTicket[]
  offerSeasonTickets: OfferSeasonTicket[]
  offerCommuterPass: OfferCommuterPass[]

  constructor(private readonly activatedRoute: ActivatedRoute) {
    this.offerSingleTickets = this.activatedRoute.snapshot.data['offerSingleTickets'];
    this.offerSeasonTickets = this.activatedRoute.snapshot.data['offerSeasonTickets'];
    this.offerCommuterPass = this.activatedRoute.snapshot.data['offerCommuterPass'];
  }
}
