import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Book } from '../books/books.component';

@Injectable({
  providedIn: 'root'
})
export class EliminarLibroService {

  constructor(private http: HttpClient) { }

  eliminarLibro(book: Book){
    console.log(book)
    //const headers = new HttpHeaders()
    return this.http.delete("http:localhost:8081/Libro/"+book.id)
  }

}
