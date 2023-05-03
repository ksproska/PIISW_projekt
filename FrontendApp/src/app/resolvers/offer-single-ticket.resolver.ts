import {Injectable} from '@angular/core';
import {
  Resolve,
  RouterStateSnapshot,
  ActivatedRouteSnapshot
} from '@angular/router';
import {Observable} from 'rxjs';
import {OfferService} from "../services/offer.service";
import {OfferSingleTicket} from "../models/offer-single-ticket";

@Injectable({
  providedIn: 'root'
})
export class OfferSingleTicketResolver implements Resolve<OfferSingleTicket[]> {
  constructor(private readonly offerService: OfferService) {}

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<OfferSingleTicket[]> {
    return this.offerService.getAllOfferSingleTickets();
  }
}
