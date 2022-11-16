import { Component, OnInit } from '@angular/core';
import { EditorialService } from '../editorial/editorial.service';
import { Editorial } from '../editorial/editorial.component';
import { CrearLibroService } from './crear-libro.service';
import { FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-crear-libro',
  templateUrl: './crear-libro.component.html',
  styleUrls: ['./crear-libro.component.css']
})
export class CrearLibroComponent implements OnInit {

  bookForm = this.formBuilder.group({
    name: '',
    descripcion: '',
    editorial:'',
    image_url: ''
  })

  editoriales=<Editorial[]>[];

  constructor(private crearLibroService: CrearLibroService,
              private editorialService: EditorialService,
              private formBuilder: FormBuilder,
              public router: Router) { }

  ngOnInit(): void {
    this.editorialService.getAllEditorial().subscribe(
      data=>{this.editoriales=data});
  }

  onSubmit(): void{
    let bookName: string;
    let bookDesc: string;
    let bookImg: string;
    let bookEdi: Editorial;
    bookName=''+this.bookForm.value.name;
    bookDesc=''+this.bookForm.value.descripcion;
    let edi=this.editoriales.find(element=>element.name==this.bookForm.value.editorial);
    console.log("aqui va edi" , this.bookForm.value.editorial," aqui termina")
    bookEdi={"id":edi!.id, "name":edi!.name};

    bookImg=''+this.bookForm.value.image_url;
    console.log('aquiii ',edi?.id)
    console.log(this.editoriales.find(element=>element.name==this.bookForm.value.editorial))
    console.log('name:',this.bookForm.value.name)

    this.crearLibroService.crearLibro(bookName,bookDesc,bookImg,bookEdi).subscribe(
                                      data=>{console.log(data)}
    )
    this.bookForm.reset();
  }

}
