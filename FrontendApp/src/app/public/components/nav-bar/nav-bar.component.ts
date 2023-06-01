import { Component } from '@angular/core';
import {Router} from "@angular/router";
import {AuthService} from "../../../services/auth.service";
import jwt_decode from "jwt-decode"

const TOKEN_NAME = 'TOKEN_BIEDA_MPK'

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent {

  constructor(private router: Router,
              private authService:AuthService) { }


  logout(){
    localStorage.removeItem(TOKEN_NAME)
    this.router.navigate(['/login'])
  }

  isLoggedIn(): boolean{
    return this.authService.getAuthorizationToken() !== null
  }

  isVisible(): boolean {
    return !(this.router.url === '/login' || this.router.url === '/signup')
  }

  getUsersRole(): string{
    let jwt = this.authService.getAuthorizationToken()!.toString()
    let role: any;
    ({authority: role} = jwt_decode(jwt));
    return role
  }
}
