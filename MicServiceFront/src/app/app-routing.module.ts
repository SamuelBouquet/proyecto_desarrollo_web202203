import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { BooksComponent } from './books/books.component'
import { BusquedaComponent } from './busqueda/busqueda.component';
import { CrearLibroComponent } from './crear-libro/crear-libro.component';
import { EliminarLibroComponent } from './eliminar-libro/eliminar-libro.component';
import { LoginComponent } from './login/login.component'

const routes: Routes = [
                        { path: '', component: BooksComponent },
                        { path: 'login', component: LoginComponent },
                        { path: 'busqueda', component: BusquedaComponent},
                        { path: 'crearLibro', component: CrearLibroComponent},
                        { path: 'eliminarLibro', component: EliminarLibroComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
