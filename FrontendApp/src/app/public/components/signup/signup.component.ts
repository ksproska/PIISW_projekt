import { Component } from '@angular/core';
import { AbstractControl, FormBuilder, ValidationErrors, ValidatorFn, Validators} from "@angular/forms";
import { Router } from '@angular/router';
import { AuthService } from 'app/services/auth.service';
import { catchError, tap } from 'rxjs';

const TOKEN_NAME = 'TOKEN_BIEDA_MPK'

@Component({
  selector: 'app-signin',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {

  constructor(
    private readonly formBuilder: FormBuilder,
    private readonly authService: AuthService,
    private readonly router: Router) {
  }

  registerForm = this.formBuilder.group({
    username: ['', [Validators.required, Validators.email]],
    password: ['', {validators: [Validators.required, Validators.minLength(8), Validators.pattern("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).*$")], updateOn: 'blur'}],
    password2: ['', {validators: Validators.required, updateOn: 'blur'}],
  }, {validators: samePasswordValidator});

  onSubmit(){
    this.authService.signUp({
      username: this.registerForm.value.username!,
      password: this.registerForm.value.password!
    }).pipe(
      catchError(error => { throw error }),
      tap((respone: any) => {
        localStorage.setItem(TOKEN_NAME, 'Bearer ' + respone.token)
        localStorage.setItem("userId", respone.userId)
        this.router.navigate(['/home']);
      })).subscribe();
  }
}



export const samePasswordValidator: ValidatorFn = (control: AbstractControl): ValidationErrors | null => {
  const password = control.get('password');
  const password2 = control.get('password2');

  const error = { notMatched: true };
  const isValid = password?.value === password2?.value;
  if (!isValid) {
    password2?.setErrors(error);
  }
  return isValid ? null : error;
};
