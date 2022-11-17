import { HttpClientModule } from '@angular/common/http';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { FormBuilder, FormsModule, ReactiveFormsModule } from '@angular/forms';

import { BooksComponent } from './books.component';
import { BooksService } from './books.service';

describe('BooksComponent', () => {
  let component: BooksComponent;
  let fixture: ComponentFixture<BooksComponent>;
  let service  : BooksService
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BooksComponent,],
      imports: [HttpClientModule, FormsModule, ReactiveFormsModule],
      providers:[FormBuilder]
      
    })
    .compileComponents();

    fixture = TestBed.createComponent(BooksComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
    
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
