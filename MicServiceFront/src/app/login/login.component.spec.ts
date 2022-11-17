import { HttpClientModule } from '@angular/common/http';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { FormBuilder, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ChildrenOutletContexts, UrlSerializer } from '@angular/router';
import { RouterTestingModule } from '@angular/router/testing';

import { LoginComponent } from './login.component';

describe('LoginComponent', () => {
  let component: LoginComponent;
  let fixture: ComponentFixture<LoginComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LoginComponent ],
      imports: [HttpClientModule, FormsModule, ReactiveFormsModule, RouterTestingModule],
      providers:[FormBuilder, UrlSerializer, ChildrenOutletContexts]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it("form valid",()=>{
    component.checkoutForm.setValue({
      'login': 'test@a.com',
      'password': '12345',
    })
    expect(component.checkoutForm.valid).toEqual(true)
  })

  it("submit called ",() => {
    component.checkoutForm.setValue({
      'login': 'test@a.com',
      'password': '12345',
    })
    component.onSubmit()
    expect(component.onSubmit()).toHaveBeenCalledTimes(1)
  })
});
