import { HttpClientModule } from '@angular/common/http';
import { TestBed } from '@angular/core/testing';
import { FormBuilder, FormsModule, ReactiveFormsModule } from '@angular/forms';

import { CrearLibroService } from './crear-libro.service';

describe('CrearLibroService', () => {
  let service: CrearLibroService;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HttpClientModule, FormsModule, ReactiveFormsModule],
      providers:[FormBuilder]
      
    })
    .compileComponents();
  });

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CrearLibroService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
