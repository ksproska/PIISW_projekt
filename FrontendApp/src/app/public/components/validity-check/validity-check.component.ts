import { Component } from '@angular/core';
import {FormBuilder, Validators} from "@angular/forms";

@Component({
  selector: 'app-validity-check',
  templateUrl: './validity-check.component.html',
  styleUrls: ['./validity-check.component.css']
})
export class ValidityCheckComponent {

  constructor(private formBuilder: FormBuilder) {
  }

  ticketValidity: string = ""
  checkForm = this.formBuilder.group({
      ticketID: ['', {validators: [Validators.required], updateOn: 'blur'}],
      tramID: ['']
    }
  )


  checkValidity(): void{
    //TODO: w subscribe na next przypisanie wartości do ticketValidity
  }

}
