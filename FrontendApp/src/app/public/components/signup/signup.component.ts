import { Component } from '@angular/core';
import {AbstractControl, FormBuilder, ValidationErrors, ValidatorFn, Validators} from "@angular/forms";

@Component({
  selector: 'app-signin',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {

  constructor(private formBuilder: FormBuilder) {
  }

  registerForm = this.formBuilder.group({
    username: ['', [Validators.required]],
    password: ['', {validators: [Validators.required, Validators.minLength(8),Validators.pattern("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).*$")], updateOn: 'blur'}],
    password2: ['', {validators: Validators.required, updateOn: 'blur'}],
  }, {validators: samePasswordValidator});

  onSubmit(){

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
