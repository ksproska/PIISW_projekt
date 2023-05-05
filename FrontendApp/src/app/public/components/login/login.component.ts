import {Component, OnInit} from '@angular/core';
import {FormBuilder, Validators} from "@angular/forms";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{

  constructor(private formBuilder: FormBuilder) {
  }

  loginForm = this.formBuilder.group({
      username: ['', {validators: [Validators.required], updateOn: 'blur'}],
      password: ['', {validators: [Validators.required], updateOn: 'blur'}]
    }
  )
  ngOnInit(): void {
  }

  onLogin(): void {
  }
}
