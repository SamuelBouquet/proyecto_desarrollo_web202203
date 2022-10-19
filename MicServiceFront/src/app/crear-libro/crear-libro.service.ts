import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Editorial } from '../editorial/editorial.component';

@Injectable({
  providedIn: 'root'
})
export class CrearLibroService {

  constructor(private http: HttpClient) { }

  crearLibro(name: string, descripcion: string, image_url: string, editorial: Editorial){
    const headers = new HttpHeaders()
    const body = {"name" : name,
                  "description" : descripcion,
                  "imageUrl" : image_url,
                  "editorial" : editorial}
    console.log(body)
    return this.http.post("http://localhost:8081/Libro", body)
  }
}
