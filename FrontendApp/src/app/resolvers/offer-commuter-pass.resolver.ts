import {Injectable} from '@angular/core';
import {
  Resolve,
  RouterStateSnapshot,
  ActivatedRouteSnapshot
} from '@angular/router';
import {Observable} from 'rxjs';
import {OfferService} from "../services/offer.service";
import {OfferCommuterPass} from "../models/offer-commuter-pass";

@Injectable({
  providedIn: 'root'
})
export class OfferCommuterPassResolver implements Resolve<OfferCommuterPass[]> {
  constructor(private readonly offerService: OfferService) {
  }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<OfferCommuterPass[]> {
    return this.offerService.getAllOfferCommuterPasses();
  }
}
