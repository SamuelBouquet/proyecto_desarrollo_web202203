import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login/login.service';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {

  constructor(private loginService: LoginService) { }

  ngOnInit(): void {
    let cookie: boolean;
    if (this.loginService.getToken()!=null){
      cookie=true
    }
    else{
      cookie=false
    }
  }

}
