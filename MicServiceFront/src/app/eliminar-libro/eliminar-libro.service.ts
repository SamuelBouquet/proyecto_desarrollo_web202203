import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Book } from '../books/books.component';

@Injectable({
  providedIn: 'root'
})
export class EliminarLibroService {

  constructor(private http: HttpClient) { }

  eliminarLibro(book: Book){
    const params = new HttpParams()
      .set('id', book.id)
    const headers = new HttpHeaders()
    let body = JSON.stringify({})
    return this.http.delete("http:localhost:8081/Libro",{params  : params})
  }

}