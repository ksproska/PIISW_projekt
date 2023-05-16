import { Component } from '@angular/core';
import {FormBuilder, Validators} from "@angular/forms";
import {TicketServiceService} from "../../../services/ticket-service.service";

@Component({
  selector: 'app-validity-check',
  templateUrl: './validity-check.component.html',
  styleUrls: ['./validity-check.component.css']
})
export class ValidityCheckComponent {

  constructor(private formBuilder: FormBuilder, private service: TicketServiceService) {
  }

  ticketValidity: string = ""
  checkForm = this.formBuilder.group({
      ticketID: ['', {validators: [Validators.required], updateOn: 'blur'}],
      tramID: ['']
    }
  )


  checkValidity(): void{
    let tramId = this.checkForm.controls['tramID'].value;
    let isActive = this.service.isTicketActive(
      this.checkForm.controls['ticketID'].value,
      tramId
    )
    isActive.subscribe(res => this.ticketValidity = res.message)
  }

}
