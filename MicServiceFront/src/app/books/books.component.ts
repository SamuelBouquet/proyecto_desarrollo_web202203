import { Component, OnInit } from '@angular/core';
import { BooksService } from './books.service';

@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.css']
})
export class BooksComponent implements OnInit {
  
  books=<Book[]>[];

  
  constructor(private booksService: BooksService) {}

  ngOnInit(): void {
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
  editorial_id: string;
}
