import {Injectable} from '@angular/core';
import {
  Resolve,
  RouterStateSnapshot,
  ActivatedRouteSnapshot
} from '@angular/router';
import {Observable, of} from 'rxjs';
import {OfferService} from "../services/offer.service";
import {OfferSeasonTicket} from "../models/offer-season-ticket";

@Injectable({
  providedIn: 'root'
})
export class OfferSeasonTicketResolver implements Resolve<OfferSeasonTicket[]> {
  constructor(private readonly offerService: OfferService) {
  }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<OfferSeasonTicket[]> {
    return this.offerService.getAllOfferSeasonTickets();
  }
}
