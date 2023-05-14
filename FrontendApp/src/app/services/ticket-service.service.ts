import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {TicketInfo} from "../models/ticket-info";
import {environment} from "../../environments/environment";

const host = environment.backendEndpoint;
const infoApiPrefix = '/tickets/ticketinfo';
const offerApiPrefix = '/tickets/offer';

@Injectable({
  providedIn: 'root'
})
export class TicketServiceService {
  constructor(private readonly http: HttpClient) {
  }

  getAllTicketInfoForUserId(userId: number): Observable<TicketInfo[]> {
    return this.http.get<TicketInfo[]>(host + infoApiPrefix + "/" + userId);
  }

  putSingleTicket(offerId: number, userId: number, tramId: string) {
    return this.http.put(host + offerApiPrefix + "/singleticket",
      {
        "offerId": offerId,
        "userId": userId,
        "tramId": tramId
      }
    ).subscribe();
  }

  putSeasonTicket(offerId: number, userId: number) {
    return this.http.put(host + offerApiPrefix + "/seasonticket",
      {
        "offerId": offerId,
        "userId": userId
      }
    ).subscribe();
  }

  putCommuterPass(offerId: number, userId: number) {
    return this.http.put(host + offerApiPrefix + "/commuterpass",
      {
        "offerId": offerId,
        "userId": userId
      }
    ).subscribe();
  }
}
