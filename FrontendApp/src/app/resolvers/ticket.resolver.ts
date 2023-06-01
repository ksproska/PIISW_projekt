import { Injectable } from '@angular/core';
import {
  Resolve,
  RouterStateSnapshot,
  ActivatedRouteSnapshot
} from '@angular/router';
import { Observable } from 'rxjs';
import {TicketInfo} from "../models/ticket-info";
import {TicketServiceService} from "../services/ticket-service.service";

@Injectable({
  providedIn: 'root'
})
export class TicketResolver implements Resolve<TicketInfo[]> {
  constructor(private readonly service: TicketServiceService) {}

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<TicketInfo[]> {
    return this.service.getAllTicketInfoForUserId(Number(localStorage.getItem("userId"))); // TODO actual user id
  }
}
