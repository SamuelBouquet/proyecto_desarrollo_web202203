import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { RegisterService } from './register.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private formBuilder: FormBuilder,
              private registerService: RegisterService) { }

  checkoutForm = this.formBuilder.group({
    login: '',
    password: '',
    passwordConfirm: '',
    name: '',
  });

  ngOnInit(): void {
  }

  onSubmit():void{
    let user: string;
    let pass: string;
    let name: string;
    let passConf: string;
    user=''+this.checkoutForm.value.login;
    pass=''+this.checkoutForm.value.password;
    passConf=''+this.checkoutForm.value.passwordConfirm;
    name=''+this.checkoutForm.value.name;
    if (pass==passConf){
      this.registerService.crearUser(user,pass,name).subscribe(
        data=>{console.log(data)}
      )
    }
    else{
      alert("¡Las contraseñas no coinciden!")
    }
  }

}
