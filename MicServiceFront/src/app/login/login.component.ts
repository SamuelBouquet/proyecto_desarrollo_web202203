import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from './login.service'
//import sha256 from 'fast-sha256';
//import { decodeUTF8, encodeUTF8 } from 'tweetnacl-util';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

    checkoutForm = this.formBuilder.group({
      login: '',
      password: '',
    });

  constructor(private formBuilder: FormBuilder,
              private loginService: LoginService,
              public router: Router) { }

  ngOnInit(): void {
  }

  onSubmit(): void {

      let userParam: string;
      let passParam: string;
      //let passSha256: string;
      userParam = ''+this.checkoutForm.value.login;
      passParam = ''+this.checkoutForm.value.password;
      //passSha256 = encodeUTF8(sha256(decodeUTF8(passParam)));
      //console.log(passSha256);
      console.log('FormValue:', this.checkoutForm.value);
      console.log('Login:', this.checkoutForm.value.login);
      console.log('Password:', this.checkoutForm.value.password);
      this.loginService.login(userParam, passParam).subscribe(
                          data => {
                                    console.log(data);
                                    this.loginService.setToken(data.token);
                                    this.router.navigateByUrl('/');
                                  });
      this.checkoutForm.reset();
  }

}
