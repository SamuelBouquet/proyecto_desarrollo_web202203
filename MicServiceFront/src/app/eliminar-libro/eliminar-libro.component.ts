import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { Book } from '../books/books.component';
import { BooksService } from '../books/books.service';
import { EliminarLibroService } from './eliminar-libro.service';

@Component({
  selector: 'app-eliminar-libro',
  templateUrl: './eliminar-libro.component.html',
  styleUrls: ['./eliminar-libro.component.css']
})
export class EliminarLibroComponent implements OnInit {

  eliminarForm = this.formBuilder.group({
    book: ''
  })

  books=<Book[]>[];
  
  constructor(private eliminarLibroService: EliminarLibroService,
              private formBuilder: FormBuilder,
              public router: Router,
              private bookService: BooksService) { }

  ngOnInit(): void {
    this.bookService.getAllBooks().subscribe(
      data=>{this.books=data}
    );
  }

  onSubmit(){
    let book: Book;
    let bk=this.books.find(element=>element.name==this.eliminarForm.value.book);
    book={"id":bk!.id, "name":bk!.name, "description":bk!.description, "image_url":bk!.image_url, "editorial":bk!.editorial};
    console.log("sdftsdfasdf"+book.id)
    if(confirm("¿Desea eliminar "+bk!.name+"?")) {
      this.eliminarLibroService.eliminarLibro(book).subscribe(data=>{console.log(data)})
      console.log(bk!.name+" fue eliminado");
      //window.location.reload()
    }
  }

}
