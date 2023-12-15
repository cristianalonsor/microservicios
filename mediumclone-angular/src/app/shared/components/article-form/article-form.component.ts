import { Component, EventEmitter, Input, Output, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { ArticleFormValuesInterface } from './types/articleFormValues.interface';
import { FormBuilder, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { BackendErrorInterface } from '../../types/backendErrors.interface';
import { ErrorMessageComponent } from '../errorMessages/errorMessage.component';
import { LoadingComponent } from '../loading/loading.component';

@Component({
  selector: 'app-article-form',
  templateUrl: './article-form.component.html',
  standalone: true,
  imports: [
    RouterLink,
    FormsModule,
    CommonModule,
    LoadingComponent,
    ReactiveFormsModule,
    ErrorMessageComponent,
  ]
})
export class ArticleFormComponent implements OnInit{

  @Input() initialValues?: ArticleFormValuesInterface;
  @Input() isSubmitting: boolean = false;
  @Input() errors: BackendErrorInterface | null = null;

  @Output() articleSubmit = new EventEmitter<ArticleFormValuesInterface>();

  form = this.fb.nonNullable.group({
    title: ['', Validators.required],
    description: ['', Validators.required],
    body: ['', Validators.required],
    tagList: ['', Validators.required],
  })

  constructor(private fb: FormBuilder) {}

  ngOnInit(): void {
    this.initializeForm();
  }

  initializeForm(): void {

    if( !this.initialValues ) {
      throw new Error('No fueron provehídos valores')
    }

    this.form.patchValue({
      title: this.initialValues.title,
      description: this.initialValues.description,
      body: this.initialValues.body,
      tagList: this.initialValues.tagList.join(' '),
    })
  }

  onSubmit(): void{ 
    const formValues = this.form.getRawValue();
    const articleFormValues: ArticleFormValuesInterface = {
      ...formValues,
      tagList: formValues.tagList.split(' ')
    };
    this.articleSubmit.emit(articleFormValues);
  }

}
