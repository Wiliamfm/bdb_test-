import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-adopt-person',
  templateUrl: './adopt-person.component.html',
  styleUrls: ['./adopt-person.component.css']
})
export class AdoptPersonComponent implements OnInit {

  create_person_url= "http://localhost:8080/persons";

  constructor() { }

  ngOnInit(): void {
    document.getElementById("form")?.addEventListener('submit', this.submitForm);
  }
  
  submitForm(event:SubmitEvent): void {
    event.preventDefault();
    let form= <HTMLFormElement> event.currentTarget;
    let data= {
      father_document: form['father_document'].value,
      mother_document: form['mother_document'].value,
      child_document: form['idChild'].value,
    };
    //alert(typeof(form['birth_date'].value));
    alert(JSON.stringify(data));
    fetch(this.create_person_url, {
      method: 'POST',
      body: JSON.stringify(data),
      headers: {
        'Content-Type': 'application/json'
      }
    }).then(response => response.json())
    .then(data => {
      console.log(data);
      alert(`Persona adoptada con éxito.`)
      form.reset();
    }).catch(err => {
      console.log('Can not adopt the person: ', err);
      alert('No es posible adoptar a la persona con id: '+ form['idChild'].value);
    })
  }

}
