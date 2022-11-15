import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Editorial } from '../editorial/editorial.component';
import { LoginService } from '../login/login.service';

@Injectable({
  providedIn: 'root'
})
export class CrearLibroService {

  constructor(private http: HttpClient,
              private loginService: LoginService) { }

  crearLibro(name: string, descripcion: string, image_url: string, editorial: Editorial){
    console.log(this.loginService.getToken())
    const headers = new HttpHeaders({'Authorization' : this.loginService.getToken()})
    const body = {"name" : name,
                  "description" : descripcion,
                  "imageUrl" : image_url,
                  "editorial" : editorial}
    console.log(body)
    return this.http.post("http://localhost:8081/Libro", body, {headers: headers})
  }
}
