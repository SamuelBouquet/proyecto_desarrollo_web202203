import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  constructor(private http: HttpClient) { }

  crearUser(user: string, password: string): Observable<any>{
    const headers = new HttpHeaders
    const params = new HttpParams()
      .set('mail', user)
      .set('password', password)
    return this.http.post("http://localhost:8080/Client",{ params: params})
  }
}
