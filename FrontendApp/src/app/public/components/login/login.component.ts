import {Component, OnInit} from '@angular/core';
import {FormBuilder, Validators} from "@angular/forms";
import { Router } from '@angular/router';
import { AuthService } from 'app/services/auth.service';
import { catchError, map, tap } from 'rxjs';

const TOKEN_NAME = 'TOKEN_BIEDA_MPK'

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{

  constructor(
    private readonly formBuilder: FormBuilder,
    private readonly authService: AuthService,
    private readonly router: Router) {
  }

  loginForm = this.formBuilder.group({
      username: ['', {validators: [Validators.required], updateOn: 'blur'}],
      password: ['', {validators: [Validators.required], updateOn: 'blur'}]
    }
  )

  ngOnInit(): void {
  }

  onLogin(): void {
    this.authService.signIn({
      username: this.loginForm.value.username!,
      password: this.loginForm.value.password!
    }).pipe(
      catchError(error => { throw error }),
      tap((respone: any) => {
        localStorage.setItem(TOKEN_NAME, 'Bearer ' + respone.token)
        localStorage.setItem("userId", respone.userId)
        this.router.navigate(['/home']);
      })).subscribe();
  }
}
