import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private formBuilder: FormBuilder) { }

  checkoutForm = this.formBuilder.group({
    login: '',
    password: '',
    passwordConfirm: '',
  });

  ngOnInit(): void {
  }

  onSubmit():void{}

}
