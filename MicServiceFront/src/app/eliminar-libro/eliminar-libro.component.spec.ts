import { HttpClientModule } from '@angular/common/http';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { FormBuilder, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ChildrenOutletContexts, UrlSerializer } from '@angular/router';
import { RouterTestingModule } from '@angular/router/testing';

import { EliminarLibroComponent } from './eliminar-libro.component';

describe('EliminarLibroComponent', () => {
  let component: EliminarLibroComponent;
  let fixture: ComponentFixture<EliminarLibroComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EliminarLibroComponent ],
      imports: [HttpClientModule, FormsModule, ReactiveFormsModule, RouterTestingModule],
      providers:[FormBuilder, UrlSerializer, ChildrenOutletContexts]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EliminarLibroComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
