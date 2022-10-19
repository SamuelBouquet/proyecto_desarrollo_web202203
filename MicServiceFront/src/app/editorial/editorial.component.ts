import { Component, OnInit } from '@angular/core';
import { EditorialService } from './editorial.service';

@Component({
  selector: 'app-editorial',
  templateUrl: './editorial.component.html',
  styleUrls: ['./editorial.component.css']
})
export class EditorialComponent implements OnInit {

  constructor(private editorialService: EditorialService) { }

  ngOnInit(): void {
  }

}

export interface Editorial{
  id: string;
  name: string;
}