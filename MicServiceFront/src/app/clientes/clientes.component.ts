import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../login/login.service';
import { ClientesService } from './clientes.service';

@Component({
  selector: 'app-clientes',
  templateUrl: './clientes.component.html',
  styleUrls: ['./clientes.component.css']
})
export class ClientesComponent implements OnInit {

  constructor(private clientesService: ClientesService,
              private loginService: LoginService,
              public router: Router) { }

  clientes=<Cliente[]>[]

  ngOnInit(): void {
      this.clientesService.getClientes().subscribe(
        data=>{this.clientes = data}
      )
  }

}

export interface Cliente{
  id: number;
  email: string;
  password: string;
  name: string;
  activado: boolean;
}