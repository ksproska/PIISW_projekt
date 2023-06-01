import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from '../../environments/environment';
import {Observable} from 'rxjs';
import {OfferSingleTicket} from "../models/offer-single-ticket";
import {OfferSeasonTicket} from "../models/offer-season-ticket";
import {OfferCommuterPass} from "../models/offer-commuter-pass";

const host = environment.backendEndpoint;
const offersApiPrefix = '/public/offers';

@Injectable({
  providedIn: 'root'
})
export class OfferService {
  constructor(private readonly http: HttpClient) {
  }

  getAllOfferSingleTickets(): Observable<OfferSingleTicket[]> {
    return this.http.get<OfferSingleTicket[]>(host + offersApiPrefix + "/singletickets");
  }

  getAllOfferSeasonTickets(): Observable<OfferSeasonTicket[]> {
    return this.http.get<OfferSeasonTicket[]>(host + offersApiPrefix + "/seasontickets");
  }

  getAllOfferCommuterPasses(): Observable<OfferCommuterPass[]> {
    return this.http.get<OfferCommuterPass[]>(host + offersApiPrefix + "/commuterpasses");
  }
}
