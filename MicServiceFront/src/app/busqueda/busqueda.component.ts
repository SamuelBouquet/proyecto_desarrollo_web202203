import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { BusquedaService } from './busqueda.service';
import { Book } from '../books/books.component';
import { Editorial } from '../editorial/editorial.component';

@Component({
  selector: 'app-busqueda',
  templateUrl: './busqueda.component.html',
  styleUrls: ['./busqueda.component.css']
})
export class BusquedaComponent implements OnInit {

  searchForm = this.formBuilder.group({
    busqueda:''
  });

  public result=<Book>{};
  public resEdi=<Editorial>{};

  constructor(private formBuilder: FormBuilder,
              private busquedaService: BusquedaService) {}

  ngOnInit(): void {
  }

  buscar(): void {
    console.log('busqueda:',this.searchForm.value.busqueda)
    let busc: string;
    let result: Book;
    let resEdi: Editorial;
    busc = ''+this.searchForm.value.busqueda;
    this.busquedaService.buscarLibro(busc).subscribe(
      data=>{console.log(data);
            this.result = data});
  }

}
