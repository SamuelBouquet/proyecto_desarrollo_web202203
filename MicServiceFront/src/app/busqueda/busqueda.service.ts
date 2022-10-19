import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Book, Editorial } from '../books/books.component';

@Injectable({
  providedIn: 'root'
})
export class BusquedaService {

  constructor(private http: HttpClient) { }

  buscarLibro(search: string): Observable<any>{
    const headers = new HttpHeaders({})
    const body = JSON.stringify({})
    return this.http.get<Book>("http://localhost:8081/Libro/"+search+"/name");
  }
}
