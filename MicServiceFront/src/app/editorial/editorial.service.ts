import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Editorial } from './editorial.component';

@Injectable({
  providedIn: 'root'
})
export class EditorialService {

  constructor(private http: HttpClient) { }

  getAllEditorial(): Observable<any>{
    const headers = new HttpHeaders({})
    return this.http.get<Editorial>("http://localhost:8081/Libro/Editorial")
  }
}
