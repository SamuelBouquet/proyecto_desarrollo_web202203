import { HttpClientModule } from '@angular/common/http';
import { TestBed } from '@angular/core/testing';

import { EliminarLibroService } from './eliminar-libro.service';

describe('EliminarLibroService', () => {
  let service: EliminarLibroService;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HttpClientModule]
      
    })
    .compileComponents();
  });

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EliminarLibroService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
