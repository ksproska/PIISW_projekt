import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {TicketInfo} from "../models/ticket-info";
import {environment} from "../../environments/environment";

const host = environment.backendEndpoint;
const apiPrefix = '/tickets/ticketinfo';

@Injectable({
  providedIn: 'root'
})
export class TicketServiceService {
  constructor(private readonly http: HttpClient) {
  }

  getAllTicketInfoForUserId(userId: number): Observable<TicketInfo[]> {
    return this.http.get<TicketInfo[]>(host + apiPrefix + "/" + userId);
  }
}
