import { Component } from '@angular/core';
import {Router} from "@angular/router";

const TOKEN_NAME = 'TOKEN_BIEDA_MPK'

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent {

  constructor(private router: Router) { }


  logout(){
    localStorage.removeItem(TOKEN_NAME)
    this.router.navigate(['/login'])
  }

  isVisible(): boolean {
    return !(this.router.url === '/login' || this.router.url === '/signup')
  }

}
