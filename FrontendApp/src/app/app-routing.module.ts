import { NgModule } from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {LoginComponent} from "./public/components/login/login.component";
import {SignupComponent} from "./public/components/signup/signup.component";
import {HomeComponent} from "./public/components/home/home.component";
import {OfferSingleTicketResolver} from "./resolvers/offer-single-ticket.resolver";
import {OfferSeasonTicketResolver} from "./resolvers/offer-season-ticket.resolver";
import {OfferCommuterPassResolver} from "./resolvers/offer-commuter-pass.resolver";

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
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
