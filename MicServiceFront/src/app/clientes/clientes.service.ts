import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { LoginService } from '../login/login.service';
import { Cliente } from './clientes.component';

@Injectable({
  providedIn: 'root'
})
export class ClientesService {

  constructor(private http: HttpClient,
              private loginService: LoginService) { }

  getClientes(): Observable<any>{
    const headers = new HttpHeaders({ 
      'Authorization' : this.loginService.getToken()
    })
    const body = JSON.stringify({})
    return this.http.get<Cliente>("http://localhost:8082/Client/all");
  }


  
}
