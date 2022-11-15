import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { CookieService } from 'ngx-cookie-service';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BooksComponent } from './books/books.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { FooterComponent } from './footer/footer.component';
import { BusquedaComponent } from './busqueda/busqueda.component';
import { EditorialComponent } from './editorial/editorial.component';
import { CrearLibroComponent } from './crear-libro/crear-libro.component';
import { EliminarLibroComponent } from './eliminar-libro/eliminar-libro.component';
import { Ng2SearchPipeModule } from 'ng2-search-filter';

@NgModule({
  declarations: [
    AppComponent,
    BooksComponent,
    NavBarComponent,
    LoginComponent,
    RegisterComponent,
    FooterComponent,
    BusquedaComponent,
    EditorialComponent,
    CrearLibroComponent,
    EliminarLibroComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    Ng2SearchPipeModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
