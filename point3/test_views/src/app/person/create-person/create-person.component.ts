import { Component, OnInit } from '@angular/core';

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
    let create_person_url= "http://localhost:8080/persons";
    event.preventDefault();
    let form= <HTMLFormElement> event.currentTarget;
    let data= {
      document: form['document'].value,
      full_name: form['full_name'].value,
      birth_date: form['birth_date'].value,
      father: form['father'].value,
      mother: form['mother'].value
    };
    //alert(typeof(form['birth_date'].value));
    //alert(JSON.stringify(data));
    fetch(create_person_url, {
      method: 'POST',
      body: JSON.stringify(data),
      headers: {
        'Content-Type': 'application/json'
      }
    }).then(response => response.json())
    .then(data => {
      console.log(data);
      alert(`Persona ${data['full_name']} creada con éxito.`)
      form.reset();
    }).catch(err => {
      console.log('Can not create the person: ', err);
      alert('Ya existe una persona con el documento: '+ form['document'].value);
    })
  }

}
