import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Book } from './books.component';
import { or } from 'ajv/dist/compile/codegen';

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

  public paginacion(page : number , order:string, asc:boolean): Observable<any>{
    return this.http.get<any>("localhost:8081/Libro/paginados?pag=${page}$order=${order}$asc=${asc}")
  }
}
