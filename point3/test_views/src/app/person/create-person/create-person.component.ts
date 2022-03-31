import { Component, OnInit } from '@angular/core';
import { Data } from '@angular/router';

@Component({
  selector: 'app-create-person',
  templateUrl: './create-person.component.html',
  styleUrls: ['./create-person.component.css']
})
export class CreatePersonComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
    document.getElementById("form")?.addEventListener('submit', this.submitForm);
  }
  
  submitForm(event:SubmitEvent): void {
    let create_person_url= "http://localhot:8080/persons";
    event.preventDefault();
    let form= <HTMLFormElement> event.currentTarget;
    let fatherName= form['father'].value
    let motherName= form['mother'].value
    if(fatherName){
      fetch(create_person_url+"/"+fatherName)
      .then(response => {
        console.log(response);
      });
    }
    if(motherName){
      fetch(create_person_url+"/"+motherName)
      .then(response => {
        console.log(response);
      });
    }
    let data= {
      full_name: form['full_name'].value,
      birth_date: form['birth_date'].value,
    };
    //alert(typeof(form['birth_date'].value));
    //alert(JSON.stringify(data));
    fetch("")
  }

}
