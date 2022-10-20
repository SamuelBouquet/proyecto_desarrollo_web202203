import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Editorial } from '../editorial/editorial.component';
import { EditorialService } from '../editorial/editorial.service';
import { BooksService } from './books.service';

@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.css']
})
export class BooksComponent implements OnInit {
  
  books=<Book[]>[];
  editoriales=<Editorial[]>[];
  booksFilter=<Book[]>[];

  filterForm = this.formBuilder.group({
    editorial:''
  })

  
  constructor(private booksService: BooksService,
              private editorialService: EditorialService,
              private formBuilder: FormBuilder) {}

  ngOnInit(): void {
    this.fillBooks()
    this.editorialService.getAllEditorial().subscribe(
      data=>{this.editoriales=data});
  }

  onSubmit(){
    
    let filter: Editorial;
    let edi=this.editoriales.find(element=>element.name==this.filterForm.value.editorial);
    filter={"id":edi!.id, "name":edi!.name};
    console.log(filter)
    console.log(this.books.find(element=>element.editorial.id==filter.id))
    this.booksFilter=this.books.filter(element=>element.editorial.id==filter.id)
    console.log(this.booksFilter)
    this.books=this.booksFilter
  }

  fillBooks(){
    this.booksService.getAllBooks().subscribe(
      data=>{console.log(data);
            this.books = data});
  }
}

export interface Book{
  id: string;
  name: string;
  description: string;
  image_url: string;
  editorial: Editorial;
}