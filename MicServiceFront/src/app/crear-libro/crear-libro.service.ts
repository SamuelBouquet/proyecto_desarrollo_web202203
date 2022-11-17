import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Editorial } from '../editorial/editorial.component';
import { LoginService } from '../login/login.service';

@Injectable({
  providedIn: 'root'
})

//Bearer%20eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJBZG1pbiIsInN1YiI6InBhYmxvQHBhYmxvLmNvbSIsImF1dGhvcml0aWVzIjpbIlJPTEVfVVNFUiJdLCJpYXQiOjE2Njg2MjkyMTIsImV4cCI6MTY2ODYyOTgxMn0.uNLIseT83WFRcMQz0iQt_hGrdZhD3WVJTAsHTZGGbAUWiiW_x0VPAbrSnH37_4hGXMABfxaW4jHsfQXnbFetjgBearer%20eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJBZG1pbiIsInN1YiI6InBhYmxvQHBhYmxvLmNvbSIsImF1dGhvcml0aWVzIjpbIlJPTEVfVVNFUiJdLCJpYXQiOjE2Njg2MjkyMTIsImV4cCI6MTY2ODYyOTgxMn0.uNLIseT83WFRcMQz0iQt_hGrdZhD3WVJTAsHTZGGbAUWiiW_x0VPAbrSnH37_4hGXMABfxaW4jHsfQXnbFetjg
export class CrearLibroService {

  constructor(private http: HttpClient,
              private loginService: LoginService) { }

  crearLibro(name: string, descripcion: string, image_url: string, editorial: Editorial){
    console.log(this.loginService.getToken())
    const headers = new HttpHeaders({'Authorization' : this.loginService.getToken()})
    const body= ({
                  "name" : name,
                  "description" : descripcion,
                  "imageUrl" : image_url,
                  "editorial" : editorial})
    console.log(body)
    // if(this.loginService.getToken() != null)
    //   return this.http.post("http://localhost:8081/Libro", body, {headers: {'Authorization':this.loginService.getToken()}})
    // alert("inicie sesion")
    
    return this.http.post("http://localhost:8081/Libro", body, {headers: headers, responseType:'text'})
  }

}
