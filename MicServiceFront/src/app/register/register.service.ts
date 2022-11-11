import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import * as SHA256 from 'crypto-js/sha256';
import { LoginService } from '../login/login.service';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  constructor(private http: HttpClient) { }

  crearUser(user: string, password: string, name:string): Observable<any>{
    const headers = new HttpHeaders
    const body = JSON.stringify({})
    password  = SHA256(password).toString()
    const params = new HttpParams()
      .set('mail', user)
      .set('password', password)
      .set('name',name)
    console.log(params)
    return this.http.post("http://localhost:8082/Client",body,{params: params})
  }
}
