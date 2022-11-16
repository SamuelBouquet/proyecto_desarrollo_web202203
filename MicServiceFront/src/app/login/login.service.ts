import { Injectable } from '@angular/core';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
import { Observable } from "rxjs";
import { CookieService } from "ngx-cookie-service";
import * as SHA256 from 'crypto-js/sha256';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient,
              private cookies: CookieService) { }

 


  login(user: string, password: string): Observable<any> {
      const headers = new HttpHeaders()
      password  = SHA256(password).toString()
      const body = JSON.stringify({})
      const params = new HttpParams()
        .set('mail', user)
        .set('password', password)
      console.log(password)
      const result = this.http.post("http://localhost:8080/login", body, {
                            params: params
                            });
      console.log(result , "aquiiii");
      return result
  }

  setToken(token: string) {
    this.cookies.set("token", token);
  }
  getToken() {
    return this.cookies.get("token");
  }
}