import { Component } from '@angular/core';
import { BaseCtl } from '../base.component';
import { ServiceLocatorService } from '../service-locator.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html'
})
export class UserComponent extends BaseCtl {

  constructor(public locator: ServiceLocatorService, route: ActivatedRoute) {
    super(locator.endpoints.USER, locator, route);
  }


  imagePreview: string | ArrayBuffer | null = null;

  // Handle file selection and preview
  onFileSelect(event: any): void {
    const file = event.target.files[0];
    if (file) {
      this.fileToUpload = file;
      const reader = new FileReader();
      reader.onload = () => {
        this.imagePreview = reader.result;
      };
      reader.readAsDataURL(file);
    }
  }

  today = new Date();

  // Max DOB = today - 18 years
  maxDob: string = new Date(
    this.today.getFullYear() - 18,
    this.today.getMonth(),
    this.today.getDate()
  ).toISOString().split('T')[0];

  // Optional: minimum DOB (e.g. 100 years ago)
  minDob: string = new Date(
    this.today.getFullYear() - 70,
    this.today.getMonth(),
    this.today.getDate()
  ).toISOString().split('T')[0];
}

