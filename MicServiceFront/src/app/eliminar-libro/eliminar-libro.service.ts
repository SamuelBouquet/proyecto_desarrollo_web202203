import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Book } from '../books/books.component';

@Injectable({
  providedIn: 'root'
})
export class EliminarLibroService {

  constructor(private http: HttpClient) { }

  eliminarLibro(book: Book){
    // console.log(book)
    
    const params = new HttpParams()
      .set('id', book.id)
    const headers = new HttpHeaders()
    let body = JSON.stringify({})
    return this.http.delete("http:localhost:8081/Libro",{params  : params})
  }

}
//Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJBZG1pbiIsInN1YiI6InRlc3RAdGVzdC5jb20iLCJhdXRob3JpdGllcyI6WyJST0xFX1VTRVIiXSwiaWF0IjoxNjY4NjQ2MTIwLCJleHAiOjE2Njg2NDY3MjB9.1x7PDTFPTjnyGIaYdH15ysnr7kMy_56gMRNe6bXRqyt0ymzQwOTtMSJIg12fhTJZgDhPAceE6kahiz_45vDCcA
//Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJBZG1pbiIsInN1YiI6InRlc3RAdGVzdC5jb20iLCJhdXRob3JpdGllcyI6WyJST0xFX1VTRVIiXSwiaWF0IjoxNjY4NjQ2MTIwLCJleHAiOjE2Njg2NDY3MjB9.1x7PDTFPTjnyGIaYdH15ysnr7kMy_56gMRNe6bXRqyt0ymzQwOTtMSJIg12fhTJZgDhPAceE6kahiz_45vDCcA
