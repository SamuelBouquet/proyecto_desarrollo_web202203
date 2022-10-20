import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Book } from './books.component';

@Injectable({
  providedIn: 'root'
})
export class BooksService {

  constructor(private http: HttpClient) { }

  getAllBooks(): Observable<any>{
    const headers = new HttpHeaders({ 
      //'Access-Control-Allow-Origin':'*'
    })
    const body = JSON.stringify({})
    return this.http.get<Book>("http://localhost:8081/Libro", {headers: headers});
  }
}
