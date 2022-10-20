import { TestBed } from '@angular/core/testing';

import { CrearLibroService } from './crear-libro.service';

describe('CrearLibroService', () => {
  let service: CrearLibroService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CrearLibroService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
