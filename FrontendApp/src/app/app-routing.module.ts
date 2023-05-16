import { NgModule } from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {LoginComponent} from "./public/components/login/login.component";
import {SignupComponent} from "./public/components/signup/signup.component";
import {HomeComponent} from "./public/components/home/home.component";
import {OfferSingleTicketResolver} from "@resolver/offer-single-ticket.resolver";
import {OfferSeasonTicketResolver} from "@resolver/offer-season-ticket.resolver";
import {OfferCommuterPassResolver} from "@resolver/offer-commuter-pass.resolver";
import {ShopComponent} from "./public/components/shop/shop.component";
import {MyTicketsComponent} from "./public/components/my-tickets/my-tickets.component";
import {TicketResolver} from "@resolver/ticket.resolver";
import {ValidityCheckComponent} from "./public/components/validity-check/validity-check.component";

const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    redirectTo: 'home',
  },
  {
    path: 'home',
    component: HomeComponent,
    resolve: {
      offerSingleTickets: OfferSingleTicketResolver,
      offerSeasonTickets: OfferSeasonTicketResolver,
      offerCommuterPass: OfferCommuterPassResolver
    }
  },
  {
    path: 'login',
    component: LoginComponent,
  },
  {
    path: 'signup',
    component: SignupComponent,
  },
  {
    path: 'shop',
    component: ShopComponent,
    resolve: {
      offerSingleTickets: OfferSingleTicketResolver,
      offerSeasonTickets: OfferSeasonTicketResolver,
      offerCommuterPass: OfferCommuterPassResolver
    }
  },
  {
    path: 'my-tickets',
    component: MyTicketsComponent,
    resolve: {
      ticketInfos: TicketResolver
    }
  },
  {
    path: 'validity',
    component: ValidityCheckComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
