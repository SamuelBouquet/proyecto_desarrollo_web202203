import { HttpClientModule } from '@angular/common/http';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { FormBuilder, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ChildrenOutletContexts, UrlSerializer } from '@angular/router';
import { RouterTestingModule } from '@angular/router/testing';


import { RegisterComponent } from './register.component';

describe('RegisterComponent', () => {
  let component: RegisterComponent;
  let fixture: ComponentFixture<RegisterComponent>;
  let spy: any;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegisterComponent ],
      imports: [HttpClientModule, FormsModule, ReactiveFormsModule, RouterTestingModule],
      providers:[FormBuilder, UrlSerializer, ChildrenOutletContexts]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RegisterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it("form valid",()=>{
    component.checkoutForm.setValue({
      'login': 'a@a.com',
      'password': '12',
      'passwordConfirm': '12',
      'name': 'a',
    })
    expect(component.checkoutForm.valid).toEqual(true)
  })  

  // it("could be equals",()=>{
  //   component.checkoutForm.setValue({
  //     'login': 'a@a.com',
  //     'password': '12',
  //     'passwordConfirm': '12',
  //     'name': 'a',
  //   })
  //   // spy = spyOn(component, 'onSubmit').and.callThrough()
  //   // expect(component.onSubmit()).toHaveBeenCalledTimes(1)
    
  // }) 
});
