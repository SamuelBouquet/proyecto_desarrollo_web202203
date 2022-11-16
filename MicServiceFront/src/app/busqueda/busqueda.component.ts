import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { BusquedaService } from './busqueda.service';
import { Book } from '../books/books.component';
import { Editorial } from '../editorial/editorial.component';
import { BooksService } from '../books/books.service';

@Component({
  selector: 'app-busqueda',
  templateUrl: './busqueda.component.html',
  styleUrls: ['./busqueda.component.css']
})
export class BusquedaComponent implements OnInit {

  searchForm = this.formBuilder.group({
    busqueda:''
  });

  public result=<Book[]>[];
  public resEdi=<Editorial>{};
  public allBooks=<Book[]>[];

  searchTerm ='';
  term='';

  constructor(private formBuilder: FormBuilder,
              private busquedaService: BusquedaService,
              private bookService: BooksService) {}

  ngOnInit(): void {
    this.bookService.getAllBooks().subscribe(
      data=>{console.log(data);
            this.allBooks = data});
  }

  buscar(): void {
    console.log('busqueda:',this.searchForm.value.busqueda)
    let busc: string;
    busc = ''+this.searchForm.value.busqueda;

    this.result=this.allBooks.filter(element=>element.name.includes(busc))
  }

  
}
